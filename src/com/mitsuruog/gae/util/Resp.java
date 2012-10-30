package com.mitsuruog.gae.util;

import static javax.servlet.http.HttpServletResponse.*;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slim3.controller.Navigation;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

/**
 * Response処理のUtilityクラス
 * @author mitsuruog
 *
 */
public class Resp {

	private final static String CONTENT_TYPE_JSON = "application/json";
	private final static String CONTENT_TYPE_HTML = "text/html";
	private final static String CHAR_ENCODE_UTF_8 = "UTF-8";

	/**
	 * ログインURLへリダイレクト
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	public static Navigation redirectLoginForm(HttpServletRequest req, HttpServletResponse resp) throws IOException{
	    UserService service = UserServiceFactory.getUserService();
        return new Navigation(service.createLoginURL(req.getRequestURI()), true);
	}

	/**
	 * JSONでResponseを返す
	 * @param resp
	 * @param json
	 * @throws IOException
	 */
	public static void responseJson(HttpServletResponse resp, String json) throws IOException{
		resp.setContentType(CONTENT_TYPE_JSON);
		resp.setCharacterEncoding(CHAR_ENCODE_UTF_8);
		resp.setStatus(SC_OK);
		resp.getWriter().print(json);
	}

	/**
	 * text/htmlでReaponseを返す
	 * @param resp
	 * @throws IOException
	 */
	public static void responseHtml(HttpServletResponse resp) throws IOException{
		resp.setContentType(CONTENT_TYPE_HTML);
		resp.setCharacterEncoding(CHAR_ENCODE_UTF_8);
		resp.setStatus(SC_OK);
	}

	/**
	 * エラーページへ遷移
	 * @param resp
	 * @param message
	 * @throws IOException
	 */
	public static void responseError(HttpServletResponse resp, String message) throws IOException {
		resp.sendError(SC_INTERNAL_SERVER_ERROR);
	}

}
