package com.entity.cliente.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.entity.cliente.entity.Cliente;
import com.entity.cliente.repository.ClienteRepositoryImpl;

public class ClienteServiceImpl implements ClienteService {

	@Autowired
	ClienteRepositoryImpl repository;
	
	@Override
	public List<Cliente> listAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Cliente> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public Cliente save(Cliente cliente) {
		return repository.save(cliente);
	}

	@Override
	public boolean delete(Integer id) {
		return repository.delete(id);
	}

}
