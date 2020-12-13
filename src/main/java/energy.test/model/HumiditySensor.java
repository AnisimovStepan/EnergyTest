package energy.test.model;

import energy.test.util.Util;

public class HumiditySensor implements Measurable {
    // 1 * 100 for float precisions
    private static final int min = 0;
    private static final int max = 120000;
    
    // Valid range 600 and 990 C
    private static final int validMin = 60000;
    private static final int validMax = 99000;
    
    private static final int[] validRange = new int[] {validMin, validMax};
    
    private static final String name = "HUMIDITY_SENSOR" ;
    
    // Get humidity value between 0 - 1200
    @Override
    public int getValue() {
        return Util.getRandomIntegerInRange(min, max);
    }
    
    @Override
    public int[] getValidRange() {
        return validRange;
    }
    
    @Override
    public String getSensorName() {
        return name;
    }
}
