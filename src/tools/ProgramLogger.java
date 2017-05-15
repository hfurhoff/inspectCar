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
public class ProgramLogger {
    private static final String LOGNAME = "sem4log.txt";
    private static final ProgramLogger THIS = new ProgramLogger();
    private PrintWriter logwriter;

    public static ProgramLogger getLogger() {
        return THIS;
    }

    private ProgramLogger() {
        try {
            logwriter = new PrintWriter(new FileWriter(LOGNAME), true);
        } catch (IOException ex) {
            System.out.println("Logger was not created.");
        }
    }

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
