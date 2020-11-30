package com.lanchonete.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lanchonete.model.Lanche;
import com.lanchonete.service.LancheService;

@RestController
@RequestMapping("lanche")
public class LancheResource {
	
	@Autowired
	LancheService lancheService;
	
	@GetMapping
	public ResponseEntity<List<Lanche>> listar(){
		return ResponseEntity.ok(lancheService.listAll());
	}

}
