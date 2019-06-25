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
import com.seguranca.trabalho.Model.Treinamento;
import com.seguranca.trabalho.repository.EmpresaRepository;
import com.seguranca.trabalho.repository.TreinamentoRepository;

@Service
@Transactional
public class TreinamentoService {
	
	@Autowired
	private TreinamentoRepository repository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
		
	public Treinamento insert(Treinamento treinamento) {
		return repository.save(treinamento);
	}
	
	public Optional<Treinamento> findById(Integer id){
		return repository.findById(id);
	}
	
	
	public List<Response> findEmpresaByCpfUser(String cpfUser){
		List<Empresa> lEmpresa = empresaRepository.findByCpfUser(cpfUser);
		List<Response> lResponse = new ArrayList<Response>();
		Set<Integer> idsEmpresa = new HashSet<Integer>();
		for(Empresa empresa : lEmpresa) {
			idsEmpresa.add(empresa.id);
		}
		
		List<Treinamento> lTreinamento = repository.findTreinamentoByIdEmpresa(idsEmpresa);
		
		for(Empresa empresa :lEmpresa) {
			Response response = new Response();
			response.empresa = empresa.nomeFantasia;
			response.qtdTreinamento = 0;
			for(Treinamento treinamento : lTreinamento) {
				if(empresa.id == treinamento.idEmpresa.id) {
					response.qtdTreinamento ++;
				}
			}
			lResponse.add(response);
		}
		return lResponse ;
	}
	
	public class Response{
		public String empresa;
		public Integer qtdTreinamento;
	}
	
	
}
 