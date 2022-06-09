package com.dagnis.holidays;

import com.dagnis.holidays.model.CommonHolidays;
import com.dagnis.holidays.model.Holiday;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class HolidayService {
    public List<CommonHolidays> getCommonHolidays(String country1, String country2, String year) {

        List<Holiday> country1Holidays = getHolidaysFromApi(country1, year);
        List<Holiday> country2Holidays = getHolidaysFromApi(country2, year);

        return findCommonHolidays(country1Holidays, country2Holidays);
    }

    private List<Holiday> getHolidaysFromApi(String country, String year) {

        final String uri = "https://date.nager.at/api/v3/publicholidays/" + year + "/" + country;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Holiday[]> response = restTemplate.getForEntity(uri, Holiday[].class);
        Holiday[] holidays = response.getBody();
        return Arrays.asList(Objects.requireNonNull(holidays));
    }

    private List<CommonHolidays> findCommonHolidays(List<Holiday> country1Holidays, List<Holiday> country2Holidays) {
        List<CommonHolidays> commonHolidays = new ArrayList<>();

        for (Holiday holiday1 : country1Holidays) {
            for (Holiday holiday2 : country2Holidays) {
                if (holiday1.checkIfSame(holiday2)) {
                    commonHolidays.add(new CommonHolidays(holiday1.getDate(),
                            holiday1.getLocalName(),
                            holiday2.getLocalName()));
                }
            }
        }
        return commonHolidays;
    }
}
