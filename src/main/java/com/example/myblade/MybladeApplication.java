package com.example.myblade;

import com.blade.Blade;
import com.blade.Environment;
import com.blade.event.EventType;
import com.blade.kit.StringKit;
import com.blade.mvc.view.template.JetbrickTemplateEngine;
import com.example.myblade.model.Const;


public class MybladeApplication {

	public static void main(String[] args) {


		//Blade.me().get("/",    (request, response) -> response.text("Hello World")).start(MybladeApplication.class, args);
		// Blade.me().showFileList(true);
		//	Blade.me().addStatics("/zhaungbi").start();


		/*Blade.me().before("/*", ((request, response) -> {
			String uri = request.uri();
			if("/index".equals(uri)){
				String username = request.session().attribute(Const.LOGIN_SESSION_KEY);
				if (StringKit.isBlank(username)) {
					response.redirect("/login");
					return;
				}
			}
		}));
		Blade.me().event(EventType.SERVER_STARTED, (e) -> {
			Environment environment = e.blade.environment();
			Const.USERNAME=environment.get("app.username").get();
			Const.PASSWORD=environment.get("app.password").get();
		}).start(MybladeApplication.class);

*/
	//java.lang.NullPointerException --Exception
		Blade.me()
				.templateEngine(new JetbrickTemplateEngine())
				.start(MybladeApplication.class, args);
	}
}

