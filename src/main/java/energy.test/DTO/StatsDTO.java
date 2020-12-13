package energy.test.DTO;

import energy.test.model.AlarmRecord;
import energy.test.model.Analyzable;

import java.util.List;
import java.util.stream.Collectors;

public class StatsDTO {
    int min;
    int max;
    int average;
    
    List<String> alarms;
    
    public StatsDTO(Analyzable analyzable) {
        this.min = analyzable.getMin();
        this.max = analyzable.getMax();
        this.average = analyzable.getMin();
        this.alarms = analyzable.getAlarmValues().stream()
                .map(AlarmRecord::toString)
                .collect(Collectors.toList());
    }
}
