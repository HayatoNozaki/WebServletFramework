package com.gmail.pkjkx600.webservletframework.logger;

/**
 * ロガーインターフェースです
 * @author hayato
 */
public interface Logger {
	
	/**
	 * 致命的メッセージを出力します
	 * @param message
	 */
	void fatalMessage(String message);
	
	/**
	 * エラーのメッセージを出力します
	 * @param message
	 */
	void errorMessage(String message);
	
	/**
	 * 警告のメッセージを出力します
	 * @param message
	 */
	void warningMessage(String message);
	
	/**
	 * デバッグのメッセージを出力します
	 * @param message
	 */
	void debugMessage(String message);
	
}
