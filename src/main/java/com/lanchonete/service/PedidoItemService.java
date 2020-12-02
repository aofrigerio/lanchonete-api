package com.lanchonete.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.lanchonete.model.PedidoItem;
import com.lanchonete.repository.PedidoItemRepository;

@Service
public class PedidoItemService {
	
	
	@Autowired
	PedidoItemRepository PedidoItemRepository;
	
	public List<PedidoItem> getItemPedidoItems() {
        return PedidoItemRepository.findAll();
    }

    public PedidoItem getItemPedidoItemById(Long id) {
        return PedidoItemRepository.findById(id).orElse(null);
    }

    public PedidoItem updateItemPedidoItem(PedidoItem PedidoItem) {
        if (PedidoItemRepository.findById(PedidoItem.getId()) != null) {
            return PedidoItemRepository.save(PedidoItem);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "PedidoItem not found");
    }

    public String deleteItemPedidoItem(Long id) {
    	PedidoItemRepository.deleteById(id);
        return "PedidoItem removed : " + id;
    }
    
}
