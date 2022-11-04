package com.entrevista.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entrevista.dao.EstudianteDao;
import com.entrevista.model.Estudiante;


@Service
public class EstudianteServiceImpl implements IEstudianteService{

	
	@Autowired
	private EstudianteDao estudianteDao;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Estudiante> listarPersonas() {
		
		
		return (List<Estudiante>) estudianteDao.findAll();
	}
	
	@Override
    @Transactional
    public void guardar(Estudiante estudiante) {
		estudianteDao.save(estudiante);
    }


	
}
