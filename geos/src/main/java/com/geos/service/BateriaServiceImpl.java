package com.geos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geos.entity.Bateria;
import com.geos.repository.IBateriaRepository;

@Service
public class BateriaServiceImpl implements IBateriaService {

	
	   @Autowired
	    private IBateriaRepository bateriaRepository;

	  
		@Override
		public List<Bateria> getAllBateria() {
			// TODO Auto-generated method stub
		    return bateriaRepository.findAll();
		}
		
}
