package com.gmail.pkjkx600.webservletframework.hashstorage;

import java.io.Serializable;

import com.gmail.pkjkx600.webservletframework.logger.AbstractLoggerBase;

/**
 * HashStorageを扱う為のクライアントクラスです。<br/>
 * 追加・削除などのオペレーションの一切を受け持ちます。<br/>
 * @author hayato
 *
 */
public final class HSClientImpl extends AbstractLoggerBase implements HSClient {
	
	private HSInformation _information = null;
	
	/* (non-Javadoc)
	 * @see com.gmail.pkjkx600.webservletframework.hashstorage.HSClient#get(java.lang.String)
	 */
	public <T extends Serializable> T get(String key) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/* (non-Javadoc)
	 * @see com.gmail.pkjkx600.webservletframework.hashstorage.HSClient#set(java.lang.String, java.io.Serializable)
	 */
	public <T extends Serializable> void set(String key, T value) {
		
	}
	
	/* (non-Javadoc)
	 * @see com.gmail.pkjkx600.webservletframework.hashstorage.HSClient#delete(java.lang.String)
	 */
	public void delete(String key) {
		
	}
	
	HSClientImpl(HSInformation information) {
		this._information = information;
	}
	
}
