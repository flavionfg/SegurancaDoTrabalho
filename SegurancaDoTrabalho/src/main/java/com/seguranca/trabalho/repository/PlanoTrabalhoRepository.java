package com.seguranca.trabalho.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.seguranca.trabalho.Model.PlanoTrabalho;

@Repository
public interface PlanoTrabalhoRepository extends JpaRepository<PlanoTrabalho, Integer> {
	
	@Query(value = " SELECT * FROM plano_trabalho WHERE id_empresa = :idEmpresa", 
            nativeQuery = true
    )
    List<PlanoTrabalho>  findPlanoTrabalhoByIdEmpresa(@Param("idEmpresa") Integer id);
	
	
	@Query(value = "SELECT * FROM plano_trabalho "       + 				 
			"		 WHERE id_empresa IN :idsEmpresa" +
			"        AND data_final >= CURDATE()  "   +
		    "        AND data_final <= DATE_ADD(CURDATE(), INTERVAL 7 DAY)", 
            nativeQuery = true
    )
    List<PlanoTrabalho>  findPlanoTrabalhoByIdEmpresa(@Param("idsEmpresa") Set<Integer> idsEmpresa);
	
	
}
