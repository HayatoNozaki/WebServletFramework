package com.gmail.pkjkx600.webservletframework.hashstorage;

import java.io.Serializable;

/**
 * HashStorageを扱うクライアント用インターフェースです。<br/>
 * @author hayato
 *
 */
public interface HSClient {
	
	/**
	 * 指定したキーに対して、データを保管します。
	 * @param <T> 型パラメータ
	 * @param key 保管キー
	 * @param value　保管データ
	 */
	public <T extends Serializable> void set(String key,T value);
	
	/**
	 * 指定したキーに該当するデータを取得します。
	 * @param <T> 型パラメータ
	 * @param key 保管キー
	 * @return 
	 */
	public <T extends Serializable> T get(String key);
	
	/**
	 * 指定したキーに該当しているデータを削除します。
	 * @param key 保管キー
	 */
	public void delete(String key);
	
}
