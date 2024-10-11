package com.example.nwsl_zone.standouts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/standouts")
public class StandoutsController {
    private final StandoutService standoutsService;

    @Autowired
    public StandoutsController(StandoutService standoutsService){
        this.standoutsService = standoutsService;
    }
    @GetMapping
    public List<Standouts> getStandouts(@RequestParam(required = false) Integer id) {
        if (id != null) {
            return standoutsService.getStandoutsById(id);
        }
        else{
            return standoutsService.getStandouts();
        }
    }

    @DeleteMapping("/{standoutId}")
    public ResponseEntity<String> deleteStandout(@PathVariable Integer standoutId) {
        standoutsService.deleteStandouts(standoutId);
        return new ResponseEntity<>("Statistic deleted successfully.", HttpStatus.OK);
    }
}
