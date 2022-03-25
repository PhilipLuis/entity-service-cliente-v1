package com.cliente.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cliente.entity.Cliente;
import com.cliente.repository.ClienteRepositoryImpl;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	ClienteRepositoryImpl repository;
	
	@Autowired
	SequenceService sequenceService;
	
	@Override
	public List<Cliente> listAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Cliente> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public Cliente saveOrUpdate(Cliente cliente) {
		int sequence;
		Cliente clienteSave = null;
		List<Cliente> clientes = repository.findAll();
		
		if(cliente.getId() != null) {
			clienteSave = clientes.stream().filter(x -> x.getId() == cliente.getId()).findFirst().orElse(null);
			if(clienteSave == null) {
				clienteSave = new Cliente();
				sequence = sequenceService.getNextValue();
				clienteSave.setId(sequence);
				clientes.add(clienteSave);
			}
			clienteSave.setNombre(cliente.getNombre());
			clienteSave.setEmail(cliente.getEmail());
			
		}else {
			clienteSave = new Cliente();
			sequence = sequenceService.getNextValue();
			clienteSave.setId(sequence);
			clienteSave.setNombre(cliente.getNombre());
			clienteSave.setEmail(cliente.getEmail());
			clientes.add(clienteSave);
		}
		
		List<Cliente> clientesSorted = clientes.stream().sorted(Comparator.comparingInt(Cliente::getId)).collect(Collectors.toList());
		repository.save(clientesSorted);
		return clienteSave;
	}

	@Override
	public boolean delete(Integer id) {
		return repository.delete(id);
	}

}
