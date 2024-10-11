package com.example.nwsl_zone.standouts;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class StandoutService {
    private final StandoutsRepository standoutsRepository;


    @Autowired
    public StandoutService(StandoutsRepository standoutsRepository) {
        this.standoutsRepository = standoutsRepository;
    }
    public List<Standouts> getStandouts() {return standoutsRepository.findAll();}
    public List<Standouts> getStandoutsById(Integer id) {
        return standoutsRepository.findAll().stream()
                .filter(standouts -> Objects.equals(standouts.getId(),id))
                .collect(Collectors.toList());
    }
    @Transactional
    public void deleteStandouts(Integer id) {
        standoutsRepository.deleteById(id);
    }
}
