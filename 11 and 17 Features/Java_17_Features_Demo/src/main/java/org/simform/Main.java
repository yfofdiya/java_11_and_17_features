package org.simform;

import org.simform.deserialization_filters.DeserializationFiltersDemo;
import org.simform.deserialization_filters.TwoValue;
import org.simform.pattern_matching.PatternMatchingWithSwitchDemo;
import org.simform.sealed_class.PermittedClass1;
import org.simform.sealed_class.PermittedClass2;
import org.simform.sealed_class.SealedClassDemo;
import org.simform.sealed_interface.PermittedClass;
import org.simform.vector_api.VectorApiDemo;

import java.io.IOException;
import java.io.ObjectInputFilter;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Deserialization Filters Demo
        var filename = "file.ser";
        var twoValue = new TwoValue("one", "two");
//      var gadgetValue = new Gadget("one", "two"); //This will not be deserialized
        DeserializationFiltersDemo deserializationFiltersDemo = new DeserializationFiltersDemo();
        var filter1 = ObjectInputFilter.allowFilter(cl -> cl.getPackageName().contentEquals("org.simform.deserialization_filters"), ObjectInputFilter.Status.REJECTED);
        ObjectInputFilter.Config.setSerialFilter(filter1);
        ObjectInputFilter.Config.setSerialFilterFactory((f1, f2) -> ObjectInputFilter.merge(f2, f1));

        deserializationFiltersDemo.serialize(twoValue, filename);
        deserializationFiltersDemo.deserialize(filename);

        System.out.println("Hello world!");

        System.out.println("--------------------------");

        // Pattern Matching Demo
        PatternMatchingWithSwitchDemo patternMatchingWithSwitchDemo = new PatternMatchingWithSwitchDemo();
        int result = patternMatchingWithSwitchDemo.getIntegerUsingSwitch(Float.valueOf(10.6f));
        System.out.println(result);

        System.out.println("--------------------------");

        // Sealed Class Demo
        SealedClassDemo sealedClassDemo = new SealedClassDemo();
        sealedClassDemo.message();

        PermittedClass1 permittedClass1 = new PermittedClass1();
        permittedClass1.message();

        PermittedClass2 permittedClass2 = new PermittedClass2();
        permittedClass2.message();

        System.out.println("--------------------------");

        // Sealed Interface Demo
        PermittedClass permittedClass = new PermittedClass();
        int fee = permittedClass.fee();
        System.out.println("Actual Fee is " + fee);
        int defaultFee = permittedClass.getFee();
        System.out.println("Default Fee is " + defaultFee);

        System.out.println("--------------------------");

        // Vector API Demo
        int[] firstArray = IntStream.range(10, 25).toArray();
        int[] secondArray = IntStream.range(20, 35).toArray();

        VectorApiDemo vectorApiDemo = new VectorApiDemo();
        int[] arrayResult = vectorApiDemo.addTwoVectorArrays(firstArray, secondArray);

        for (int i : arrayResult) {
            System.out.print(i + " ");
        }

        System.out.println("");


    }
}