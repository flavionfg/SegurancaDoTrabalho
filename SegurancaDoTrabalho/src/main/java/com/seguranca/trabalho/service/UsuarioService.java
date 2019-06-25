package com.seguranca.trabalho.service;


import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seguranca.trabalho.Model.Usuario;
import com.seguranca.trabalho.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public Usuario insert(Usuario usuario) {
		usuario.nome = usuario.primeiroNome + " " + usuario.segundoNome; 
		return repository.save(usuario);
	}
	
	public Usuario findBySenhaAndNomeUsuario(String senha ,String nomeUsuario) {
		
		return repository.findBySenhaAndNomeUsuario(senha, nomeUsuario);
	}

	public Usuario findUsuarioByCpf(@CPF @NotNull String cpf) {
		// TODO Auto-generated method stub
		return repository.findUsuarioByCpf(cpf);
	}
}
