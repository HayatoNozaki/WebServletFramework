package com.gmail.pkjkx600.webservletframework.hashstorage;

import java.io.Serializable;

import com.gmail.pkjkx600.webservletframework.Version;

/**
 * HSシステムの設定データを扱うデータクラスです。<br/>
 * 全てのクラスはこの設定を利用して処理を行います。<br/>
 * @author hayato
 *
 */
public final class HSInformation implements Serializable{

	private static final long serialVersionUID = 6910611185887501826L;

	/**
	 * 格納するファイル名をどのように決定するかを表す定数クラスです。<br/>
	 * @author hayato
	 *
	 */
	public enum StoreFileNameType {
		BASE_KEY(1),
		HASH_KEY(2),
		;

		private int _type = 0;
		
		/**
		 * コンストラクタ
		 * @param type
		 */
		private StoreFileNameType(int type){
			this._type = type;
		}
	}
	
	
	private int _depth = 0;
	private String _hashStorageVersion = null;
	private StoreFileNameType _fileNameType = null;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return String.format("HASH_STORAGE_VERSION : %s \nDepth:%d\n",this._hashStorageVersion,this._depth);
	}
	
	/**
	 * HashStorageの深さを取得します
	 * @return
	 */
	public int getDepth() {
		return this._depth;
	}
	
	/**
	 * 格納するファイル名をどのような形式で変換するのかを取得します。<br/>
	 * @return
	 */
	public StoreFileNameType getStoreFileNameType() {
		return this._fileNameType;
	}
	
	/**
	 * コンストラクタ。<br/>
	 * @param depth 
	 */
	HSInformation(int depth,StoreFileNameType type) {
		this._hashStorageVersion = Version.THIS_VERSION;
		this._depth = depth;
		this._fileNameType = type;
	}
	
}
