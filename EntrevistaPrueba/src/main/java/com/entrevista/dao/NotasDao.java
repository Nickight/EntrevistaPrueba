package com.entrevista.dao;


import org.springframework.data.repository.CrudRepository;

import com.entrevista.model.Notas;


public interface NotasDao extends CrudRepository<Notas, Long>{
	
}
