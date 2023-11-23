package org.simform.sealed_class;

sealed public class SealedClassDemo permits PermittedClass1, PermittedClass2 {
    public void message() {
        System.out.println("SealedClassDemo Message");
    }
}