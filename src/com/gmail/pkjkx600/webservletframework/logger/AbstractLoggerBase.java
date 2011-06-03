package com.gmail.pkjkx600.webservletframework.logger;

/**
 * ロガー機能を実装した抽象クラスです。<br/>
 * @author hayato
 *
 */
public abstract class AbstractLoggerBase {
	
	protected LogWriter stdoutLogger = LoggerRegister.getInstance().getLogWriter(StdoutLogger.class);
	
}
