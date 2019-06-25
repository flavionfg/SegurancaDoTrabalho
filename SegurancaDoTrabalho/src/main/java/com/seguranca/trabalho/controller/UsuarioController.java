package com.seguranca.trabalho.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.seguranca.trabalho.Model.Usuario;
import com.seguranca.trabalho.service.UsuarioService;
import com.seguranca.trabalho.service.validator.MensagemValidacaoException;

@RestController
@RequestMapping(value="/workSecurity")
public class UsuarioController {
	
	@Autowired(required=true)
	private UsuarioService service;
	
	@PostMapping("/usuario")
	public Usuario save(@Valid @RequestBody Usuario usuario) throws MensagemValidacaoException{

		Usuario user = service.findUsuarioByCpf(usuario.cpf);
		
		if(user != null) throw new MensagemValidacaoException("CPF já cadastrado");
		
		return service.insert(usuario);
	}
	
	@GetMapping(value="/usuario/valida/")
	public Usuario validaUsuario(@RequestParam("nomeUsuario")String nomeUsuario ,@RequestParam("senha")String senha) throws MensagemValidacaoException{
		
		Usuario usuario = service.findBySenhaAndNomeUsuario(senha,nomeUsuario);
		
		if(usuario == null) throw new MensagemValidacaoException("Usuario não encontrado favor verificar login ou senha");
		return usuario;
	}

}
