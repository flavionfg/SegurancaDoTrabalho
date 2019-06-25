package com.seguranca.trabalho.controller;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seguranca.trabalho.Model.TreinamentoFuncionarioVO;
import com.seguranca.trabalho.service.TreinamentoFuncionarioService;

@RestController
@RequestMapping(value="/workSecurity")
public class TreinamentoFuncionarioController implements Serializable{
		
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		@Autowired
		private TreinamentoFuncionarioService service;
		
		//@PreAuthorize("hasRole('ADMIN')")
		@GetMapping(value="/treinamentofuncionario/{idEmpresa}")
		public List<TreinamentoFuncionarioVO> getFuncionarioTreinamento(@PathVariable("idEmpresa") Integer id) throws ParseException{
									
			List<TreinamentoFuncionarioVO> listVO = new ArrayList<TreinamentoFuncionarioVO>();
			List<String> lobject = service.findFuncionarioTreinamentoByIdEmpresa(id);
			for(Object object :lobject) {
				TreinamentoFuncionarioVO vo = new TreinamentoFuncionarioVO();
				SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
				
				String st =  object.toString();
					
				String[] lst = st.split(",");
				System.out.println("Data : "+lst[0]);
				vo.dataInicial = formato.parse(lst[0]);
				vo.dataFinal = formato.parse(lst[1]);
				vo.nr = lst[2];
				vo.tipo = lst[3];
				vo.nome = lst[4]; 
				vo.cpf = lst[5];
				
				listVO.add(vo);
			}
			
			
			return listVO;
		}
	
}
