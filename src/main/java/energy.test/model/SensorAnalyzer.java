package energy.test.model;

import energy.test.util.Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class SensorAnalyzer implements Analyzable {
    private static final Logger logger = LogManager.getLogger(SensorAnalyzer.class.getName());
    private static final int millisecondsToCheck = 5000;
    
    private Timer timer;
    private class SensorGetValueTask extends TimerTask {
        @Override
        public void run() {
            int vl = sensor.getValue();
            logger.info(
                    String.format("Get value from sensor - %s, Value: %s",
                            sensor.getSensorName(), Util.IntegerWithPrecisionToString(vl)
                    )
            );
            int[] validRange = sensor.getValidRange();
            
            // Check alarm
            if (vl < validRange[0] || validRange[1] < vl) {
                logger.warn(
                        String.format(
                                "Warning! Danger value: %s, not in valid range [%s, %s)",
                                Util.IntegerWithPrecisionToString(vl),
                                Util.IntegerWithPrecisionToString(validRange[0]),
                                Util.IntegerWithPrecisionToString(validRange[1])
                        )
                );
                alarms.add(new AlarmRecord(vl));
            }
            
            // Calculate stats
            if (vl < min.get()) { min.getAndSet(vl); }
            if (vl > max.get()) { max.getAndSet(vl); }
            
            valuesFromSensor.add(vl);
            lastSum.getAndAdd(vl);
            
            average.getAndSet(lastSum.get() / valuesFromSensor.size());
    
            logger.info(
                    String.format("Stats from %s, min: %s, max: %s, average: %s",
                            sensor.getSensorName(),
                            Util.IntegerWithPrecisionToString(min.get()),
                            Util.IntegerWithPrecisionToString(max.get()),
                            Util.IntegerWithPrecisionToString(average.get())
                    )
            );
        }
    }
    
    private AtomicInteger min;
    private AtomicInteger max;
    private AtomicInteger average;
    private AtomicInteger lastSum;
    
    private Measurable sensor;
    
    private List<Integer> valuesFromSensor;
    private List<AlarmRecord> alarms;
    
    public SensorAnalyzer(Measurable sensor) {
        this.sensor = sensor;
    
        this.min = new AtomicInteger(0);
        this.max = new AtomicInteger(0);
        this.average = new AtomicInteger(0);
        this.lastSum = new AtomicInteger(0);
        
        this.valuesFromSensor = new CopyOnWriteArrayList<>();
        this.alarms = new CopyOnWriteArrayList<>();
        
        this.startSensorCheck();
    }
    
    private void startSensorCheck() {
        timer = new Timer();
        timer.schedule(new SensorGetValueTask(), 0, millisecondsToCheck);
    }
    
    @Override
    public void reset() {
        this.min.getAndSet(0);
        this.max.getAndSet(0);
        this.average.getAndSet(0);
        this.lastSum.getAndSet(0);
    
        valuesFromSensor.clear();
        alarms.clear();
    }
    
    @Override
    public int getMin() {
        return min.get();
    }
    
    @Override
    public int getMax() {
        return max.get();
    }
    
    @Override
    public int getAverage() {
        return average.get();
    }
    
    @Override
    public List<AlarmRecord> getAlarmValues() {
        return alarms;
    }
    
    @Override
    protected void finalize() throws Throwable {
        timer.cancel();
        timer.purge();
        super.finalize();
    }
}
