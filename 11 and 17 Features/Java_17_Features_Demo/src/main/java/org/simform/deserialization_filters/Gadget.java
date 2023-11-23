package org.simform.deserialization_filters;

import java.io.Serializable;

public record Gadget(String firstGadget, String secondGadget) implements Serializable {
}
