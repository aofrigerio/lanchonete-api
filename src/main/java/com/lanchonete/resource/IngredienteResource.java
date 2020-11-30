package com.lanchonete.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lanchonete.model.Ingrediente;
import com.lanchonete.service.IngredienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("ingrediente")
@Api
public class IngredienteResource {
	
	@Autowired
	IngredienteService ingredienteService;
	
	@ApiOperation(value = "Mostrar todos os ingredientes")
	@GetMapping
	public ResponseEntity<List<Ingrediente>> listAll(){
		return ResponseEntity.ok(ingredienteService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Ingrediente> create(@RequestBody Ingrediente ingrediente){
		return ResponseEntity.ok(ingredienteService.save(ingrediente));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Ingrediente> update(@PathVariable Long id,@RequestBody Ingrediente ingrediente){
		
		Ingrediente ingredienteNew = ingredienteService.update(id,ingrediente);
			
		return ResponseEntity.ok(ingredienteNew);
	}
	
	@DeleteMapping
	public ResponseEntity<Ingrediente> delete(@PathVariable Long id){
		
		ingredienteService.delete(id);
			
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
}
