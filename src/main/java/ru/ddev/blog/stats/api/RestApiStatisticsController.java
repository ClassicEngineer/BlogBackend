package ru.ddev.blog.stats.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/stats")
public class RestApiStatisticsController {

    @GetMapping
    public ResponseEntity<StatisticsView> getStats() {
        return ResponseEntity.ok(StatisticsView.builder()
                        .wordCount(1000)
                        .postCount(33)
                        .dateToPostCount(Map.of(LocalDate.now(), 3, LocalDate.of(1997, Month.AUGUST, 29), 100))
                .build());
    }

}

