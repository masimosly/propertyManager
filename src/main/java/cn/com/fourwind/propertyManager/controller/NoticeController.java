package cn.com.fourwind.propertyManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import cn.com.fourwind.propertyManager.service.NoticeService;

@RestController
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;

}
