/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Calendar;
import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;

/**
 * This class is a data transfer object for a specified date.
 * @author Coyote
 */
public class Date {
    
    private final int day;
    private final int month;
    private final int year;
    
    /**
     * Creates a datebased on a month and an year.
     * @param expiryMonth Month of the date
     * @param expiryYear Year of the date
     */
    Date(int expiryMonth, int expiryYear) {
        day = 0;
        this.month = expiryMonth;
        this.year = expiryYear;
    }
    
    /**
     * Creates a date of the current day.
     */
    public Date() {
        day = DAY_OF_MONTH;
        month = MONTH;
        year = YEAR;
    }
    
}
