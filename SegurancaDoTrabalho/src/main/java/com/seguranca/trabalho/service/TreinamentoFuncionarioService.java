package com.seguranca.trabalho.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seguranca.trabalho.repository.TreinamentoFuncionarioRepository;

@Service
@Transactional
public class TreinamentoFuncionarioService {
	
	@Autowired
	private TreinamentoFuncionarioRepository repository;
		
	
	public List<String> findFuncionarioTreinamentoByIdEmpresa(Integer id){
		return repository.findFuncionarioTreinamentoByIdEmpresa(id);
	}

}
