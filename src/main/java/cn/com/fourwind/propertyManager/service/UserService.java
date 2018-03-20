package cn.com.fourwind.propertyManager.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.fourwind.propertyManager.repository.IAdminUserRepository;
import cn.com.fourwind.propertyManager.security.AdminUser;

@Service
@Transactional
public class UserService {

	@Autowired
	private IAdminUserRepository userRepository;
	
	
	public int updateUser(AdminUser user) {
		
		userRepository.deleteByUsername(user.getUsername());
		
		userRepository.save(user);
		
		return 0;
		
		
	}
}
