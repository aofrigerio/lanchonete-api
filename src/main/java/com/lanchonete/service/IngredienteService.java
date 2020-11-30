package com.lanchonete.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanchonete.model.Ingrediente;
import com.lanchonete.repository.IngredienteRepository;

@Service
public class IngredienteService {
	
	@Autowired
	IngredienteRepository ingredienteRepository;
	
	public Ingrediente findById(Long id){	
		return ingredienteRepository.findById(id).get();
	}
	
	public List<Ingrediente> findAll(){
		return ingredienteRepository.findAll();
	}

	public Ingrediente save(Ingrediente ingrediente) {
		return ingredienteRepository.save(ingrediente);
	}
	
	public Ingrediente update(Long id, Ingrediente ingrediente) {
		
		Ingrediente ingredienteSalva = ingredienteRepository.findById(id).get();
		
		BeanUtils.copyProperties(ingrediente, ingredienteSalva, "id");
		
		return ingredienteRepository.save(ingredienteSalva);
	}
	
	public void delete(Long id) {
		ingredienteRepository.deleteById(id);
	}
}
