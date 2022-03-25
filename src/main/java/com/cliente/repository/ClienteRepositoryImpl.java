package com.cliente.repository;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.cliente.entity.Cliente;
import com.cliente.utils.ClienteConstants;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {

	private ObjectMapper mapper;
	
	public ClienteRepositoryImpl() {
		try {
			File file = new File(ClienteConstants.FILE_CLIENTE);
			if (!file.exists()) {
				mapper = new ObjectMapper();
				mapper.writeValue(Paths.get(ClienteConstants.FILE_CLIENTE).toFile(), new ArrayList<Cliente>());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void save(List<Cliente> clientesSorted) {
		try {
			mapper = new ObjectMapper();
			mapper.writeValue(Paths.get(ClienteConstants.FILE_CLIENTE).toFile(), clientesSorted);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Cliente> findAll() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			mapper = new ObjectMapper();
			clientes = new ArrayList<Cliente>(Arrays.asList(mapper.readValue(Paths.get(ClienteConstants.FILE_CLIENTE).toFile(), Cliente[].class)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clientes;
	}

	@Override
	public Optional<Cliente> findById(Integer id) {
		List<Cliente> clientes = findAll();
		return Optional.ofNullable(clientes.stream().filter(x -> x.getId() == id).findFirst().orElse(null));
	}

	@Override
	public boolean delete(Integer id) {
		boolean deleted = false;
		
		try {
			List<Cliente> clientes = findAll();
			List<Cliente> clientesFiltered = clientes.stream().filter(x -> x.getId() != id).collect(Collectors.toList());
			mapper = new ObjectMapper();
			mapper.writeValue(Paths.get(ClienteConstants.FILE_CLIENTE).toFile(), clientesFiltered);
			deleted = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleted;
	}

}
