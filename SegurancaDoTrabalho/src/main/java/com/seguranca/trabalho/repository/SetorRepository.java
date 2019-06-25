package com.seguranca.trabalho.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.seguranca.trabalho.Model.Setor;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Integer> {
	
	
	@Query(value = " SELECT max(id) FROM Empresa", 
            nativeQuery = true
    )
    Integer  findSetorByIdEmpresa();
	
	@Query(value = " SELECT id,nome,id_empresa_id FROM Setor WHERE  id_empresa_id = :idEmpresa", 
            nativeQuery = true
    )
    List<Setor>  findAllSetorByIdEmpresa(@Param("idEmpresa") Integer id);
}  
 