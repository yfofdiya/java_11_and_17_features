package org.example;

import java.util.Arrays;
import java.util.List;

public class ToArrayDemo {

    public void toArrayMethodDemo() {
        List<String> list = Arrays.asList("Java", "Kotlin");
        Object[] arr = list.toArray();
        for(Object str: arr) {
            System.out.println(str);
        }
    }
}
