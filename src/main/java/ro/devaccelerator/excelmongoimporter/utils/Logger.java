package ro.devaccelerator.excelmongoimporter.utils;

import org.slf4j.LoggerFactory;

/**
 * Static logger to decouple from sl4j
 *
 * @author bogdan
 */
public class Logger {

	private static final Object[] EMPTY_ARRAY = {};

	public static void warn(final Object source, final String message) {
		warn(source, message, EMPTY_ARRAY);
	}

	public static void warn(final Object source, final String message, final Object... args) {
		if (isWarnEnabled(source)) {
			targetLogger(source).warn(message, args);
		}
	}

	public static void info(final Object source, final String message) {
		info(source, message, EMPTY_ARRAY);
	}

	public static void info(final Object source, final String message, final Object... args) {
		if (isInfoEnabled(source)) {
			targetLogger(source).info(message, args);
		}
	}

	public static void debug(final Object source, final String message) {
		debug(source, message, EMPTY_ARRAY);
	}

	public static void debug(final Object source, final String message, final Object... args) {
		if (isDebugEnabled(source)) {
			targetLogger(source).debug(message, args);
		}
	}

	public static void error(final Object source, final String message) {
		error(source, message, EMPTY_ARRAY);
	}

	public static void error(final Object source, final String message, final Object... args) {
		targetLogger(source).error(message, args);
	}

	public static boolean isDebugEnabled(final Object source) {
		return targetLogger(source).isDebugEnabled();
	}

	public static boolean isInfoEnabled(final Object source) {
		return targetLogger(source).isInfoEnabled();
	}

	public static boolean isWarnEnabled(final Object source) {
		return targetLogger(source).isWarnEnabled();
	}

	private static org.slf4j.Logger targetLogger(final Object source) {
		if (source instanceof Class) {
			return LoggerFactory.getLogger((Class<?>) source);
		}
		else if (source instanceof String) {
            return LoggerFactory.getLogger(String.class.cast(source));
		}
		return LoggerFactory.getLogger(source.getClass());
	}
}
