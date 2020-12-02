package com.lanchonete.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanchonete.model.Lanche;
import com.lanchonete.repository.LancheRepository;

@Service
public class LancheService {
	
	@Autowired
	private LancheRepository lancheRepository;
	
	public List<Lanche> listAll(){
		return lancheRepository.findAll();
	}
	
	public Lanche save(Lanche lanche) {
		return lancheRepository.save(lanche);
	}
	
	public String delete(Long id) {
		lancheRepository.deleteById(id);
		return "Removido: " + id;
	}

}
