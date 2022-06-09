package com.dagnis.holidays.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Holiday {

    private LocalDate date;
    private String localName;
    private String name;

    public boolean checkIfSame(Holiday holiday) {
        return date.equals(holiday.getDate())
                && name.equals(holiday.getName());
    }
}
