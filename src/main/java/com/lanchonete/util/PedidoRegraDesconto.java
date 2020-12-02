package com.lanchonete.util;

import java.util.List;

import com.lanchonete.model.Ingrediente;
import com.lanchonete.model.Lanche;
import com.lanchonete.model.Pedido;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoRegraDesconto {

	private Pedido pedido;
	private double valorDesconto = 0;
	private double valorPedido = 0;
	private double valorHamburguer = 0;
	private double valorQueijo;
	private int quantidadeBacon;
	private int quantidadeHamburguer;
	private int quantidadeAlface;
	private int quantidadeQueijo;
	List<Ingrediente> ingredientes;

	public void aplicarDesconto() {
		/*
		valorPedido = pedido.getValorTotalPedido();

		// Percorre as quantidades dos ingredientes do lanche
		lanches.forEach(item -> {
			this.ingredientes = item.getIngredientes();
			ingredientes.forEach(ingrediente -> {
				if (ingrediente.getNome().equalsIgnoreCase("bacon")) {
					quantidadeBacon++;
				}
				if (ingrediente.getNome().equalsIgnoreCase("alface")) {
					quantidadeAlface++;
				}

				if (ingrediente.getNome().equalsIgnoreCase("Hambúrguer")) {
					
					quantidadeHamburguer++;
					
					if((quantidadeHamburguer % 3) <= 0) {
						valorHamburguer = valorHamburguer - (ingrediente.getPreco()*-1);
					}
					
				}

				if (ingrediente.getNome().equalsIgnoreCase("queijo")) {
					quantidadeQueijo++;
				}

			});
		}
		
		
		//percorre a quantidade dos adicionais
		);
		adicionais.forEach(item -> {
			if (item.getNome().equalsIgnoreCase("alface")) {
				quantidadeAlface++;
			}

			if (item.getNome().equalsIgnoreCase("queijo")) {
				quantidadeQueijo++;
			}

			if (item.getNome().equalsIgnoreCase("Hambúrguer")) {
				quantidadeHamburguer++;
				if((quantidadeHamburguer % 3) <= 0) {
					valorHamburguer = valorHamburguer - (item.getPreco()*-1);
				}
			}

			if (item.getNome().equalsIgnoreCase("bacon")) {
				quantidadeBacon++;
			}
		});

	
		// Aplica o desconto
		System.out.println("Valores...");
		System.out.println("Quantidade hamburguer:" + quantidadeHamburguer);
		System.out.println("Valor do hamburuger desconto" + valorHamburguer);
		System.out.println(quantidadeQueijo);
		System.out.println("Valor do hamburuger desconto" + valorQueijo);
		System.out.println(quantidadeAlface);
		System.out.println(quantidadeBacon);
		System.out.println("Valor desconto:" + valorDesconto);		
		System.out.println("Valor do pedido: " + valorPedido);
		
		
		//se for light, subtrai 10%
		if(quantidadeAlface > 0 && quantidadeBacon <= 0) {
			valorDesconto = valorPedido * (0.1);
		}	
		
		//acerta a parte final do pedido);
		this.pedido.setValorTotalPedido(valorPedido - valorDesconto - valorHamburguer - valorQueijo);
	*/

	}

}
