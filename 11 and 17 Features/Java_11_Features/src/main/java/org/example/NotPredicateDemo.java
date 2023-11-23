package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NotPredicateDemo {

    public void notPredicateMethodDemo() {
        List<String> list = Arrays.asList("Java", "\n \n", "Kotlin", " ");
        List<String> withoutBlanks = list.stream()
                .filter(Predicate.not(String::isBlank))
                .collect(Collectors.toList());
        withoutBlanks.forEach(System.out::print);
    }
}
