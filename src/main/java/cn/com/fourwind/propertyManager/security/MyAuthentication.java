package cn.com.fourwind.propertyManager.security;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import cn.com.fourwind.propertyManager.repository.IAdminUserRepository;

@Component
public class MyAuthentication {
	
	@Autowired
	private IAdminUserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordencodeer;
	
	public void attemptAuthentication(String username, String password)
			throws AuthenticationException, IOException, ServletException {
			AdminUser user = userRepository.findByUsername(username);
	       if(user!=null) {
		       String passwordfromweb= passwordencodeer.encode(password);
		       if(passwordencodeer.matches(username, passwordfromweb)) {
		    	   System.out.println("equal");
		       }else {
		    	   System.out.println("密码错误");
		    	   throw new BadCredentialsException("密码错误!");
		       }
	       }else {
	    	   throw new UsernameNotFoundException("用户 【" + username + "】不存在");
	       }
	}
}
