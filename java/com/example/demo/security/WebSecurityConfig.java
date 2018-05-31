package com.example.demo.security;

import com.example.demo.security.securitySecond.LoginFormParamFilter;
import com.example.demo.security.securitySecond.LoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Created by YF-yangwen on 2018/5/28.
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    UserDetailsService customUserService() {
        return new CustomUserService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService());
    }

    /**
     * 不需要登陆就可以访问的路径，无需权限
     * */
    public static final String [] ALLAUTHS={"/","/login","/pub/**","/index**","/error**", "/ui/**",
            "/css/**", "/js/**","/fonts/**","/assets/**","/resource/**","/fileInfo/lookFile**",
            "/assets_ganzi/**","/img/**","/ganziqiantao/**","/fileInfo/downloadFile","/assets_bazhong/**"};

    @Autowired
    private LoginSuccessHandler successHandler;
    @Bean
    public LoginFormParamFilter defineLoginFilter(){
        LoginFormParamFilter paramFilter =new LoginFormParamFilter();
        AuthenticationManager manager=null;
        try{
            manager=this.authenticationManager();
        }catch (Exception e){
            e.printStackTrace();
        }
        paramFilter.setAuthenticationManager(manager);
        paramFilter.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/login","POST"));
        paramFilter.setAuthenticationSuccessHandler(successHandler);
        return paramFilter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {//服务器启动时配置1
        http.addFilterBefore(this.defineLoginFilter(), UsernamePasswordAuthenticationFilter.class);

        http.authorizeRequests().antMatchers(ALLAUTHS)
                .permitAll().anyRequest().authenticated();//无需登录访问路径

        http.authorizeRequests()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login").failureUrl("/login?error").permitAll().and()
                .logout().permitAll();
    }
}
