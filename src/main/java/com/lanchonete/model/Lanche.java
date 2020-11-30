package com.lanchonete.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lanche {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "lanches_ingredientes", 
			  joinColumns = @JoinColumn(name = "lanche_id"), 
			  inverseJoinColumns = @JoinColumn(name = "ingrediente_id"))
	@JsonManagedReference
	private List<Ingrediente> ingredientes;
	

}
