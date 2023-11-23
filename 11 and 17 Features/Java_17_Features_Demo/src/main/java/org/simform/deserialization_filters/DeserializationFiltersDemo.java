package org.simform.deserialization_filters;

import java.io.*;

public class DeserializationFiltersDemo {
    public static void serialize(Object value, String filename) throws IOException {
        System.out.println("---serialize---");
        FileOutputStream fileOut = new FileOutputStream(filename);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(value);
        out.close();
        fileOut.close();
    }

    public static void deserialize(String filename) throws IOException, ClassNotFoundException {
        System.out.println("---deserialize");
        FileInputStream fileIn = new FileInputStream(filename);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        ObjectInputFilter intFilter = ObjectInputFilter.rejectFilter(cl -> cl.equals(Gadget.class), ObjectInputFilter.Status.UNDECIDED);
        in.setObjectInputFilter(intFilter);
        TwoValue tv = (TwoValue) in.readObject();
        System.out.println(tv);
    }
}
