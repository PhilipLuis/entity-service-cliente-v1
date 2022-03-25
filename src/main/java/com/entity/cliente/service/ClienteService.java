package com.entity.cliente.service;

import java.util.List;
import java.util.Optional;

import com.entity.cliente.entity.Cliente;

public interface ClienteService {

	public List<Cliente> listAll();

	public Optional<Cliente> findById(Integer id);

	public Cliente save(Cliente cliente);

	public boolean delete(Integer id);
}
