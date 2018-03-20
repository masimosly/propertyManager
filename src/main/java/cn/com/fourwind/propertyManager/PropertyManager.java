package cn.com.fourwind.propertyManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class PropertyManager {
	public static void main(String[] args) {
		SpringApplication.run(PropertyManager.class, args);
	}
}
