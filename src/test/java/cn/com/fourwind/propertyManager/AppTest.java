package cn.com.fourwind.propertyManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.com.fourwind.propertyManager.entity.PayFeeInfo;
import cn.com.fourwind.propertyManager.service.PayFeeService;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest 
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
	@Autowired
	PayFeeService Service;
	@Test
	public void contextLoads() throws Exception{
		PayFeeInfo payFeeInfo = new PayFeeInfo();
		payFeeInfo.setAmount(100.00);
		payFeeInfo.setCurrentDegree("101");
		payFeeInfo.setLastDegree("45");
		payFeeInfo.setBak("备注");
		payFeeInfo.setPayType("1");
		payFeeInfo.setUnit("吨");
		payFeeInfo.setUserId("1");
//		Service.save(payFeeInfo);
		System.out.println(Service.findPayFeeInfoByType("1"));
		System.out.println(Service.findById("5a912dce9a1f0f2300e93552"));
		
//		PasswordEncoder passwordencodeer =new BCryptPasswordEncoder();
//		passwordencodeer.encode("admin");
//		
//        userRepository.save(new AdminUser("admin", passwordencodeer.encode("admin")));
//        System.out.println("111"+userRepository.findByUsername("admin"));
    }
}
