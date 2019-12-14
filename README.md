# arduino-monitoring

## Android application monitoring system for HouseMonitoring, several sensors for reading data and send to application.


### 1.)Things used in this project.

NodeMCU ESP8266 Breakout Board

DHT11 Temperature & Humidity Sensor (3 pins)

SparkFun Soil Moisture Sensor (with Screw Terminals)

Seeed Grove - Gas Sensor(MQ2)

Arduino Nano R3


### 2.)Description:
This project helps you to look at your greenhouse. It consists of sensors:

DHT11 (temperature and humidity),

MQ-135 (Air Quality),

Soil Moisture.

### Step 1: 
DHT11 sensor data pin is connected to NodeMCU via D0 pin.

Soil Moisture sensor data pin is connected to NodeMCU via D1 pin.

MQ-135 sensor data pin is connected to NodeMCU via A0 pin.

VCC pin on sensors is connect to VIN pin on NodeMCU and GND pin is connect to GND pin on NodeMCU.


### Step 2: 
Arduino IDE libraries
- The required libraries are:

[FirebaseArduino.h](https://github.com/FirebaseExtended/firebase-arduino/blob/master/src/FirebaseArduino.h)

[dhtnew.h](https://github.com/RobTillaart/Arduino/blob/master/libraries/DHTNEW/dhtnew.h)

[ESP8266WiFi.h](https://github.com/esp8266/Arduino/blob/master/libraries/ESP8266WiFi/src/ESP8266WiFi.h)

[ArduinoJson.h](https://github.com/bblanchon/ArduinoJson/releases)



TL:DR
TBC
