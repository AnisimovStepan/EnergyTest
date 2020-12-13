package energy.test.model;

import javafx.util.Pair;

public interface Measurable {
    int getValue();
    int[] getValidRange();
    String getSensorName();
}
