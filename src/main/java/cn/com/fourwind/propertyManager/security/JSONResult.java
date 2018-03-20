package cn.com.fourwind.propertyManager.security;

import org.json.JSONException;
import org.json.JSONObject;

public class JSONResult {

	 public static String toString(Integer status, String message, Object result){
	        JSONObject jsonObject=null;
	        System.out.println("result=="+result);
			try {
				jsonObject = new JSONObject(){{
				    put("status", status);
				    put("message", message);
				    put("result", result);
				}};
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return jsonObject.toString();
	    }
}
