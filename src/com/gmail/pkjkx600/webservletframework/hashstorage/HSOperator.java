package com.gmail.pkjkx600.webservletframework.hashstorage;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import com.gmail.pkjkx600.webservletframework.logger.LogWriter;
import com.gmail.pkjkx600.webservletframework.logger.LoggerRegister;
import com.gmail.pkjkx600.webservletframework.logger.StdoutLogger;

/**
 * HashStorage operating class.
 * @author hayato
 *
 */
public final class HSOperator {

	private static final int MAX_DIREC_COUNT = 128;
	
	public static void main(String[] args){
		
		try{
			initialize(2,"/dev/shm");
		}
		catch(Throwable e){
			System.out.println(e.getMessage());	
		}
	}
	
	/**
	 * HashStorage用のディレクトリ生成処理を実行します。<br/>
	 * @param depth
	 * @param rootDirectory
	 */
	public static void initialize(int depth,String rootDirectory) {

		LoggerRegister.getInstance().registLogger(new StdoutLogger());
		
		LogWriter logWriter = 
			LoggerRegister.getInstance().getLogWriter(StdoutLogger.class);
		
		try{
			// HashStorageの指定ルー土ディレクトリから現在の環境情報を取得する
			HSInformation information = 
				HSOperator.getHashStorageInformation(rootDirectory);
			
			// informationファイルが存在していない場合はディレクトリの初期化を実施する
			if ( information == null ){
				initDirectory(depth,rootDirectory);				
				logWriter.writeDebugMessage("ディレクトリ生成処理完了");
			}
			else{
				logWriter.writeDebugMessage("初期化済み領域確認");
			}
			
		}
		catch(Exception e){
			logWriter.writeFatalMessage(e.getMessage());
		}
	}
	
	/**
	 * HashStorageのメタ情報を読み出して取得します。<br/>
	 * <br/>
	 * メタ情報は指定したディレクトリ直下に隠しファイルとして存在します。<br/>
	 * 通常このファイルを手動にて更新することはありません。<br/>
	 * 
	 * @param rootDirectory
	 * @return
	 */
	public static HSInformation getHashStorageInformation(String rootDirectory){
		
		HSInformation information = null;
		File file = new File(rootDirectory + "/" + HSConstantValue.HASH_STORAGE_META_FILENAME);
		InputStream is = null;
		ObjectInputStream ois = null;
		
		try{
			is = new FileInputStream(file);
			ois = new ObjectInputStream(is);
			
			information = (HSInformation)ois.readObject();
		}
		catch(FileNotFoundException e) {
			// ファイルが存在しない場合はなにもしない
		}
		catch(IOException e){
			throw new HSRuntimeException(e.getMessage());
		}
		catch(ClassCastException e){
			throw new HSRuntimeException(e.getMessage());
		}
		catch(ClassNotFoundException e){
			throw new HSRuntimeException(e.getMessage());
		}
		finally{
			
			// 終了処理を実施
			try{
				if ( ois != null ){
					ois.close();
				}
				if ( is != null ){
					is.close();
				}
			}
			catch(Exception e){
				// Nothing to do.
			}
		}
		
		return information;
	}
	
	/**
	 * 指定したディレクトリから指定した階層分ディレクトリを作成します
	 * @param depth
	 * @param path
	 * @return
	 */
	private static int initDirectory(int depth,String path){
		
		for ( int i=0 ; i<MAX_DIREC_COUNT ; i++){
			String hexName = String.format("%02x",i);
						
			String fileFullPath = path+"/"+hexName;

			if ( depth > 1 ){
				initDirectory(depth-1,fileFullPath);
			}
			
			File file = new File(fileFullPath);
			file.mkdirs();

			/*
			 * TODO: 通常のHashStorageExceptionクラスを作成
			 * TODO: EntryPoint 周りのテスト
			 * TODO: jar 生成用のant生成作業
			 */
						
		}
		
		// 全てのディレクトリ生成処理が完了した段階で、メタ情報を出力
		HSInformation information = new HSInformation(depth,HSInformation.StoreFileNameType.HASH_KEY);
		
		// ファイル出力
		File file = new File(path + "/" + HSConstantValue.HASH_STORAGE_META_FILENAME);
		OutputStream os = null;
		ObjectOutputStream oos = null;
		
		try{
			os = new FileOutputStream(file);
			oos = new ObjectOutputStream(os);
			
			oos.writeObject(information);
		}
		catch(IOException e){
			throw new HSRuntimeException(e.getMessage());
		}
		finally{
			try{
				if ( oos != null ){
					oos.close();
				}
				
				if ( os != null ){
					os.close();
				}
			}
			catch(Exception e){
				// Nothing to do.
			}
		}
		
		return 0;
	}
	
	/**
	 * Constructor.
	 */
	private HSOperator() {
		// Nothing to do.
	}
}
