package com.gmail.pkjkx600.webservletframework.logger;

/**
 * WebServletFramework全般で利用するログ出力クラスです。<br/>
 * 現在はlog4jを利用することを想定していますが、将来的に変更する可能性もあります。<br/>
 * 
 * @author hayato
 */
public final class LogWriter {

	private Logger _logger = null;
	
	/**
	 * コンストラクタ
	 * @param logger
	 */
	LogWriter(Logger logger) {
		this._logger = logger;
	}
	
	/**
	 * Fatalレベルでのログ出力をします
	 * @param message
	 */
	public void writeFatalMessage(String message){
		this._logger.fatalMessage(message);
	}
	
	/**
	 * Errorレベルでのログ出力をします
	 * @param mess	age
	 */
	public void writeErrorMessage(String message){
		this._logger.errorMessage(message);
	}
	
	/**
	 * Warningレベルでのログ出力をします
	 * @param message
	 */
	public void writeWarningMessage(String message){
		this._logger.warningMessage(message);
	}
	
	/**
	 * Debugレベルでのログ出力をします
	 * @param message
	 */
	public void writeDebugMessage(String message){
		this._logger.debugMessage(message);
	}
	
}
