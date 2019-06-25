package com.seguranca.trabalho.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.seguranca.trabalho.Model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario,Integer> {

	
	@Query(value = "SELECT * FROM funcionario  WHERE id_empresa_id = :idempresa ", 
            nativeQuery = true
    )
    List<Funcionario> findFuncionarioByIdEmpresa(@Param("idempresa") Integer idEmpresa);
	
	
	 List<Funcionario> findByIdEmpresa(Integer idEmpresa);
} 
 