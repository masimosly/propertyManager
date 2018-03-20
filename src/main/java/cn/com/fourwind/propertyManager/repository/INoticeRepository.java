package cn.com.fourwind.propertyManager.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import cn.com.fourwind.propertyManager.entity.Notice;

public interface INoticeRepository extends MongoRepository<Notice, String>{

}
