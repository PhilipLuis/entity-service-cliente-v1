package com.entity.cliente.repository;

import java.util.List;
import java.util.Optional;

import com.entity.cliente.entity.Cliente;

public interface ClienteRepository {

	Cliente save(Cliente cliente);

	List<Cliente> findAll();
	
	Optional<Cliente> findById(Integer id);
	
	boolean delete(Integer id);
}
