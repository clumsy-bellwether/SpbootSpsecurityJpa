package com.example.demo.security.securitySecond;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 * Created by YF-yangwen on 2018/5/31.
 * 登录参数封装类
 *
 */
public class LoginFormParamToken extends UsernamePasswordAuthenticationToken {
    private String loginName;
    private String loginpasd;

    public LoginFormParamToken(String loginName,String loginpasd){
        super(loginName,loginpasd);
        this.loginName = loginName;
        this.loginpasd = loginpasd;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public void setLoginpasd(String loginpasd) {
        this.loginpasd = loginpasd;
    }

    public String getLoginName() {
        return loginName;
    }

    public String getLoginpasd() {
        return loginpasd;
    }
}
