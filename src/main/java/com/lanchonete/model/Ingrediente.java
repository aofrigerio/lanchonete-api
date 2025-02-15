package com.lanchonete.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ingrediente {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_ingrediente")
	private Long id;
	private String nome;
	private double preco;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "ingredientes")
	private List<Lanche> lanches;

}
