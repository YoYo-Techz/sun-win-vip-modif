package bitzero.engine.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class SimpleConsoleHandlerFormatter extends Formatter {
     private static String NEW_LINE = System.getProperty("line.separator");

     public String format(LogRecord record) {
          String s = this.formatTime(record) + " : " + record.getLevel() + " : " + record.getMessage() + NEW_LINE;
          Throwable t = record.getThrown();
          if (t == null) {
               return s;
          } else {
               StackTraceElement[] elements = t.getStackTrace();
               StringBuffer sb = new StringBuffer(s);
               sb.append(" ").append(t.toString()).append(NEW_LINE);

               for(int i = 0; i < elements.length; ++i) {
                    StackTraceElement element = elements[i];
                    sb.append("\t").append(element.toString()).append(NEW_LINE);
               }

               return sb.toString();
          }
     }

     private String formatTime(LogRecord record) {
          SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss");
          return fmt.format(new Date(record.getMillis()));
     }
}
