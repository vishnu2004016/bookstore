package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Bookentity;
import com.example.demo.repository.Bookrepository;

@RestController
public class Bookcontroller {
	@Autowired
	public Bookrepository mrepo;
	@PostMapping("/addbook")
	public Bookentity addbook(@RequestBody Bookentity mov) {
		try {
			mrepo.save(mov);
			return mov;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@PutMapping("/updatebook")
	public Bookentity updatebook(@RequestBody Bookentity mov) {
		try {
			mrepo.save(mov);
			return mov;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	@GetMapping("/getbook")
	public List<Bookentity> getbook(){
		try{
			return mrepo.findAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@DeleteMapping("/deletebook/{bookid}")
	public String deletebook(@PathVariable int bookid){
		try{
			Bookentity mov =mrepo.getOne(bookid);
			mrepo.delete(mov);
			return "Book has been removed";
		}catch(Exception e) {
			e.printStackTrace();
	
		}
		return null;
	}
	

}
