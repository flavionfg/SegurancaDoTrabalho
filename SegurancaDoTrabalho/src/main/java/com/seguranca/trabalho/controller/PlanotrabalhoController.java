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

import com.seguranca.trabalho.Model.PlanoTrabalho;
import com.seguranca.trabalho.service.PlanoTrabalhoService;
import com.seguranca.trabalho.service.PlanoTrabalhoService.Plano;

@RestController
@RequestMapping(value="/workSecurity")
public class PlanotrabalhoController {
	
	@Autowired
	private PlanoTrabalhoService service;
	
	//@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/planotrabalho")
	public PlanoTrabalho save(@Valid @ RequestBody PlanoTrabalho planoTrabalho ) {
		return service.insert(planoTrabalho);
	}
	
	//@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value="/planotrabalho/{id}")
	public Optional<PlanoTrabalho> findById(@PathVariable("id") Integer id){
		return service.findById(id);
	}
	
	//@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value="/planostrabalho/{idEmpresa}")
	public List<PlanoTrabalho> findPlanoTrabalhoByIdEmpresa(@PathVariable("idEmpresa") Integer id){
		return service.findPlanoTrabalhoByIdEmpresa(id);
	}
	
	//@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value="/planotrabalhos/{cpfUser}")
	public List<Plano> findByIds(@PathVariable("cpfUser") String cpfUser){
		
		return service.findEmpresaByCpfUser(cpfUser);
	
	}
	
	
	
}
