package all.utils;

import org.slf4j.helpers.MessageFormatter;

public class Utils {
    public static String format(String message, Object... argArray) {
        return MessageFormatter.arrayFormat(message, argArray).getMessage();
    }
}
