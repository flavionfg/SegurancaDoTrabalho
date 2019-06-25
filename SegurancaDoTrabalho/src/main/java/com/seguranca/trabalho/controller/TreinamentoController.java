package com.seguranca.trabalho.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seguranca.trabalho.Model.Treinamento;
import com.seguranca.trabalho.service.TreinamentoService;
import com.seguranca.trabalho.service.TreinamentoService.Response;

@RestController
@RequestMapping(value="/workSecurity")
public class TreinamentoController {
	
	@Autowired
	private TreinamentoService service;
	
	//@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/treinamento")
	public Treinamento save(@Valid @ RequestBody Treinamento treinamento) {
				
		return service.insert(treinamento);
	}
	
	//@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value="/treinamento/{id}")
	public Optional<Treinamento> findById(@PathVariable("id") Integer id){
		return service.findById(id);
	}
	
	//@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value="/treinamentos/{cpfUser}")
	public List<Response> findByIds(@PathVariable("cpfUser") String cpfUser){
		
		return service.findEmpresaByCpfUser(cpfUser);
	
	}
	
}
