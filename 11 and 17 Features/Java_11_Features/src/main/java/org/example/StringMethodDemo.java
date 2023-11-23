package org.example;

import java.util.stream.Stream;

public class StringMethodDemo {
    public void repeatDemo() {
        String str = "Java 11 ".repeat(5) + "Features";
        System.out.println(str);
    }

    public void stripDemo() {
        String str = "\n\t  Strip      ".strip();
        System.out.println(str);
    }

    public void stripLeadingDemo() {
        String str = "     StripLeading      ".stripLeading();
        System.out.println(str);
    }

    public void stripTrailingDemo() {
        String str = "   StripTrailing      ".stripTrailing();
        System.out.println(str);
    }

    public void isBlankDemo() {
        String str1 = "     ";
        String str2 = "";
        System.out.println(str1.isBlank());
        System.out.println(str2.isBlank());
    }

    public void linesDemo() {
        String str = "This is \na \rmultiline \nstring";
        Stream<String> lines = str.lines();
        lines.forEach(System.out::println);
    }
}
