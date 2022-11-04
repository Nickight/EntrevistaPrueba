package com.entrevista.dao;


import org.springframework.data.repository.CrudRepository;

import com.entrevista.model.Estudiante;

public interface EstudianteDao extends CrudRepository<Estudiante, Long>{

}
