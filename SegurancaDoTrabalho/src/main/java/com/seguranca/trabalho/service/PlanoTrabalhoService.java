package com.seguranca.trabalho.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seguranca.trabalho.Model.Empresa;
import com.seguranca.trabalho.Model.PlanoTrabalho;
import com.seguranca.trabalho.repository.EmpresaRepository;
import com.seguranca.trabalho.repository.PlanoTrabalhoRepository;
@Service
@Transactional
public class PlanoTrabalhoService {

	@Autowired
	private PlanoTrabalhoRepository repository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	public PlanoTrabalho insert(PlanoTrabalho planoTrabalho) {
		return repository.save(planoTrabalho);
	}
	
	public Optional<PlanoTrabalho> findById(Integer id){
		return repository.findById(id);
	}
	
	public List<PlanoTrabalho> findPlanoTrabalhoByIdEmpresa(Integer id){
		return repository.findPlanoTrabalhoByIdEmpresa(id);
	}
	
	
	public List<Plano> findEmpresaByCpfUser(String cpfUser){
		List<Empresa> lEmpresa = empresaRepository.findByCpfUser(cpfUser);
		List<Plano> lResponse = new ArrayList<Plano>();
		Set<Integer> idsEmpresa = new HashSet<Integer>();
		for(Empresa empresa : lEmpresa) {
			idsEmpresa.add(empresa.id);
		}
		
		List<PlanoTrabalho> lPlanoTrabalho = repository.findPlanoTrabalhoByIdEmpresa(idsEmpresa);
		
		for(Empresa empresa :lEmpresa) {
			Plano response = new Plano();
			response.empresa = empresa.nomeFantasia;
			response.qtdTreinamento = 0; 
			for(PlanoTrabalho plano : lPlanoTrabalho) {
				if(empresa.id == plano.idEmpresa.id) {
					response.qtdTreinamento ++;
				}
			}
			lResponse.add(response);
		}
		return lResponse ;
	}
	
	
	
	public class Plano{
		public String empresa;
		public Integer qtdTreinamento;
	}
}
