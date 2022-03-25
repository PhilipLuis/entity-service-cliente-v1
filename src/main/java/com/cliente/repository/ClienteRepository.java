package com.cliente.repository;

import java.util.List;
import java.util.Optional;

import com.cliente.entity.Cliente;

public interface ClienteRepository {

	void save(List<Cliente> clientesSorted);

	List<Cliente> findAll();
	
	Optional<Cliente> findById(Integer id);
	
	boolean delete(Integer id);
}
