package com.entrevista.service;

import java.util.List;

import com.entrevista.model.Estudiante;

public interface IEstudianteService {
	
	public List<Estudiante> listarPersonas();

	public void guardar(Estudiante estudiante);

}
