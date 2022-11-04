package com.entrevista.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entrevista.dao.NotasDao;
import com.entrevista.model.Notas;

@Service
public class NotasServiceImpl implements INotasService {
	
	@Autowired
	private NotasDao notasDao;

	@Override
	@Transactional(readOnly = true)
	public List<Notas> listarNotas() {

		return (List<Notas>) notasDao.findAll();
	}

	@Override
	@Transactional
	public void guardar(Notas notas) {
		notasDao.save(notas);
		
	}

}
