package com.gmail.pkjkx600.webservletframework.servlet.connector;

/**
 * データにアクセスするためのコネクタインターフェースです。<Br/>
 * 
 * @author hayato
 *
 */
public interface DataConnector {
	
	/**
	 * 指定したキーにたいしてデータを保管します
	 * @param key
	 * @param value
	 */
	public void set(String key,Object value);
	
	/**
	 * 指定したキーに該当するデータを取得します
	 * @param key
	 */
	public void get(String key);
	
	/**
	 * 該当インスタンス内のデータを削除します
	 */
	public void clear();
	
	/**
	 * 指定したキーに該当するデータを削除します
	 * @param key
	 */
	public void remove(String key);
	
	
}
