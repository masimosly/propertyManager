package cn.com.fourwind.propertyManager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cn.com.fourwind.propertyManager.entity.Menu;

@Repository
public interface IMenuRepository extends JpaRepository<Menu, Long>{
	@Query(value="select * from menu order by pid",nativeQuery=true)
	public List<Menu> getAllMenuData();
}
