package cn.com.fourwind.propertyManager.security;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cn.com.fourwind.propertyManager.service.FuncMenuService;

@RestController
public class LoginController{
	
	@Autowired
	MyAuthentication authentication;
	
	@Autowired
	private FuncMenuService funcMenuServ;
	
//	@PostMapping("/login")
//	public String login(HttpServletRequest request,HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
//			String username = request.getParameter("username");
//			String password = request.getParameter("password");
//			System.out.println("username="+username);
//			System.out.println("password="+password);
//			try {
//				authentication.attemptAuthentication(username,password);
//			}catch (Exception e) {
//				return  JSONResult.fillResultString(-1, "failed", e.getMessage());
//			}
//			TokenAuthenticationService.addAuthentication(response, username);
//			return  JSONResult.fillResultString(0, "success", "登录成功");
//	}
	@PostMapping("/login")
	public Map<String, Object> login(@RequestBody Map<String, Object> user ,HttpServletResponse response)  {
		String username = user.get("username").toString();
		String password = user.get("password").toString();
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("status", 0);
		resultMap.put("message", "OK");
		try {
			//密码校验
			authentication.attemptAuthentication(username,password);
		}catch (Exception e) {
			resultMap.put("status", -1);
			resultMap.put("message", "执行失败");
			resultMap.put("result", e.getMessage());
			return resultMap;
		}
		String jwt = TokenAuthenticationService.addAuthentication(response, username);
		resultMap.put("jwt", jwt);
		resultMap.put("result", user);
		return resultMap;
	}
	
	@GetMapping("/api/logout")
	@CrossOrigin(origins="*",maxAge=3600)
	public String  test() {
		return  JSONResult.toString(0, "success", "test");
	}
	
	@GetMapping("/api/account/menuandcontr")
	@CrossOrigin(origins="*",maxAge=3600)
	public Map<String, Object> getmenuandcontr(){
		
		
		Map<String, Object> map =  new HashMap<>();
		
		map.put("menus", funcMenuServ.getmenuctrl());
		
		map.put("ctrls", new HashMap<>());
		
		return map;
		
	}
}
