package fr.lernejo.prediction;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TemperatureController {
    private final TemperatureService temperatureServiceService = new TemperatureService();

    @GetMapping("/temperature")
    public ResponseEntity<?> getTemperature(@RequestParam String country) {
        System.out.println("ohohoho");
        try {
            double temp1 = temperatureServiceService.getTemperature(country);
            double temp2 = temperatureServiceService.getTemperature(country);
            List<Temperature> temperatures = Arrays.asList(new Temperature("2021-12-04", temp1), new Temperature("2021-12-03", temp2));
            Country countryTemp = new Country(country, temperatures);
            return new ResponseEntity<Country>(countryTemp, HttpStatus.OK);
        }catch (UnknownCountryException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }
}
