package cn.com.fourwind.propertyManager.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.fourwind.propertyManager.entity.BaseMenu;
import cn.com.fourwind.propertyManager.entity.FuncInfo;
import cn.com.fourwind.propertyManager.entity.FuncUrl;
import cn.com.fourwind.propertyManager.entity.Menu;
import cn.com.fourwind.propertyManager.service.FuncInfoService;
import cn.com.fourwind.propertyManager.service.MenuService;

@RestController
@RequestMapping("/menu")
@CrossOrigin(origins="*",maxAge=3600)
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private FuncInfoService funcInfoService;

	@GetMapping("/list")
	public Object getMenu(){
		
		Map<String, Object> map = new HashMap<>();
		map.put("tree", menuService.generatorMenu());
		return map;
	}
	
	@GetMapping("/listb")
	public Object getMenub(){
		
		Map<String, Object> map = new HashMap<>();
		map.put("tree", menuService.generatorMenub());
		return map;
	}
	
	@PostMapping("/add")
	public void saveMenu(@RequestBody BaseMenu menu) {
		
		Menu realmenu = new Menu();
		
		realmenu.setIcon("icon-home");
		realmenu.setPid(menu.getPid());
		realmenu.setText(menu.getLabel());
		realmenu.setLabel(menu.getLabelEn());
		
		menuService.save(realmenu);
		
	}
	
	@GetMapping("/del/{id}")
	public void delMenu(@PathVariable Long id) {
		
		menuService.delMenu(id);
		
	}
	
	
	@PostMapping("/func/add")
	public FuncInfo addfuncinfo(@RequestBody FuncInfo one) {
		
		String funcId = one.getFuncId();
		funcInfoService.deleteFuncInfo(funcId);
		return funcInfoService.savefuncInfo(one);
		
	}
	
	@GetMapping("/func/funcurl")
	public Map<String, Object> getFuncinfoByFuncId(@RequestParam String funcId) {
		
		List<FuncInfo> list = new ArrayList<>();
		FuncInfo one = funcInfoService.getFuncInfo(funcId);
		list.add(one);
		
		Map<String, Object> returnmap = new HashMap<>();
		returnmap.put("data", list);
		return returnmap; 
	}
	
	
	@GetMapping("/func/getUrl")
	@CrossOrigin(origins="*",maxAge=3600)
	public Map<String , Object> getRouteUrl(){
		
		Map<String, Object> map = new HashMap<>();
		Map<String, Object> retdata = new HashMap<>();
		
		List<FuncInfo> list = funcInfoService.findAllFuncInfo();
		
		for (FuncInfo funcInfo : list) {
			String funcId = funcInfo.getFuncId();
			FuncUrl one = new FuncUrl();
			one.setHtml(funcInfo.getUrlHtml());
			one.setJs(funcInfo.getUrlJs());
			map.put(funcId, one);
		}
		
		retdata.put("data", map);
		return retdata;
		
	}
	
	
}
