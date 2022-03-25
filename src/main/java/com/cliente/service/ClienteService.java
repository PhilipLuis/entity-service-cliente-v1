package com.cliente.service;

import java.util.List;
import java.util.Optional;

import com.cliente.entity.Cliente;

public interface ClienteService {

	public List<Cliente> listAll();

	public Optional<Cliente> findById(Integer id);

	public Cliente saveOrUpdate(Cliente cliente);

	public boolean delete(Integer id);
}
