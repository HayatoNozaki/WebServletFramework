package com.gmail.pkjkx600.webservletframework.logger;

/**
 * 標準出力用ロガークラス
 * @author hayato
 *
 */
public final class StdoutLogger implements Logger {

	private static final String LOG_MESSAGE_FORMAT = "[STDOUT_LOGGER] %s : %s";
	
	/* (non-Javadoc)
	 * @see com.gmail.pkjkx600.webservletframework.logger.Logger#debugMessage(java.lang.String)
	 */
	public void debugMessage(String message) {
		System.out.println(String.format(LOG_MESSAGE_FORMAT, "DEBUG", message));
	}

	/* (non-Javadoc)
	 * @see com.gmail.pkjkx600.webservletframework.logger.Logger#errorMessage(java.lang.String)
	 */
	public void errorMessage(String message) {
		System.out.println(String.format(LOG_MESSAGE_FORMAT, "ERROR", message));
	}
	
	/* (non-Javadoc)
	 * @see com.gmail.pkjkx600.webservletframework.logger.Logger#fatalMessage(java.lang.String)
	 */
	public void fatalMessage(String message) {
		System.out.println(String.format(LOG_MESSAGE_FORMAT, "FATAL", message));
	}
	
	/* (non-Javadoc)
	 * @see com.gmail.pkjkx600.webservletframework.logger.Logger#warningMessage(java.lang.String)
	 */
	public void warningMessage(String message) {
		System.out.println(String.format(LOG_MESSAGE_FORMAT,"WARNING",message));
	}
}
