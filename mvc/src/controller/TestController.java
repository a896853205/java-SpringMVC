package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import entity.User;

import service.TestService;

@Controller
public class TestController {
	@Resource
	TestService userservice;
	
	@RequestMapping(value="addman")
	public String toSuccessPage(@RequestParam String username){
		System.out.println(username);
		User a = new User();
		a.setName(username);
		
		userservice.addUser(a);
		return "success";
	}
	@RequestMapping(value="in")
	public String toSuccessaPage(HttpServletRequest request){
		request.setAttribute("aaa", "666");
		return "index2";
	}
	
	@RequestMapping(value="dataList")
	public void dataList(HttpServletRequest request, HttpServletResponse response){
		JSONObject obj = new JSONObject();
		obj.put("status","success");
		
		String data = JSON.toJSONString(obj);
		PrintWriter printWriter = null;
		try {
			printWriter = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    printWriter.print(data);
	}
}
