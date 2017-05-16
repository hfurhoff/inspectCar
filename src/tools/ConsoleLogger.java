/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 *
 * @author Coyote
 */
public class ConsoleLogger implements Logger{

    public ConsoleLogger() {
    }

    @Override
    public void log(Exception exception) {
        StringBuilder logMessage = new StringBuilder();
        logMessage.append("EXCEPTION    ");
        logMessage.append(createTime());
        logMessage.append(": \n");
        logMessage.append(exception.getMessage());
        System.out.println(logMessage);
        exception.printStackTrace(System.out);
        System.out.println("\n");
    }

    private String createTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        return now.format(formatter);
    }
}
