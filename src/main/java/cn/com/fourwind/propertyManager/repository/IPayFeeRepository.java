package cn.com.fourwind.propertyManager.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import cn.com.fourwind.propertyManager.base.IBasicRepository;
import cn.com.fourwind.propertyManager.entity.PayFeeInfo;

public interface IPayFeeRepository extends IBasicRepository<PayFeeInfo>, MongoRepository<PayFeeInfo,Long>{
	public PayFeeInfo findPayFeeInfoByPayType(String type);
}
