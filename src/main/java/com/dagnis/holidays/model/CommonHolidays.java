package com.dagnis.holidays.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class CommonHolidays {

    private LocalDate date;
    private String commonHoliday1LocalName;
    private String commonHoliday2LocalName;
}
