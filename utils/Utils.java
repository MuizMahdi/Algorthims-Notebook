package utils;

public class Utils {
    public static String equal(Object obj1, Object obj2) {
        return Boolean.toString(obj1 == obj2 || obj1.equals(obj2) || String.valueOf(obj1).equals(String.valueOf(obj2)) || obj1.toString().equals(obj2.toString()));
    }
}
