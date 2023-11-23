package org.simform.sealed_interface;

public sealed interface SealedInterfaceDemo permits PermittedClass {

    int fee();

    default int getFee() {
        return 1000;
    }
}
