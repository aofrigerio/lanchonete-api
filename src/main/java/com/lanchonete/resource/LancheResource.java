package com.lanchonete.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lanchonete.model.Lanche;
import com.lanchonete.model.PedidoItem;
import com.lanchonete.service.LancheService;

@RestController
@RequestMapping("lanche")
public class LancheResource {

	@Autowired
	LancheService lancheService;

	@GetMapping
	public ResponseEntity<List<Lanche>> listAll() {
		return ResponseEntity.ok(lancheService.listAll());
	}

	@PostMapping
	public ResponseEntity<Lanche> create(@RequestBody Lanche lanche) {
		return ResponseEntity.ok(lancheService.save(lanche));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(Long id) {
		return ResponseEntity.ok(lancheService.delete(id));
	}

}
