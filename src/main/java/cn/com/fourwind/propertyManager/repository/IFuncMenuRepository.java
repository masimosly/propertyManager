package cn.com.fourwind.propertyManager.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cn.com.fourwind.propertyManager.entity.FuncMenu;

public interface IFuncMenuRepository extends JpaRepository<FuncMenu, String>{

	public Page<FuncMenu> findAll(Pageable page);
	
	public FuncMenu findFuncMenuByMenuId(String menuId);
	
	@Query(nativeQuery=true,value="select * from func_menu a where a.menu_name like CONCAT('%',:menuName,'%') and a.up_menu_name like CONCAT('%',:upMenuName,'%')")
	public List<FuncMenu> selectMenuWithCondition(@Param("menuName") String username,@Param("upMenuName") String type);
	
}
