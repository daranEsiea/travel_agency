package fr.lernejo.travelsite;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TravelController {
    private final TravelService travelService = new TravelService();

    @PostMapping(value = "/inscription", consumes="application/json")
    ResponseEntity<User> postInscription(@RequestBody User information) {
        travelService.inscription(information);
        return new ResponseEntity<User>(information, HttpStatus.OK);
    }

    @GetMapping("/travels") 
    public ResponseEntity<List<Travel>> getTravels(@RequestParam String userName) {
        Travel travel1 = new Travel("Caribbean", (float) 32.4);
        Travel travel2 = new Travel("Australia", (float) 35.1);

        List<Travel> travels = new ArrayList<>();
        travels.add(travel1);
        travels.add(travel2);

        return new ResponseEntity<List<Travel>>(travels, HttpStatus.OK);
    }
}
