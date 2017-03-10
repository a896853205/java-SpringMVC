package service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.TestDao;
import entity.User;

@Service
public class TestService {
	@Resource
	TestDao dao;
	
	public void addUser(User user){
		dao.addUser(user);
	}
}
