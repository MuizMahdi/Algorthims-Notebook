package utils;

import java.util.logging.Logger;

public abstract class Problem {
	private static final Logger log = Logger.getLogger(Problem.class.getSimpleName());

	public static void log(Object message) {
		log.info(String.valueOf(message));
	}
}
