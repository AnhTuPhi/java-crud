package com.java.container.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.java.container.entity.User;

public interface UserService {
	List<User> getAllUsers();
	void registerUser(User user);
	User getUserById(long id);
	void deleteUserById(Long id);
	Page<User> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection);
}
