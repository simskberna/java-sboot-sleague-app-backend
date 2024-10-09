package com.example.nwsl_zone.key_stats;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class StatsService {
    private final StatsRepository statsRepository;

    @Autowired
    public StatsService(StatsRepository statsRepository) {
        this.statsRepository = statsRepository;
    }
    public List<Stats> getStats() {
        return statsRepository.findAll();
    }
    public List<Stats> getStatsById(Long id) {
        return statsRepository.findAll().stream()
                .filter(stats -> Objects.equals(stats.getId(), id))
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteStat(Integer id){
        statsRepository.deleteById(id);
    }

}
