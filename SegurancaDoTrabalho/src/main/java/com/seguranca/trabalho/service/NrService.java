package com.seguranca.trabalho.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seguranca.trabalho.Model.Nr;
import com.seguranca.trabalho.repository.NrRepository;


@Service
public class NrService {

	@Autowired
	private NrRepository repository;

	public Optional<Nr> findById(Integer id) {
		return repository.findById(id);
	}


}
