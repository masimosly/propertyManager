package cn.com.fourwind.propertyManager.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cn.com.fourwind.propertyManager.security.AdminUser;
@Transactional
public interface IAdminUserRepository extends JpaRepository<AdminUser, Long>{
	public AdminUser findByUsername(String name);
	
	public Page<AdminUser> findAll(Pageable page);
	
	
	public int deleteByUsername(String name);
	
	@Query(nativeQuery=true,value="select * from admin_user a where a.username like CONCAT('%',:username,'%') and a.type like CONCAT('%',:type,'%')")
	public List<AdminUser> selectUserWithCondition(@Param("username") String username,@Param("type") String type);
}
