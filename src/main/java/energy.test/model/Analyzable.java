package energy.test.model;

import java.util.List;

public interface Analyzable {
    int getMin();
    int getMax();
    int getAverage();
    List<AlarmRecord> getAlarmValues();
    void reset();
}