package cn.com.fourwind.propertyManager.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.fourwind.propertyManager.entity.FuncMenu;
import cn.com.fourwind.propertyManager.repository.IFuncMenuRepository;

@Service
public class FuncMenuService {

	@Autowired 
	private IFuncMenuRepository funcMenuRepository;
	
	public int savemenu(FuncMenu funcMenu) {
		
		
		FuncMenu oo = funcMenuRepository.findFuncMenuByMenuId(funcMenu.getUpMenuId());
		
		String upMenuName = oo.getMenuName();
		
		funcMenu.setUpMenuName(upMenuName);
		
		funcMenuRepository.save(funcMenu);
		
		return 0;
	}
	
	public int updatemenu(FuncMenu funcMenu) {
		
		String id = funcMenu.getMenuId();
		
		funcMenuRepository.delete(id);
		
		funcMenuRepository.save(funcMenu);
		
		return 0;
	}
	
	
	public List<FuncMenu> getmenuctrl(){
		
		List<Map<String, Object>> list = new LinkedList<>();
		
		List<FuncMenu> listmenu =  funcMenuRepository.findAll();
		
		return listmenu;
		
	}
}
