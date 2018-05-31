package com.example.demo.security.securitySecond;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by YF-yangwen on 2018/5/31.
 * 过滤登陆请求，获取到所有的登陆时输入的值，封装为其他对象往内部传递
 *
 */
public class LoginFormParamFilter extends UsernamePasswordAuthenticationFilter {

    public static final String UNVERIFYLOGINAME="notbeused_loginName_invalid";

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        //从request中去获取登陆时输入属性项数据封装为LoginFormParamToken对象
        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        LoginFormParamToken lfpt = new LoginFormParamToken(userName,password);

        setDetails(request,lfpt);//将请求属性和表单数据传入 authentication ??

        request.getSession().setAttribute(UNVERIFYLOGINAME,userName);//向session中添加用户名 ??

        return this.getAuthenticationManager().authenticate(lfpt);//向AuthenticationManager传递表单参数 ??
    }

}
