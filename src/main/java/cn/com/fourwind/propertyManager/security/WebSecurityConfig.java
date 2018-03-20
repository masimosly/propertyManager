package cn.com.fourwind.propertyManager.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * 
 * @author damit
 * 登录流程：
 *  1 login请求会被放过，调用LoginController的login方法
 *  2 方法内调用attemptAuthentication，如验证成功，调用addAuthentication把token写入response的body
 * 操作验证流程：
 *  1 除login外的其他请求会被JWTAuthenticationFilter拦截
 *  2 内部调用getAuthentication方法获取登录的authentication
 *  3 如果authentication==null,则直接返回403 Access Denied
 *  
 *  
 */





@Configuration
@EnableWebSecurity
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	@Bean
	public AuthenticationManager getAuthenticationManager() throws Exception {
		
		return authenticationManager();
	}

    // 设置 HTTP 验证规则
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 关闭csrf验证
        http.csrf().disable()
                // 对请求进行认证
                .authorizeRequests()
                // 所有 / 的所有请求 都放行
                .antMatchers("/").permitAll()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                // 所有 /login 的POST请求 都放行
                .antMatchers("/login").permitAll()
                // 所有请求需要身份认证
                .anyRequest().authenticated()
        .and()
                // 添加一个过滤器验证其他请求的Token是否合法
                .addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
//                 添加一个过滤器 所有访问 /login 的请求交给 JWTLoginFilter 来处理 这个类处理所有的JWT相关内容
//                .addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),
//                 UsernamePasswordAuthenticationFilter.class)
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        // 使用自定义身份验证组件
//        auth.authenticationProvider(new CustomAuthenticationProvider());
//
//    }
}