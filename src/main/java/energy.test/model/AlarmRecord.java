package energy.test.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AlarmRecord {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
    
    private LocalDateTime dateTime;
    private int value;
    
    public AlarmRecord(int value) {
        this.value = value;
        this.dateTime = LocalDateTime.now();
    }
    
    @Override
    public String toString() {
        return "Alarm! " +
                "Time: " + formatter.format(dateTime) +
                ", Value: " + value;
    }
}
