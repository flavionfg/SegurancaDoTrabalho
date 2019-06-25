package com.seguranca.trabalho.controller;

import java.util.ArrayList;
import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seguranca.trabalho.Model.Empresa;
import com.seguranca.trabalho.Model.Setor;
import com.seguranca.trabalho.service.SetorService;
import com.seguranca.trabalho.service.validator.MensagemValidacaoException;

@RestController
@RequestMapping(value="/workSecurity")
public class SetorController {
	
	@Autowired
	private SetorService service;
	
	//@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/setor")
	public List<Setor> save(@Valid @RequestBody List<Setor> setores)  throws MensagemValidacaoException{
		System.out.println(setores.get(0).idEmpresa);
		if(setores.get(0).idEmpresa != null) {
			return service.insert(setores);
		}
		
		
		Empresa empresa = new Empresa();
		empresa.id = service.findSetorByIdEmpresa();
		
		List<Setor> lSetor = new ArrayList<Setor>();
		
		for(Setor setor :setores){
			setor.idEmpresa = empresa;
			lSetor.add(setor);
			
		}   
		

		return service.insert(lSetor);
	} 
	
	//@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value="/allsetor/{idEmpresa}")
	public List<Setor> findAllSetorByIdEmpresa(@PathVariable("idEmpresa") Integer id){
		return service.findAllSetorByIdEmpresa(id);
	}
}
