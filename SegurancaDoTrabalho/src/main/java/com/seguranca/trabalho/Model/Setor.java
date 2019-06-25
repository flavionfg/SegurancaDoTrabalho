package com.seguranca.trabalho.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Setor")
public class Setor {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Integer id;

	@NotNull
    @ManyToOne
	@JoinColumn
	public Empresa idEmpresa;
	

	@Column(name = "nome")
	public String nome;

}
