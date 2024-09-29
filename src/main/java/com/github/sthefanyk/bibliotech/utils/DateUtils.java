package com.github.sthefanyk.bibliotech.utils;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class DateUtils {

    public static LocalDate stringToLocalDate(String dateString) {
        try {
            return LocalDate.parse(dateString);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format: " + dateString);
        }
    }
}

