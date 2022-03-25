package com.entity.cliente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.cliente.entity.Cliente;
import com.entity.cliente.service.ClienteService;

@RestController
@RequestMapping ("/clientes")
public class ClienteController {

	@Autowired
	ClienteService clienteService;
	
	@GetMapping("/listAll")
	public ResponseEntity<List<Cliente>> listAll (){
		return new ResponseEntity<>(clienteService.listAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable("id") Integer id) {
		return clienteService.findById(id).map(cliente -> new ResponseEntity<Cliente>(cliente, HttpStatus.OK))
				.orElse(new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND));		
	}
	
	@PostMapping("/save")
	public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
		return new ResponseEntity<Cliente>(clienteService.save(cliente), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Integer id) {
		if (clienteService.delete(id)) {
			return new ResponseEntity<Object>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
	}
}
