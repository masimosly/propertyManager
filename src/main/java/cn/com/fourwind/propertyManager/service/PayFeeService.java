package cn.com.fourwind.propertyManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.fourwind.propertyManager.base.BasicService;
import cn.com.fourwind.propertyManager.entity.PayFeeInfo;
import cn.com.fourwind.propertyManager.repository.IPayFeeRepository;

@Service
public class PayFeeService extends BasicService<PayFeeInfo> {
	@Autowired
	private IPayFeeRepository payFeeRepository;
	
	public PayFeeInfo findPayFeeInfoByType (String type) {
		return payFeeRepository.findPayFeeInfoByPayType(type);
	}

}
