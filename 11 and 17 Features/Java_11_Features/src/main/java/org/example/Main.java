package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        StringMethodDemo stringMethodDemo = new StringMethodDemo();
//        stringMethodDemo.repeatDemo();
//        stringMethodDemo.stripDemo();
//        stringMethodDemo.stripLeadingDemo();
//        stringMethodDemo.stripTrailingDemo();
//        stringMethodDemo.isBlankDemo();
//        stringMethodDemo.linesDemo();

//        ToArrayDemo toArrayDemo = new ToArrayDemo();
//        toArrayDemo.toArrayMethodDemo();
//
//        NotPredicateDemo notPredicateDemo= new NotPredicateDemo();
//        notPredicateDemo.notPredicateMethodDemo();
//
        NestBasedAccessControlDemo nestBasedAccessControlDemo = new NestBasedAccessControlDemo();
        NestBasedAccessControlDemo.NestedClass nestedClass = nestBasedAccessControlDemo.new NestedClass();
        nestedClass.message();

//        System.out.println(NestBasedAccessControlDemo.class.getNestHost());
//        System.out.println(NestBasedAccessControlDemo.NestedClass.class.getNestHost());

//        System.out.println(Arrays.toString(NestBasedAccessControlDemo.class.getNestMembers()));
//        System.out.println(Arrays.toString(NestBasedAccessControlDemo.NestedClass.class.getNestMembers()));
//
        System.out.println(NestBasedAccessControlDemo.class.isNestmateOf(NestBasedAccessControlDemo.NestedClass.class));
        System.out.println(NestBasedAccessControlDemo.NestedClass.class.isNestmateOf(NestBasedAccessControlDemo.class));
    }
}