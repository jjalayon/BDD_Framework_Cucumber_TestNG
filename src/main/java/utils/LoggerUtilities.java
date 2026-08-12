package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Logger utility wrapper for Log4j2
 */
public class LoggerUtilities {
    private static LoggerUtilities instance;
    private final Logger logger;

    private LoggerUtilities() {
        logger = LogManager.getLogger(LoggerUtilities.class);
    }

    public static synchronized LoggerUtilities getInstance() {
        if (instance == null) {
            instance = new LoggerUtilities();
        }
        return instance;
    }

    public void info(String message) {
        logger.info(message);
    }

    public void debug(String message) {
        logger.debug(message);
    }

    public void error(String message) {
        logger.error(message);
    }

    public void warn(String message) {
        logger.warn(message);
    }

    public void error(String message, Throwable throwable) {
        logger.error(message, throwable);
    }
}
