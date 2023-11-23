// java --enable-native-access=ALL-UNNAMED --add-modules jdk.incubator.foreign ForeignFunctionDemo.java

import jdk.incubator.foreign.*;

import java.io.File;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.util.Objects;

import static jdk.incubator.foreign.CLinker.*;

public class ForeignFunctionDemo {
    private static final CLinker CLINKER = CLinker.getInstance();
    private static final SymbolLookup LOADER = SymbolLookup.loaderLookup();
    private static final SymbolLookup SYSTEM = CLinker.systemLookup();

    static {
        System.out.println("os.name=" + System.getProperty("os.name"));
        System.out.println("java.library.path="
                + String.join(System.lineSeparator() + "\t", System.getProperty("java.library.path").split(File.pathSeparator)));
    }

    static MemoryAddress lookup(String name) {
        return Objects.requireNonNull(LOADER.lookup(name).or(() -> SYSTEM.lookup(name)).get(), () -> "Not found native method: " + name);
    }

    public static void main(String... args) throws Throwable {

        strlen("Hello World");

        printf();
    }

    private static final MethodHandle STRLEN$MH = CLINKER.downcallHandle(lookup("strlen"),
            MethodType.methodType(long.class, MemoryAddress.class), FunctionDescriptor.of(C_LONG_LONG, C_POINTER));

    public static void strlen(String s) throws Throwable {
        System.out.println("strlen('" + s + "')");

        try (ResourceScope scope = ResourceScope.newConfinedScope()) {
            SegmentAllocator allocator = SegmentAllocator.arenaAllocator(scope);
            MemorySegment hello = CLinker.toCString(s, allocator);
            long len = (long) STRLEN$MH.invokeExact(hello.address());
            System.out.println(" => " + len);
        }
    }

    private static final MethodHandle PRINTF$MH = CLINKER.downcallHandle(lookup("printf"),
            MethodType.methodType(int.class, MemoryAddress.class, int.class, int.class, int.class),
            FunctionDescriptor.of(C_INT, C_POINTER, C_INT, C_INT, C_INT)
    );

    public static void printf() throws Throwable {
        System.out.println("printf()");
        int a = 10;
        int b = 7;
        try (ResourceScope scope = ResourceScope.newConfinedScope()) {
            SegmentAllocator allocator = SegmentAllocator.arenaAllocator(scope);
            MemorySegment s = CLinker.toCString("%d times %d equals %d\n", allocator);
            int rc = (int) PRINTF$MH.invokeExact(s.address(), a, b, a * b);
            System.out.println(" => rc=" + rc);
        }
    }
}
