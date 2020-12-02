package com.lanchonete.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor	
@AllArgsConstructor
public class PedidoItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="id_ingrediente")
	private Ingrediente ingrediente;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="id_pedido")
	private Pedido pedido;
	
}
