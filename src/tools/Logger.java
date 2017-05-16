/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

/**
 * An interface for logger classes logging whatever that needs to be logged.
 * @author Coyote
 */
public interface Logger {
    
    /**
     * Logs the exception. 
     * @param exception The exception to be logged.
     */
    public void log(Exception exception);
}
