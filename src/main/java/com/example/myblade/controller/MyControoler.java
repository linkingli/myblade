package com.example.myblade.controller;

import com.blade.kit.StringKit;

import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.Path;
import com.blade.mvc.annotation.PostRoute;
import com.blade.mvc.http.Request;
import com.blade.mvc.http.Response;
import com.blade.mvc.http.Session;
import com.example.myblade.model.Const;
import com.example.myblade.model.User;

/*@Path : 标注一个类是控制器类，可用于类上
@Route : 标注一个路由请求
@GetRoute : 标注一个 GET 请求
@PostRoute : 标注一个 POST 请求
@PutRoute : 标注一个 PUT 请求
@DeleteRoute : 标注一个 DELETE 请求
@JSON : 标注该方法返回值是一段 JSON，框架会自动将返回值解析为JSON输出*/
@Path
public class MyControoler {

    @GetRoute("index")
    public String index() {
        return "index.html";
    }

    @GetRoute("login")
    public String login() {
        return "login.html";
    }

    @PostRoute("login")
    public String doLogin(User user, Request request, Response response) {

        if (StringKit.isBlank(user.getUsername())) {
            request.attribute("error", "用户名不能为空");
            return "index.html";
        }

        if (StringKit.isBlank(user.getPassword())) {
            request.attribute("error", "用户名不能为空");
            return "login.html";
        }

        if (!Const.USERNAME.equalsIgnoreCase(user.getUsername()) ||
                !Const.PASSWORD.equalsIgnoreCase(user.getPassword())) {

            request.attribute("error", "用户名或密码错误");
            return "login.html";
        }

        request.session().attribute(Const.LOGIN_SESSION_KEY, user.getUsername());

        response.redirect("/index");

        return null;
    }

    @GetRoute("logout")
    public void logout(Session session, Response response) {
        session.removeAttribute(Const.LOGIN_SESSION_KEY);
        response.redirect("/login");
    }

}
