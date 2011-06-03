package com.gmail.pkjkx600.webservletframework.hashstorage;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.net.ssl.SSLEngineResult.HandshakeStatus;

import com.gmail.pkjkx600.webservletframework.hashstorage.HSInformation.StoreFileNameType;

/**
 * HashStorage用の共通関数を定義するクラス
 * @author hayato
 *
 */
final class HSLogic {
	
	/**
	 * 指定したキーをパス名に変換します。<br/>
	 * @param key
	 * @param information
	 * @return
	 */
	public static String convertKey2Pathname(String key,HSInformation information){
		
		if ( information == null ){
			throw new IllegalArgumentException();
		}
				
		int depth = information.getDepth();
		
		String workString = key;
		int diffCount = depth - key.length();
		if ( key.length() < depth ){
			StringBuilder sb = new StringBuilder(100);
			sb.append(key);
			for(int i=0;i<diffCount;i++){
				sb.append(HSConstantValue.DIFF_CHARACTER);
			}
			workString = sb.toString();
		}
		
		int wordSize = workString.length();
		String[] splitKeys = new String[depth];
		
		int wordMaxCount = wordSize / depth;
		int splitKeyCounter = 0;
		long modTotal = 0L;
		for(int i=0;i<wordSize;){
			
			if ( i + wordMaxCount > wordSize ){
				String modString = workString.substring(i);
				
				int modStringCount = modString.length();
				for(int j=0;j<modStringCount;j++){
					modTotal += (int)modString.charAt(j);
				}
			}
			else{
				splitKeys[splitKeyCounter++] = workString.substring(i,i+wordMaxCount);
			}
			
			i+=wordMaxCount;
		}
		
		// 全てのコードをたしこむ。
		long asciiCodes[] = new long[splitKeys.length];
		int asciiCodeIndex = 0;
		for(String targetString : splitKeys ){
			
			long splitKeyTotalCode = 0L;
			for(int i =0;i<targetString.length();i++){
				splitKeyTotalCode += (int)targetString.charAt(i);
			}
			
			long splitModKeyCode = ( splitKeyTotalCode + ( modTotal / depth )) % HSConstantValue.MAX_DIRECTORY_COUNT_HEX;
			
			asciiCodes[asciiCodeIndex++] = splitModKeyCode;
		}
		
		StringBuilder sb = new StringBuilder(100);
		for(int i=0;i<depth;i++){
			sb.append(HSConstantValue.SLASH).append(String.format("%02x",asciiCodes[i]));
		}
		
		//　最後にファイル名を付与して、終了
		String storeFileName = key;
		sb.append(HSConstantValue.SLASH).append(convertFileName(storeFileName,information)).append(HSConstantValue.FILE_EXT_NAME);
		
		return sb.toString();
	}
	
	/**
	 * 保管するファイル名に対して、規定の演算をして文字列を返却します。<br/>
	 * @param targetKey
	 * @param informatino
	 * @return
	 */
	private static String convertFileName(String targetKey,HSInformation information){
		
		// なにもせず、キーをファイル名として扱う
		if ( information.getStoreFileNameType() == HSInformation.StoreFileNameType.BASE_KEY){
			return targetKey;
		}
		
		// キーの文字コードをそう合計した数字をファイル名として扱う
		if ( information.getStoreFileNameType() == HSInformation.StoreFileNameType.HASH_KEY ){
			
			long totalKeyCode = 0L;
			int keySize = targetKey.length();
			
			for(int i=0;i<keySize;i++){
				totalKeyCode += (int)targetKey.charAt(i);
			}
			
			return String.valueOf(totalKeyCode);
		}
		
		throw new IllegalArgumentException();
	}
	
	public static void main(String[] args){

		HSInformation information = new HSInformation(2,StoreFileNameType.HASH_KEY);
		
		Map<String,Integer> totalMap = new HashMap<String, Integer>();
		
		for(long i=0;i<1000;i++){
			String targetKey = UUID.randomUUID().toString();
			String path = HSLogic.convertKey2Pathname(targetKey,information);			
			
			Integer counter = totalMap.get(path);
			
			if ( counter == null ){
				totalMap.put(path,Integer.valueOf(1));
			}
			if ( counter != null ){
				counter = Integer.valueOf(counter.intValue() + 1);
				totalMap.put(path,counter);
			}
			
		}
	
		// todo: 重複問題を解決しましょう。
		for(Map.Entry<String,Integer> entry : totalMap.entrySet()){
			if ( entry.getValue().intValue() > 1 ){
				
				
				
				System.out.println(entry.getKey() + ":" + entry.getValue());
			
			}
		}
		
	}
	
	private HSLogic() {
		// Nothing to do.
	}
}
