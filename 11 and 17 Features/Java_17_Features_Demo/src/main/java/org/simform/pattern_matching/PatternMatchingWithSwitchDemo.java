package org.simform.pattern_matching;

public class PatternMatchingWithSwitchDemo {

//    public int getIntegerUsingIf(Object o) {
//        int result;
//        if (o instanceof Double) {
//            result = ((Double) o).intValue();
//        } else if (o instanceof Float) {
//            result = ((Float) o).intValue();
//        } else if (o instanceof String) {
//            result = Integer.parseInt(((String) o));
//        } else {
//            result = 0;
//        }
//        return result;
//    }

    public int getIntegerUsingSwitch(Object o) {
        return switch (o) {
            case Double d -> d.intValue();
            case Float f -> f.intValue();
            default -> 0;
        };
    }
}
