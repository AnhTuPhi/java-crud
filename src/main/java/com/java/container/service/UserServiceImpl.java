package com.java.container.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.java.container.entity.User;
import com.java.container.repository.UsersRepository;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UsersRepository userRepository;
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public void registerUser(User user) {
		this.userRepository.save(user);
		
	}
	
	public User getUserById(long id) {
		Optional<User> optional = userRepository.findById(id);
		User user = null;
		if(optional .isPresent()) {
			user = optional.get();
		}
		else{
			throw new RuntimeException("User not found for id :: " + id);
		}
		return user;
	}

	public void deleteUserById(Long id) {
		this.userRepository.deleteById(id);
		
	}

	public Page<User> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending():
			Sort.by(sortField).descending();
		Pageable pageable = PageRequest.of(pageNum -1, pageSize, sort);
		return this.userRepository.findAll(pageable);
	}

}
