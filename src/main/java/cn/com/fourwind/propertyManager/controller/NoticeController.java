package cn.com.fourwind.propertyManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import cn.com.fourwind.propertyManager.service.NoticeService;

@RestController
@CrossOrigin(origins="*",maxAge=3600)
public class NoticeController {
	//通知的web url
	@Autowired
	private NoticeService noticeService;

}
