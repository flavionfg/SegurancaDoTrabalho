package com.seguranca.trabalho.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "FUNCIONARIO")
public class Funcionario {
	 
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Integer id;
	
	@OneToMany(targetEntity=PlanoTrabalho.class, mappedBy="idFuncionario")
	private List<PlanoTrabalho> planosTrabalho;
	
	@ManyToMany(mappedBy="funcionarios")
	private List<Treinamento> treinamentos = new ArrayList<Treinamento>();
	
	
	@NotNull
    @ManyToOne
	@JoinColumn
	//@NotBlank(message="Preenchimento do campo bairro é obrigatório")
	public Empresa idEmpresa;
	
	//@NotBlank(message="Preenchimento do campo bairro é obrigatório")
	@NotNull
	@Column(name = "primeiroNome",nullable = true)
	public String primeiroNome;
	
	//@NotBlank(message="Preenchimento do campo bairro é obrigatório")
	@NotNull
	@Column(name = "segundoNome",nullable = true)
	public String segundoNome;
	
	//@Pattern(regexp = "^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ'\\s]+$")
	@NotNull
	@Column(name = "nome",nullable = true)
	public String nome;
	
	@Size(min = 9, max = 9)
	@NotNull
	@Pattern(regexp = "^\\d*[0-9]?$")
	@Column(name = "rg",nullable = true)
	public String rg;
	

	@Pattern(regexp = "^\\d*[0-9]?$")
	@Size(min = 11, max = 11)
	@Column(name = "cpf",nullable = true)
	public String cpf;

	@NotNull
	@Column(name = "setor",nullable = true)
	public String setor;

	@NotNull
	@Column(name = "cargo",nullable = true)
	public String cargo;

	@NotNull
	@Column(name = "periodo",nullable = true)
	public String periodo;

	@NotNull
	@Column(name = "sexo",nullable = true)
	public String sexo;		
	
	@Pattern(regexp = "^\\d*[0-9]?$")
	@NotNull
	@Size(min = 11, max = 11 ,message="celular deve ter 11 digitos contando com DD")
	@Column(name = "celular",nullable = true)
	public String celular;
	
	@NotNull
	@Email
	//@NotBlank(message="Preenchimento do campo bairro é obrigatório")
	@Column(name = "email",nullable = true)
	public String email;	
	
}
