package energy.test.service;

import energy.test.model.Analyzable;
import energy.test.model.HumiditySensor;
import energy.test.model.SensorAnalyzer;
import energy.test.model.TemperatureSensor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class SensorService {
    private static final Logger logger = LogManager.getLogger(SensorService.class.getName());
    
    private Analyzable tempAnalyzer;
    private Analyzable humAnalyzer;
    
    public SensorService() {
        this.tempAnalyzer = new SensorAnalyzer(new TemperatureSensor());
        this.humAnalyzer = new SensorAnalyzer(new HumiditySensor());
    }
    
    public void reset() {
        logger.info("Reset analyzers.");
        tempAnalyzer.reset();
        humAnalyzer.reset();
    }
    
    public Analyzable getTempAnalyzer() {
        return tempAnalyzer;
    }
    
    public Analyzable getHumAnalyzer() {
        return humAnalyzer;
    }
}
