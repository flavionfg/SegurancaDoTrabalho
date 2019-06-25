package com.seguranca.trabalho.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seguranca.trabalho.Model.Setor;
import com.seguranca.trabalho.repository.SetorRepository;

@Service
@Transactional
public class SetorService {
	
	@Autowired
	private SetorRepository repository;
	 
	public List<Setor> insert(List<Setor> setores) {
		return repository.saveAll(setores);				
	}
	
	public Optional<Setor> findById(Integer id){
		return repository.findById(id);
	}
	 
	public Integer findSetorByIdEmpresa() {
		return repository.findSetorByIdEmpresa();
	}
	
	public List<Setor> findAllSetorByIdEmpresa(Integer id){
		return repository.findAllSetorByIdEmpresa(id);
	}
}
