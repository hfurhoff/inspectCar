/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 * This class is a data transfer object for a specified date.
 * @author Coyote
 */
public class Date {
    
    private final int day;
    private final int month;
    private final int year;
    
    /**
     * Creates a date based on a month and an year.
     * @param expiryMonth Month of the date
     * @param expiryYear Year of the date
     */
    Date(int expiryMonth, int expiryYear) {
        day = 0;
        this.month = expiryMonth;
        this.year = expiryYear;
    }
    
    /**
     * Creates a hardcoded date of the current day.
     */
    public Date() {
        day = 4;
        month = 5;
        year = 2017;
    }
    
    /**
     * Returns the stringrepresentation of the date.
     * @return The stringrepresentation of the date.
     */
    @Override
    public String toString(){
        final boolean isAnExpiryDate = day == 0;
        final String monthAndYear = month + "/" + year;
        if(isAnExpiryDate)
            return (monthAndYear);
        else
            return (day + "/" + monthAndYear);
    }
    
}
