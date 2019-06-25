package com.seguranca.trabalho.controller;


import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seguranca.trabalho.Model.Nr;
import com.seguranca.trabalho.service.NrService;


@RestController
@RequestMapping(value="/workSecurity")
public class NrController {
	
	@Autowired
	private NrService service;

	
	@GetMapping(value="/tiponr/{id}")
	//@PreAuthorize("hasRole('ADMIN')") 
	//public Optional<Nr> findById(@PathVariable("id") String ID, @AuthenticationPrincipal UserDetails userdetails){
	public Optional<Nr> findById(@PathVariable("id") Integer id){
		
		return service.findById(id);
	}
	
}
