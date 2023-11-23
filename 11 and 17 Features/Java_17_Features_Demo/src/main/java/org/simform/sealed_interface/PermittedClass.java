package org.simform.sealed_interface;

public non-sealed class PermittedClass implements SealedInterfaceDemo {


    @Override
    public int fee() {
        return 1500;
    }

    @Override
    public int getFee() {
        return SealedInterfaceDemo.super.getFee();
    }
}
