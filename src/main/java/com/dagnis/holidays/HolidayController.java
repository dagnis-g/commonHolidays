package com.dagnis.holidays;

import com.dagnis.holidays.model.CommonHolidays;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HolidayController {

    private final HolidayService holidayService;

    public HolidayController(HolidayService holidayService) {
        this.holidayService = holidayService;
    }

    @Operation(summary = "Get common holidays")
    @GetMapping("/holidays/{country1}/{country2}/{year}/")
    public List<CommonHolidays> getCommonHolidays(@PathVariable String country1,
                                                  @PathVariable String country2,
                                                  @PathVariable String year) {
        return holidayService.getCommonHolidays(country1, country2, year);
    }
}
