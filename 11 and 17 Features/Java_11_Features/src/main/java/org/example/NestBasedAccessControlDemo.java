package org.example;

public class NestBasedAccessControlDemo {

    private void display() {
        System.out.println("hello from private method");
    }

    class NestedClass{
        void message() {
            display();
        }
    }
}
