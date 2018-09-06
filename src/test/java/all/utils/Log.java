package all.utils;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

public class Log extends Throwable {
    private static Logger errorLogger = (Logger) LoggerFactory.getLogger("[Webinar Autotests] - Error detected");
    private static Logger simpleLogger = (Logger) LoggerFactory.getLogger("[Webinar Autotests]");

    public static void setLevel(Level level) {
        Logger rootLogger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        rootLogger.setLevel(level);
    }


    public static void info(String message, Object... argArray) {
        simpleLogger.info(message, argArray);
    }

    public static void warn(String message, Object... argArray) {
        simpleLogger.warn(message, argArray);
    }

    public static void error(String message, Object... argArray) {
        errorLogger.error(message, argArray);
    }

    public static void error(Exception error) {
        errorLogger.error("Exception occurs", error);
    }

    public static void proxyCall(String methodName, String logId) {
        Log.warn("Method will be overridden: {}()\t LogID: {}", methodName, logId);
    }
}
