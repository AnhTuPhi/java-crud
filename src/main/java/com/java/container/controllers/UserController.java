package com.java.container.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.Long;
import java.util.List;

import com.java.container.entity.User;
import com.java.container.repository.UsersRepository;
import com.java.container.service.UserService;

@Controller
public class UserController {
	//display list of user register
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = {"/list" }, method = RequestMethod.GET )
	public String listUser(Model model) {
		
		return findPaginated(1, "username", "asc", model);
	}
	
	@RequestMapping(value = {"/register" }, method = RequestMethod.GET )
	public String registerLoadForm(Model model) {
		//create model to bind data from entity
		User user = new User();
		model.addAttribute("user", user);
		return "register";
	}
	@RequestMapping(value = {"/register" }, method = RequestMethod.POST )
	public String registerUser(@ModelAttribute("user") User user) {
		//save data User to database
		userService.registerUser(user);
		return "redirect:/";
	}
	@RequestMapping(value = {"/showFormUpdate/{id}"}, method = RequestMethod.GET)
	public String showFormUpdate(@PathVariable("id") Long id , Model model) {
		//get user from service
		User user = userService.getUserById(id);
		//set user as a model to pre-populate the form
		model.addAttribute("user", user);
		
		return "updateUser";
	}
	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable("id") Long id) {
		//call delete user method
		this.userService.deleteUserById(id);
		return "redirect:/";
	}
	
	@RequestMapping(value="/page/{pageNum}")
	public String findPaginated(@PathVariable("pageNum") int pageNum,
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model
			) {
		int pageSize = 5 ;
		Page<User> page = userService.findPaginated(pageNum, pageSize, sortField, sortDir);
		List<User> listUsers = page.getContent();
		System.out.println("findPaginated");
		/*model.addAttribute("listUser", userService.getAllUsers());*/
		model.addAttribute("currentPage", pageNum);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc")?"desc":"asc");
		
		model.addAttribute("listUser", listUsers);
		return "listUser";
	}
}
