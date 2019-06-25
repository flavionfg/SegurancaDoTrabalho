package com.seguranca.trabalho.Model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="Treinamento")
public class Treinamento {


	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Integer id;
	 
	@ManyToMany	
	@JoinTable(name = "funcionario_treinamento", 
	joinColumns = @JoinColumn(name = "id_treinamento",referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn(name = "id_funcionario",referencedColumnName = "id"))
	
    public List<Funcionario> funcionarios = new ArrayList<Funcionario>();
	
	@NotBlank(message="Verifique os campos obrigatórios")
	@NotNull
	@Column(name = "nr",nullable = true)
	public String nr;
	
	@DateTimeFormat(iso = ISO.DATE)
	//@NotBlank(message="Verifique os campos obrigatórios")
	@NotNull
	@Column(name = "dataInicial",nullable = true)
	public Date dataInicial;
	
	@DateTimeFormat(iso = ISO.DATE)
	//@NotBlank(message="Verifique os campos obrigatórios")
	@NotNull
	@Column(name = "dataFinal",nullable = true)
	public Date dataFinal;
	
	//@NotBlank(message="Verifique os campos obrigatórios")
	@NotNull
	@Column(name = "tipoNr",nullable = true)
	public String tipoNr;
    
	//@NotBlank(message="Verifique os campos obrigatórios")
	@NotNull
	@ManyToOne
	@JoinColumn(name="id_empresa")
	public Empresa idEmpresa;


}
