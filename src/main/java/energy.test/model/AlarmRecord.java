package energy.test.model;

import energy.test.util.Util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AlarmRecord {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
    
    private LocalDateTime dateTime;
    private int value;
    
    AlarmRecord(int value) {
        this.value = value;
        this.dateTime = LocalDateTime.now();
    }
    
    @Override
    public String toString() {
        return "Alarm! " +
                "Time: " + formatter.format(dateTime) +
                ", Value: " + Util.IntegerWithPrecisionToString(value);
    }
}
