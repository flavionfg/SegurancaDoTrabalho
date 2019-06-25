package com.seguranca.trabalho.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.seguranca.trabalho.Model.Treinamento;

@Repository
public interface TreinamentoRepository extends JpaRepository<Treinamento,Integer>{

	@Query(value = "SELECT * FROM treinamento "       + 				 
			"		 WHERE id_empresa IN :idsEmpresa" +
			"        AND data_Final >= CURDATE()  "   +
		    "        AND data_Final <= DATE_ADD(CURDATE(), INTERVAL 7 DAY)", 
            nativeQuery = true
    )
    List<Treinamento>  findTreinamentoByIdEmpresa(@Param("idsEmpresa") Set<Integer> idsEmpresa);
} 
