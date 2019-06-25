package com.seguranca.trabalho.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seguranca.trabalho.Model.Empresa;
import com.seguranca.trabalho.Model.Setor;
import com.seguranca.trabalho.repository.EmpresaRepository;
import com.seguranca.trabalho.repository.SetorRepository;

@Service
@Transactional
public class EmpresaService {

	@Autowired
	private EmpresaRepository repository;
	
	private SetorRepository setorRespository;
	
	public Empresa insert(Empresa empresa) {
		return repository.save(empresa);
	}
	
	public Optional<Empresa> findById(Integer id){
		return repository.findById(id);
	}
	
	public List<Empresa> findEmpresaByCpfUser(String cpfUser){
		return repository.findByCpfUser(cpfUser);
	}
	
	public Empresa findEmpresaByCnpj(String cnpj) {
		return repository.findByCnpj(cnpj);
	}
	
	public void insertSetores(List<Setor> setores) {
		setorRespository.saveAll(setores);
	}
	
}
