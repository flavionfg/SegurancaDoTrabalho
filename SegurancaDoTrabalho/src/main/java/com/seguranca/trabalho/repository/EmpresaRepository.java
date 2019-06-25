package com.seguranca.trabalho.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.seguranca.trabalho.Model.Empresa;


@Repository
public interface EmpresaRepository extends JpaRepository<Empresa,Integer>{


    List<Empresa> findByCpfUser(@Param("cpfUser") String cpfUser);
	

    Empresa findByCnpj(@Param("cnpj") String cnpj);
	
}
