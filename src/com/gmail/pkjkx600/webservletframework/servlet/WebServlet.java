package com.gmail.pkjkx600.webservletframework.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * サーブレットに該当するクラスを表すインターフェース
 * @author hayato
 *
 */
public interface WebServlet {
	
	/**
	 * 全てのサーブレットクラスの最初に呼ばれるメソッドです。<br/>
	 * 
	 * 初期化処理が必要な場合に利用してください。<br/>
	 * @return
	 */
	public boolean initialize();
	
	/**
	 * サーブレットクラスの処理を実行するメソッドです。<br/>
	 * 
	 * Controllerに該当するメソッドです<br/>
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public boolean execute(HttpServletRequest request,HttpServletResponse response);
	
	/**
	 * 全てのサーブレットで最後に呼ばれるメソッドです。<br/>
	 * 
	 * 終了処理が必要な場合に利用してください。<br/>
	 * @return
	 */
	public boolean shutdown();
	
	/**
	 * Viewに該当するJSPを取得するメソッドです<br/>
	 * 
	 * 指定がない場合は、JSPに遷移しません。<br/>
	 * @return
	 */
	public String getJspName();
	
	
}
