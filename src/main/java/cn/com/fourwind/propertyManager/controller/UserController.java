package cn.com.fourwind.propertyManager.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import cn.com.fourwind.propertyManager.repository.IAdminUserRepository;
import cn.com.fourwind.propertyManager.security.AdminUser;
import cn.com.fourwind.propertyManager.service.UserService;

@RestController
@CrossOrigin(origins="*",maxAge=3600)
public class UserController {

	
	@Autowired
	private IAdminUserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/api/usermanage")
	public Map<String, Object> getAllUser(HttpServletRequest request){
		
		
		String condition = (String) request.getParameter("condition");
		String page = (String) request.getParameter("page");
		String size = (String) request.getParameter("size");
		Map<String, Object> resultMap = new HashMap<>();
		System.out.println(page);
		System.out.println(condition);
		if(condition==null) {
			Pageable pageable = new PageRequest(Integer.parseInt(page)-1, 10);//spring jpa 分页从0页开始，前台不去修改它，获取之后-1
			long total = userRepository.count();
			Page<AdminUser>  list=  userRepository.findAll(pageable);
			//查询类的按照此结构返回前台
			resultMap.put("code", 0);
			resultMap.put("message", "success");
			resultMap.put("data", list.getContent());
			resultMap.put("total", total);
		}else {
			//带了条件的查询
			Map<String, Object> map  = (Map<String, Object>) JSON.parse(condition);
			String username = (String)map.get("username");
			String type =(String)map.get("type");
			
			
			if(username==null) {
				username = "";
			}
			if(type==null) {
				type = "";
			}
			System.out.println(username);
			System.out.println(type);
			List users  = userRepository.selectUserWithCondition(username, type);
			
			//查询类的按照此结构返回前台
			resultMap.put("code", 0);
			resultMap.put("message", "success");
			resultMap.put("data", users);
			resultMap.put("total", users.size());
		}
		
		
		return resultMap;
		
	}
	
	
	@PostMapping("/api/useradd")
	public  Map<String, Object> addUser(@RequestBody AdminUser user) {
		
		
		userRepository.save(user);
		Map<String, Object> resultMap = new HashMap<>();
		Map<String, Object> resultMap2 = new HashMap<>();
		
		//非查询类的按照此结构返回前台
		resultMap2.put("code", 0);
		resultMap2.put("message", "success");
		resultMap.put("code", 0);
		resultMap.put("message", "success");
		resultMap.put("data", resultMap2);
		resultMap.put("total", 0);
		return resultMap;
		
	}
	
	
	@PostMapping("/api/userupdate")
	@Transactional
	public  Map<String, Object> modiUser(@RequestBody AdminUser user) {
		
		
		
		userService.updateUser(user);
		
		Map<String, Object> resultMap = new HashMap<>();
		Map<String, Object> resultMap2 = new HashMap<>();
		
		
		//非查询类的按照此结构返回前台
		resultMap2.put("code", 0);
		resultMap2.put("message", "success");
		resultMap.put("code", 0);
		resultMap.put("message", "success");
		resultMap.put("data", resultMap2);
		resultMap.put("total", 0);
		return resultMap;
		
	}
	
	
	@PostMapping("/api/userdel/deletes/{ids}")
	@Transactional
	public  Map<String, Object> delUsers(@PathVariable String ids) {
		
		
		
		String[] idsarry =  ids.split(",");
		
		for(int i=0;i<idsarry.length;i++) {
			
			userRepository.deleteByUsername(idsarry[i]);
		}
		
		Map<String, Object> resultMap = new HashMap<>();
		Map<String, Object> resultMap2 = new HashMap<>();
		
		resultMap2.put("code", 0);
		resultMap2.put("message", "success");
		resultMap.put("code", 0);
		resultMap.put("message", "success");
		resultMap.put("data", resultMap2);
		resultMap.put("total", 0);
		return resultMap;
		
	}
}
