package energy.test.DTO;

import energy.test.model.AlarmRecord;
import energy.test.model.Analyzable;

import java.util.List;
import java.util.stream.Collectors;

public class StatsDTO {
    private int min;
    private int max;
    private int average;
    
    private List<String> alarms;
    
    public StatsDTO(Analyzable analyzable) {
        this.min = analyzable.getMin();
        this.max = analyzable.getMax();
        this.average = analyzable.getAverage();
        this.alarms = analyzable.getAlarmValues().stream()
                .map(AlarmRecord::toString)
                .collect(Collectors.toList());
    }
    
    public int getMin() {
        return min;
    }
    
    public void setMin(int min) {
        this.min = min;
    }
    
    public int getMax() {
        return max;
    }
    
    public void setMax(int max) {
        this.max = max;
    }
    
    public int getAverage() {
        return average;
    }
    
    public void setAverage(int average) {
        this.average = average;
    }
    
    public List<String> getAlarms() {
        return alarms;
    }
    
    public void setAlarms(List<String> alarms) {
        this.alarms = alarms;
    }
}
