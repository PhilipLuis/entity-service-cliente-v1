package com.cliente.service;

import java.io.File;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;

import com.cliente.utils.ClienteConstants;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SequenceServiceImpl implements SequenceService {

	@Override
	public int getNextValue() {
		this.validaFileSequence();
		ObjectMapper mapper;
		int value = 0;
		try {
			mapper = new ObjectMapper();
			value = mapper.readValue(Paths.get(ClienteConstants.FILE_SEQUENCE).toFile(), Integer.class);
			value++;
			mapper.writeValue(Paths.get(ClienteConstants.FILE_SEQUENCE).toFile(), value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
	void validaFileSequence(){
		ObjectMapper mapper;
		
		try {
			File file = new File(ClienteConstants.FILE_SEQUENCE);
			if (!file.exists()) {
				mapper = new ObjectMapper();
				mapper.writeValue(Paths.get(ClienteConstants.FILE_SEQUENCE).toFile(), 0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
