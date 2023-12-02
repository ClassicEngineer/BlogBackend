package ru.ddev.blog.stats.api;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Map;

@Data
@Builder
public class StatisticsView {

    private Integer postCount;
    private Integer wordCount;
    private Map<LocalDate, Integer> dateToPostCount;

}
