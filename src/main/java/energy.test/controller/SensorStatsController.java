package energy.test.controller;

import energy.test.DTO.StatsDTO;
import energy.test.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
@RequestMapping("/stats")
public class SensorStatsController {
    final private SensorService sensorService;
    
    @Autowired
    public SensorStatsController(SensorService sensorService) {
        this.sensorService = sensorService;
    }
    
    @GetMapping(path = "/temp", produces = {"application/json"})
    @ResponseBody
    StatsDTO getTemperatures() {
        return new StatsDTO(sensorService.getTempAnalyzer());
    }
    
    @GetMapping(path = "/hum", produces = {"application/json"})
    @ResponseBody
    StatsDTO getHumidites() {
        return new StatsDTO(sensorService.getHumAnalyzer());
    }
    
    @GetMapping(path = "/reset", produces = {"application/json"})
    @ResponseBody
    ResponseEntity setReset() {
        sensorService.reset();
        return ResponseEntity.ok().build();
    }
}