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

import com.seguranca.trabalho.Model.Empresa;
import com.seguranca.trabalho.service.EmpresaService;
import com.seguranca.trabalho.service.validator.MensagemValidacaoException;

@RestController
@RequestMapping(value="/workSecurity")
public class EmpresaController {
	

	@Autowired
	private EmpresaService service;
	
	//@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/empresa")
	public Empresa save(@Valid @RequestBody Empresa empresa)  throws MensagemValidacaoException {
		Empresa emp = service.findEmpresaByCnpj(empresa.cnpj);
		
		if(empresa.id != null)
			return service.insert(empresa);
		
		if(emp != null) throw new MensagemValidacaoException("Este CNPJ ja existe no sistema");
		
		return service.insert(empresa);

		
	}
	
	//@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value="/empresa/{id}")
	public Optional<Empresa> findById(@PathVariable("id")Integer id){
		return service.findById(id);
	}
	
	//@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value="/empresauser/{cpfUser}")
	public List<Empresa> findEmpresaByCpfUser(@PathVariable("cpfUser") String cpfUser){
		return service.findEmpresaByCpfUser(cpfUser);
	}
}
 