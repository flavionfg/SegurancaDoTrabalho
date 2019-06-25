package com.seguranca.trabalho.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity(name = "NR")
public class Nr {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	public Integer id;	


	@NotNull
	@Column(name = "tipo",nullable = true)
	public String tipo;

} 
