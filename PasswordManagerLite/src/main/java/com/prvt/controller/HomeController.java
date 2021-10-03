package com.prvt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prvt.model.PasswordEntity;
import com.prvt.service.PasswordService;

@RestController
public class HomeController {

	@Autowired
	private PasswordService pService;
	
	//add username ,password 
	@PostMapping("/password/add")
	public PasswordEntity addDetail(@RequestBody PasswordEntity passEntity)
	{
		PasswordEntity addPassword = pService.addPassword(passEntity);
		return addPassword;
	}
	
	//view username ,password
	@GetMapping("/all")
	public List<PasswordEntity> viewDetail()
	{
		List<PasswordEntity> allPassword = pService.viewDetail();
		return allPassword;
	}
	
	//update username ,password
	@PutMapping("/password/update")
	public PasswordEntity updateDetail(@RequestBody PasswordEntity passEntity)
	{
		PasswordEntity updatePassword = pService.updateDetail(passEntity);
		return updatePassword;
	}
	
	//delete username ,password
	@DeleteMapping("/password/delete/{serialNo}")
	public PasswordEntity deleteEntry(@PathVariable Integer serialNo)
	{
		PasswordEntity deletedata = pService.deleteEntry(serialNo);
		return deletedata;
	}
	
	
	//search website
	@GetMapping("/password/search/{website}")
	public PasswordEntity searchwebsite(@PathVariable("website") String website) 
	{
		PasswordEntity searchWebsite = pService.searchWeb(website);
		return searchWebsite;	
	}
	
	//search username
	@GetMapping("/password/search/{userName}")
	public PasswordEntity searchUser(@PathVariable("userName") String userName) 
	{
		PasswordEntity searchUsers = pService.searchUser(userName);
		return searchUsers;	
	}
}
//update hibernate_sequence set next_val = 4 where next_val = 6;
//select*from hibernate_sequence;