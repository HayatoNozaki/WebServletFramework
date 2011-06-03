package com.gmail.pkjkx600.webservletframework.logger;

import java.util.HashMap;
import java.util.Map;

/**
 * ロガークラスを生成するファクトリークラスです。<br/>
 * @author hayato
 *
 */ 
public final class LoggerRegister {

	private static LoggerRegister _own = null;
	
	static {
		_own = new LoggerRegister();
	}
	
	/**
	 * インスタンスを取得します
	 * @return
	 */
	public static LoggerRegister getInstance() {
		return _own;
	}
	
	
	Map<Class<? extends Logger>,Logger> _loggerMap = null;
	
	/**
	 * 	ロガークラスを登録します
	 * @param logger
	 */
	public void registLogger(Logger logger){
		this._loggerMap.put(logger.getClass(),logger);
	}
	
	/**
	 * 登録してあるロガークラスを取得します
	 * @param loggerClass
	 * @return
	 */
	public LogWriter getLogWriter(Class<? extends Logger> loggerClass){

		Logger logger = this._loggerMap.get(loggerClass);

		if ( logger == null ){
			return null;
		}
		
		return new LogWriter(logger);
	}
	
	/**
	 * コンストラクタ
	 */
	private LoggerRegister() {
		this._loggerMap = new HashMap<Class<? extends Logger>, Logger>();
	}
}
