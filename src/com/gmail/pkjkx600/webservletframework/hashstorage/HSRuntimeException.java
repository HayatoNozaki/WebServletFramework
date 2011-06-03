package com.gmail.pkjkx600.webservletframework.hashstorage;

/**
 * Hashストレージ用のランタイム例外クラスです
 * @author hayato
 *
 */
public class HSRuntimeException extends RuntimeException {
	
	private static final long serialVersionUID = -6482277610312756892L;

	private String _exceptionMessage = null;
	
	/**
	 * コンストラクタ
	 */
	public HSRuntimeException(String message) {
		this._exceptionMessage = message;
	}
	
	/**
	 * 例外用メッセージを取得します
	 * @return
	 */
	public String getExceptionMessage() {
		return this._exceptionMessage;
	}
}
