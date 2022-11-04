package com.entrevista.service;

import java.util.List;

import com.entrevista.model.Notas;

public interface INotasService {

	public List<Notas> listarNotas();
	public void guardar(Notas notas);
}
