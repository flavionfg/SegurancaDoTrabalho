package com.seguranca.trabalho.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.seguranca.trabalho.Model.Treinamento;


public interface TreinamentoFuncionarioRepository extends JpaRepository<Treinamento,Integer>{
	
	@Query(value = "SELECT data_inicial, data_final, nr,tipo_nr, nome, cpf FROM treinamento t " + 
			"		 INNER JOIN   funcionario_treinamento ft ON t.id = ft.id_treinamento" + 
			"        JOIN funcionario f ON f.id = ft.id_funcionario" + 
			"		 WHERE t.id_empresa = :idEmpresa", 
            nativeQuery = true
    )
    List<String>  findFuncionarioTreinamentoByIdEmpresa(@Param("idEmpresa") Integer id);
	
	
}
