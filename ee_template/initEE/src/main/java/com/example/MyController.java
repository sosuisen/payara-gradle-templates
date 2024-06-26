package com.example;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import lombok.NoArgsConstructor;

/**
 * Jakarta MVCのコンロトーラクラスです。@Controllerアノテーションを付けましょう。
 * 
 * コントローラクラスはCDI beanであることが必須で、必ず@RequestScopedを付けます。
 * 
 * CDI beanには引数のないコンストラクタが必須なので、
 * Lombokの@NoArgsConstructorで空っぽのコンストラクタを作成します。
 * 
 * @Path はこのクラス全体が扱うURLのパスで、Jakarta RESTのアノテーションです。
 * これは @ApplicationPath からの相対パスとなります。
 * パスの先頭の/と末尾の/はあってもなくても同じです。
 */
@Controller
@RequestScoped
@NoArgsConstructor(force = true)
@Path("/")
public class MyController {

	/**
	 *  Modelsはコントローラクラスのメソッドから、
	 *  ViewであるJSP側へオブジェクトを渡すためのJakarta MVCの仕組み。
	 */
	@Inject
	private Models models;

	/**
	 * @GET アノテーションは、メソッドが処理するHTTPリクエストメソッドを特定する
	 * リクエストメソッド指示子（Request method designator）の１つです。
	 * 
	 * @Path はクラス全体が扱うパスからの相対パスとなります。
	 */
	@GET
	@Path("about")
	public String about() {
		// ViewとなるJSP側へ名前を付けてオブジェクトを渡すことができます。
		models.put("appName", "サンプルアプリ");

		// JSPファイル名を返します。
		// JSPファイルはデフォルトでは /webapp/WEB-INF/views の下に置きます。
		return "about.jsp";
	}

}
