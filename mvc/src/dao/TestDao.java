package dao;

import org.springframework.stereotype.Repository;

import entity.User;

@Repository
public interface TestDao {
	void addUser(User user);
}
