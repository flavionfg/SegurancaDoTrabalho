package com.seguranca.trabalho.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "EMPRESA")
public class Empresa {
	
	
	 
	@OneToMany(targetEntity=Funcionario.class, mappedBy="idEmpresa",cascade=CascadeType.ALL)
	private List<Funcionario> funcionarios;
	
	@OneToMany(targetEntity=PlanoTrabalho.class, mappedBy="idEmpresa",cascade=CascadeType.ALL)
	private List<PlanoTrabalho> planosTrabalho;
	
	@OneToMany(targetEntity=Treinamento.class, mappedBy="idEmpresa",cascade=CascadeType.ALL)
	private List<Treinamento> treinamentos;
	
	@OneToMany(targetEntity=Setor.class, mappedBy="idEmpresa",cascade=CascadeType.ALL)
	private List<Setor> setores;	
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	public Integer id;			

	@NotNull
	@Column(name = "razaoSocial",nullable = true)
	public String razaoSocial;

	@NotNull
	@Column(name = "nomeFantasia",nullable = true)
	public String nomeFantasia;

	@Size(min = 14, max = 14)
	@NotNull
	@Pattern(regexp = "^\\d*[0-9]?$")
	@NotNull
	@Column(name = "cnpj",nullable = true)
	public String cnpj;

	@Size(min = 8, max = 8)
	@NotNull
	@Pattern(regexp = "^\\d*[0-9]?$")
	@NotNull
	@Column(name = "cep",nullable = true)
	public String cep;

	@NotNull
	@Column(name = "logradouro",nullable = true)
	public String logradouro;
	
	@Column(name = "bairro")
	public String bairro;
		
	@Column(name = "numero")
	public String numero;

	@NotNull
	@Column(name = "cidade",nullable = true)
	public String cidade;

	@NotNull
	@Column(name = "uf",nullable = true)
	public String uf;	

	@Size(min = 11, max = 11)
	@NotNull
	@Pattern(regexp = "^\\d*[0-9]?$")
	@NotNull
	@Column(name = "celular",nullable = true)
	public String celular;
	
	@Size(min = 10, max = 10)
	@NotNull
	@Pattern(regexp = "^\\d*[0-9]?$")
	@Column(name = "telefone")
	public String telefone; 
	
	@NotNull
    @Email
	@Column(name = "email",nullable = true)
	public String email;

	//@Size(min = 11, max = 11)
	@NotNull
	@Pattern(regexp = "^\\d*[0-9]?$")
	@NotNull
	@Column(name = "cpfUser")
	public String cpfUser;
	
}
