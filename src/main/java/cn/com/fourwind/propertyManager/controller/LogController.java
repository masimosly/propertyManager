package cn.com.fourwind.propertyManager.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import cn.com.fourwind.propertyManager.entity.LogBean;

@RestController
@RequestMapping("/api/log")
@CrossOrigin(origins="*",maxAge=3600)
public class LogController {
	
	@PostMapping("/addlog")
	public void addlog(@RequestBody LogBean log) {
		
		System.out.println(log);
		
	}

}
