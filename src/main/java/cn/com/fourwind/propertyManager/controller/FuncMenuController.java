package cn.com.fourwind.propertyManager.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import cn.com.fourwind.propertyManager.entity.FuncMenu;
import cn.com.fourwind.propertyManager.repository.IFuncMenuRepository;
import cn.com.fourwind.propertyManager.service.FuncMenuService;

@RestController
@RequestMapping("/funcmenu")
@CrossOrigin(origins="*",maxAge=3600)
public class FuncMenuController {
	
	@Autowired
	private FuncMenuService funcMenuServ;
	
	@Autowired
	private IFuncMenuRepository funcMenuRepository;
	@PostMapping("/add")
	public Map<String, Object> addnewfunc(@RequestBody FuncMenu funcMenu){
		
		
		
		funcMenuServ.savemenu(funcMenu);
		Map<String, Object> resultMap = new HashMap<>();
		Map<String, Object> resultMap2 = new HashMap<>();
		
		//非查询类的按照此结构返回前台
		resultMap2.put("code", 0);
		resultMap2.put("message", "success");
		resultMap.put("code", 0);
		resultMap.put("message", "success");
		resultMap.put("data", resultMap2);
		resultMap.put("total", 0);
		
		return resultMap;
	}
	
	
	@GetMapping("/list")
	public Map<String, Object> getfuncmenulist(HttpServletRequest request){
		
		String condition = (String) request.getParameter("condition");
		String page = (String) request.getParameter("page");
		String size = (String) request.getParameter("size");
		Map<String, Object> resultMap = new HashMap<>();
		
		if(condition==null) {
			Pageable pageable = new PageRequest(Integer.parseInt(page)-1, 10);//spring jpa 分页从0页开始，前台不去修改它，获取之后-1
			long total = funcMenuRepository.count();
			Page<FuncMenu>  list=  funcMenuRepository.findAll(pageable);
			//查询类的按照此结构返回前台
			resultMap.put("code", 0);
			resultMap.put("message", "success");
			resultMap.put("data", list.getContent());
			resultMap.put("total", total);
		}else {
			//带了条件的查询
			Map<String, Object> map  = (Map<String, Object>) JSON.parse(condition);
			String menuName = (String)map.get("menuName");
			String upMenuName =(String)map.get("upMenuName");
			
			
			if(menuName==null) {
				menuName = "";
			}
			if(upMenuName==null) {
				upMenuName = "";
			}
			
			List menus  = funcMenuRepository.selectMenuWithCondition(menuName, upMenuName);
			
			//查询类的按照此结构返回前台
			resultMap.put("code", 0);
			resultMap.put("message", "success");
			resultMap.put("data", menus);
			resultMap.put("total", menus.size());
		}
		
		return resultMap;
		
	}
	
	@PostMapping("/update")
	public Map<String, Object> updatefunc(@RequestBody FuncMenu funcMenu){
		
		
		
		funcMenuServ.updatemenu(funcMenu);
		Map<String, Object> resultMap = new HashMap<>();
		Map<String, Object> resultMap2 = new HashMap<>();
		
		//非查询类的按照此结构返回前台
		resultMap2.put("code", 0);
		resultMap2.put("message", "success");
		resultMap.put("code", 0);
		resultMap.put("message", "success");
		resultMap.put("data", resultMap2);
		resultMap.put("total", 0);
		
		return resultMap;
	}
	
	
	@PostMapping("/deletes/{ids}")
	public Map<String, Object> deletefunc(@PathVariable String ids){
		
		String[] idsarry =  ids.split(",");
		
		for(int i=0;i<idsarry.length;i++) {
			
			funcMenuRepository.delete(idsarry[i]);
		}
		
		Map<String, Object> resultMap = new HashMap<>();
		Map<String, Object> resultMap2 = new HashMap<>();
		
		resultMap2.put("code", 0);
		resultMap2.put("message", "success");
		resultMap.put("code", 0);
		resultMap.put("message", "success");
		resultMap.put("data", resultMap2);
		resultMap.put("total", 0);
		return resultMap;
	}

}
