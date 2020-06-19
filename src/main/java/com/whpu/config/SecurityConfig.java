package com.whpu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;


/**
 * @author cc
 * @create 2020-06-15-10:16
 * 1.config包下创建一个配置类  SecurityConfig 继承 WebSecurityConfigurerAdapter
 * 2.重写 configure(AuthenticationManagerBuilder auth) 方法
 * 3.配置类上添加@EnableWebSecurity注解，开启安全管理功能，该注解中包含@Configuration
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired//注入dataSource
    private DataSource dataSource;

    @Override//重写认证方法 授权
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
/*
        String p666 = encoder.encode("666");
        String p123 = encoder.encode("123");
        System.out.println(p666);
        System.out.println(p123);
*/

        //连接jdbc认证用户信息
        auth.jdbcAuthentication().passwordEncoder(encoder).
                dataSource(dataSource).
                usersByUsernameQuery("select name ,psw ,1 from h_users where name=?")
                .authoritiesByUsernameQuery("select name  ,role  from h_users where name=?");
    }
/*    @Override //页面访问权限控制
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()//对页面请求进行权限管理
                .antMatchers("/").permitAll()//不拦截 随意访问
                .antMatchers("/house/**","/users/**","/admin","/","/index").hasAuthority("房东")
                .antMatchers("/","/index","front").hasAuthority("租客")
                .anyRequest().authenticated()
                .and().formLogin();//通过系统自带的登录页面，登录进去后，上面的权限控制就会生效
    }*/
}
