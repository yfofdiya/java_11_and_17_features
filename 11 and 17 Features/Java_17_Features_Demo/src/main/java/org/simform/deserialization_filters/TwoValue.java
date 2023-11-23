package org.simform.deserialization_filters;

import java.io.Serializable;

public record TwoValue(String firstValue, String secondValue) implements Serializable {
}
