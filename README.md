Design a Spring based application that simulates a small edge controller.

 

The application should provide the following functions:

 

1) There is a small simulator that simulates a humidity sensor and temperature sensor. This generates every 30 seconds two values: current humidity value + temperature value.

2) There is a small analysis instance that collects and analyzes the simulator data. This analysis instance stores min and max values (store only in memory). If a value exceeds a certain threshold, an alarm is stored (value can be hardcoded).

3) It is possible to query the data via a web frontend (nice UI is not important :D). For this the user presses a button and sees the current min & max values for both sensors + at which times an alarm was generated and which value was present. With a reset button the values can be reset.

 

Invest max. 3 hours

URL to open in localhost `http://localhost:8081/`