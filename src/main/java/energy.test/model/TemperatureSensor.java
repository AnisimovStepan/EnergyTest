package energy.test.model;

import energy.test.util.Util;

public class TemperatureSensor implements Measurable {
    // 1 * 100 for float precisions
    private static final int min = -1000;
    private static final int max = 4000;
    
    // Valid range +10 C and +29 C
    private static final int validMin = 1000;
    private static final int validMax = 2900;
    
    private static final int[] validRange = new int[] {validMin, validMax};
    
    private static final String name = "TEMPERATURE_SENSOR" ;
    
    // Get temperature value between -10 C and +40 C
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
