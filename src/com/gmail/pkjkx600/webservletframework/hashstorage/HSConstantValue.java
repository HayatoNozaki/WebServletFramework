package com.gmail.pkjkx600.webservletframework.hashstorage;

/**
 * HashStorage関連の定数定義クラスです
 * @author hayato
 *
 */
public final class HSConstantValue {
	
	/**
	 * HashStorageシステムのメタ情報を表すファイル名です。<br/>
	 * ルートディレクトリ直下にあることを想定しています。
	 */
	public static final String HASH_STORAGE_META_FILENAME = ".metaHashStorage";
	 
	/**
	 * 最大のディレクトリ数を設定します。<br/>
	 * これ以上越えたディレクトリ数は、他の数字に加算され、適切な場所に配置されます。<br/>
	 */
	public static final int MAX_DIRECTORY_COUNT_HEX = 128;
	
	public static final String SLASH = "/";
	
	public static final String FILE_EXT_NAME = ".hsfile";
	
	public static final String DIFF_CHARACTER = "*";
	
	/**
	 * コンストラクタ
	 */
	private HSConstantValue() {
		// Nothing to do.
	}
}
