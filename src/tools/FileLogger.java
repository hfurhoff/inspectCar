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
 * A logger that logs to a file.
 * @author Coyote
 */
public class FileLogger implements Logger{
    private static final String LOGNAME = "sem4log.txt";
    private PrintWriter logwriter;

    /**
     * Sets up a filewriter to write to a specific file.
     */
    public FileLogger() {
        try {
            logwriter = new PrintWriter(new FileWriter(LOGNAME), true);
        } catch (IOException ex) {
            System.out.println("Logger was not created.");
        }
    }

    /**
     * @see Logger. 
     */
    @Override
    public void log(Exception exception) {
        StringBuilder logMessage = new StringBuilder();
        logMessage.append("EXCEPTION    ");
        logMessage.append(createTime());
        logMessage.append(": \n");
        logMessage.append(exception.getMessage());
        logwriter.println(logMessage);
        logwriter.println("\n");
        exception.printStackTrace(logwriter);
    }

    private String createTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        return now.format(formatter);
    }
}
