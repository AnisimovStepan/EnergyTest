package energy.test.util;

public final class Util {
    public static Integer getRandomIntegerInRange(int min, int max) {
        return (int)(Math.random() * (max - min + 1) + min);
    }
    
    public static String IntegerWithPrecisionToString(int value) {
        return String.valueOf(value / 100);
    }
    
}
