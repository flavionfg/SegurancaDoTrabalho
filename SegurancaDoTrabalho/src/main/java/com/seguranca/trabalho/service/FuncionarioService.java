package com.seguranca.trabalho.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seguranca.trabalho.Model.Funcionario;
import com.seguranca.trabalho.Model.Setor;
import com.seguranca.trabalho.repository.FuncionarioRepository;
import com.seguranca.trabalho.repository.SetorRepository;
import com.seguranca.trabalho.service.validator.MensagemValidacaoException;
import com.seguranca.trabalho.service.validator.Utils;


@Service
@Transactional
public class FuncionarioService extends Utils{
	
	@Autowired
	private FuncionarioRepository repository;
	
	@Autowired
	private SetorRepository setorRespository;
	
	public List<Funcionario> insert(List<Funcionario> funcionario) throws MensagemValidacaoException {
		try {
			if(funcionario.size() == 1) {
				if(!isValidCPF(funcionario.get(0).cpf)) throw new MensagemValidacaoException("CPF invalido");
			}
				
			Integer idDaEmpresa = 0;
			for(Funcionario func : funcionario) {
				System.out.println("FUNC : "+func.idEmpresa.id);
				idDaEmpresa = func.idEmpresa.id;
				break;
			}
			
			List<Setor> lSetor = setorRespository.findAllSetorByIdEmpresa(idDaEmpresa);
			Map<String,Setor> mapSetor = new HashMap<String,Setor>();
			for(Setor setor : lSetor) {
				mapSetor.put(setor.nome.toUpperCase(),setor);
			}
	
			List<Funcionario> lFuncionarioaux = findFuncionarioByIdEmpresa(idDaEmpresa);
	
			Map<String,Funcionario> mapFuncionario = new HashMap<String,Funcionario>();
			if(lFuncionarioaux != null && !lFuncionarioaux.isEmpty()) {
							
				for(Funcionario func : lFuncionarioaux) {
						
					mapFuncionario.put(func.cpf,func);
					
				}
			}
			
			List<Funcionario> lFuncionario = new ArrayList<Funcionario>();
			int i = 0;
			for(Funcionario func : funcionario){
				i++;
	
				if(!isValidCPF(func.cpf)) throw new MensagemValidacaoException("CPF invalido na linha : "+i);
				
				if(!mapSetor.containsKey(func.setor.toUpperCase())) throw new MensagemValidacaoException("Setor não encontrado, favor verificar o cadastro. Erro linha "+
						(funcionario.size() > 1 ? i : ""));
				
				if(mapFuncionario.containsKey(func.cpf)){
					func.id = mapFuncionario.get(func.cpf).id;
					
				} 
				lFuncionario.add(func);
			}
	
			return repository.saveAll(lFuncionario);
		}catch(Exception ex) {
			throw new MensagemValidacaoException(ex.getMessage());
		}
	}
	
	public Optional<Funcionario> findById(Integer id){
		return repository.findById(id);
	}
	
	public List<Funcionario> findFuncionarioByIdEmpresa(Integer id){
		return repository.findFuncionarioByIdEmpresa(id);
	}

}
