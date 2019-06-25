package com.seguranca.trabalho.Model;

import java.sql.Date;

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
@Entity(name="PlanoTrabalho")
public class PlanoTrabalho {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Integer id;
	
	//@NotBlank(message="Verifique os campos obrigatórios")
	@NotNull
	@Column(name = "grupoRisco",nullable = true)
	public String grupoRisco;
	
	//@NotBlank(message="Verifique os campos obrigatórios")
	@NotNull
	@Column(name = "risco",nullable = true)
	public String risco;
	
	//@NotBlank(message="Verifique os campos obrigatórios")
	@NotNull
	@Column(name = "setor",nullable = true)
	public String setor;

	@Column(name = "estrategia")
	public String estrategia;
	
	//@NotBlank(message="Verifique os campos obrigatórios")
	@NotNull
	@Column(name = "responsavel",nullable = true)
	public String responsavel;
	
	//@NotBlank(message="Verifique os campos obrigatórios")
	@NotNull
	@Column(name = "dataInicial",nullable = true)
	public Date dataInicial;
	
	//@NotBlank(message="Verifique os campos obrigatórios")
	@NotNull
	@Column(name = "dataFinal",nullable = true)
	public Date dataFinal;
	
	//@NotBlank(message="Verifique os campos obrigatórios")
	@NotNull
	@Column(name = "empresa",nullable = true)
	public String empresa;
	
	//@NotBlank(message="Verifique os campos obrigatórios")
	@NotNull
	@ManyToOne
	@JoinColumn(name="id_Funcionario")
	public Funcionario idFuncionario;
	
	//@NotBlank(message="Verifique os campos obrigatórios")
	@NotNull
	@ManyToOne
	@JoinColumn(name="id_Empresa")
	public Empresa idEmpresa;


}
