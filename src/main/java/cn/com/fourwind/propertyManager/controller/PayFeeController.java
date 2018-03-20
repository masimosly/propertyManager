package cn.com.fourwind.propertyManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.fourwind.propertyManager.entity.PayFeeInfo;
import cn.com.fourwind.propertyManager.security.JSONResult;
import cn.com.fourwind.propertyManager.service.PayFeeService;

@RestController
@RequestMapping("/pay")
public class PayFeeController {
	
	@Autowired
	private PayFeeService payFeeService;
	
	@GetMapping("/byType")
	public String findPayFeeByType(@RequestParam String type){
		return  JSONResult.toString(0, "执行成功", payFeeService.findPayFeeInfoByType(type));
	}
	@PostMapping("/save")
	public String save(@RequestBody PayFeeInfo payFeeInfo) throws Exception {
		return JSONResult.toString(0, "OK", payFeeService.save(payFeeInfo).toString());
	}

}
