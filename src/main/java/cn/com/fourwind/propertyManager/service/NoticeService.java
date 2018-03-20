package cn.com.fourwind.propertyManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.fourwind.propertyManager.repository.INoticeRepository;


@Service
public class NoticeService {
	
	@Autowired
	private INoticeRepository iNoticeRepository;

}
