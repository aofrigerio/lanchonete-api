package com.lanchonete.db;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.lanchonete.model.Ingrediente;
import com.lanchonete.model.Lanche;
import com.lanchonete.service.IngredienteService;
import com.lanchonete.service.LancheService;

@Component
public class DbAppendRunner implements CommandLineRunner {

	@Autowired
	IngredienteService ingredienteService;
	
	@Autowired
	LancheService lancheService;

	@Override
	public void run(String... args) throws Exception {
		
		//Carga dos ingredientes
		Ingrediente alface = ingredienteService.save(new Ingrediente(null, "Alface", 0.4, null));
		Ingrediente bacon = ingredienteService.save(new Ingrediente(null, "Bacon", 2.00, null));
		Ingrediente hamburguer = ingredienteService.save(new Ingrediente(null, "Hamburguer", 3.00, null));
		Ingrediente ovo = ingredienteService.save(new Ingrediente(null, "Ovo", 0.8, null));
		Ingrediente queijo = ingredienteService.save(new Ingrediente(null, "Queijo", 1.5, null));
		
		//Lista de ingredientes por lanche
		List<Ingrediente> xbaconList = new ArrayList<Ingrediente>();
		xbaconList.add(bacon);
		xbaconList.add(hamburguer);
		xbaconList.add(queijo);
		
		List<Ingrediente> xburguerList = new ArrayList<Ingrediente>();
		xburguerList.add(hamburguer);
		xburguerList.add(queijo);
		
		
		List<Ingrediente> xeggList = new ArrayList<Ingrediente>();
		xeggList.add(ovo);
		xeggList.add(hamburguer);
		xeggList.add(queijo);
		
		
		List<Ingrediente> xeggBaconList = new ArrayList<Ingrediente>();
		xeggBaconList.add(bacon);
		xeggBaconList.add(hamburguer);
		xeggBaconList.add(ovo);
		xeggBaconList.add(queijo);
			
		//Criação dos lanches
		lancheService.save(new Lanche(null, "X-Bacon", xbaconList));
		lancheService.save(new Lanche(null, "X-Burger", xburguerList));
		lancheService.save(new Lanche(null, "X-Egg", xeggList));
		lancheService.save(new Lanche(null, "X-Egg Bacon", xeggBaconList));
				
	}

}
