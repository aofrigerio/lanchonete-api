package com.lanchonete.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
	
	private long id;
	private List<Lanche> lanches = new ArrayList<Lanche>();
	private List<Ingrediente> adicionais = new ArrayList<Ingrediente>();
	private double valorTotalPedido;
	private int quantidadePedido;
	private double valorAdicional;
	private double valorDesconto;
	
	public void addLanche(Lanche lanche) {
		this.lanches.add(lanche);
	}
	
	public void addAdicional(Ingrediente ingrediente) {
		this.adicionais.add(ingrediente);
	}
}
