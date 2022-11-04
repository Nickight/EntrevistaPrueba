package com.entrevista.controller;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.entrevista.components.ComponentEstudiante;
import com.entrevista.model.Estudiante;
import com.entrevista.model.Notas;
import com.entrevista.service.IEstudianteService;
import com.entrevista.service.INotasService;

@org.springframework.stereotype.Controller
public class Controller {

	@Autowired
	private IEstudianteService estudianteService;

	@Autowired
	private INotasService notasService;

	@GetMapping("/")
	public String thyme(Model model) {

		String mensaje = "Examen";

		model.addAttribute("mensaje", mensaje);

		// devuelve la pagina que se va a desplegar en el navegador en este caso index
		return "index";
	}

	@GetMapping("/agregar")
	public String agregar(Estudiante estudiante) {
		return "estudiante";
	}

	@PostMapping("/guardar")
	public String guardar(@Validated Estudiante estudiante, Errors errores) {

		if (errores.hasErrors()) {
			// si tenemos errores retornamos al index
			return "redirect:/";
		}

		estudianteService.guardar(estudiante);
		return "redirect:/examen"; 
	}
	
	@GetMapping("/examen")
	public String examen(Notas notas, Model model) {
		
		ComponentEstudiante cEstudiante = new ComponentEstudiante();
		
		var pregunta1 = cEstudiante.getPregunta1();
		model.addAttribute("pregunta1", pregunta1);
		var pregunta2 = cEstudiante.getPregunta2();
		model.addAttribute("pregunta2", pregunta2);
		var pregunta3 = cEstudiante.getPregunta3();
		model.addAttribute("pregunta3", pregunta3);
		var pregunta4 = cEstudiante.getPregunta4();
		model.addAttribute("pregunta4", pregunta4);
		
		
		var arrayPregunta1 = cEstudiante.preguntaUnoArray();
		model.addAttribute("arrayPregunta1", arrayPregunta1);
		
		var arrayPregunta2 = cEstudiante.preguntaDosArray();
		model.addAttribute("arrayPregunta2", arrayPregunta2);
		
		var arrayPregunta3 = cEstudiante.preguntaTresArray();
		model.addAttribute("arrayPregunta3", arrayPregunta3);
		
		var arrayPregunta4 = cEstudiante.preguntaCuatroArray();
		model.addAttribute("arrayPregunta4", arrayPregunta4);
		
		
		return "examen";
	}
	
	
	
	@PostMapping("/enviarprueba")
	public String guardarNotas(@Validated Notas notas, Errors errores) {

		if (errores.hasErrors()) {
			// si tenemos errores retornamos a la vista de modificar
			return "redirect:/examen";
		}

		notasService.guardar(notas);
		return "redirect:/notas"; 
	}
	
	
	
	
	
	
	

	@GetMapping("/notas")
	public String notas(Model model) {

		var estudiante = estudianteService.listarPersonas();
		String nombreEstudiante = "";
		for(var n: estudiante){
			nombreEstudiante = n.getNombre();
        }
		
		model.addAttribute("nombreEstudiante", nombreEstudiante);

		var notas = notasService.listarNotas();
		
		String nota1 = "", nota2="", nota3="", nota4="";
        for(var p: notas){
        	nota1 = p.getNota1();
        	nota2 = p.getNota2();
        	nota3 = p.getNota3();
        	nota4 = p.getNota4();
        }
        
        
        
        int puntaje1 = nota1.equals("Java") ? (puntaje1 = 25) : (puntaje1 = 0);
        int puntaje2 = nota2.equals("James Gosling") ? (puntaje1 = 25) : (puntaje1 = 0);
        int puntaje3 = nota3.equals("1995") ? (puntaje1 = 25) : (puntaje1 = 0);
        int puntaje4 = nota4.equals("public class Componente extends Producto") ? (puntaje1 = 25) : (puntaje1 = 0);
        int calificacion = puntaje1 + puntaje2 + puntaje3 + puntaje4;
        
        model.addAttribute("puntaje1", puntaje1);
        model.addAttribute("puntaje2", puntaje2);
        model.addAttribute("puntaje3", puntaje3);
        model.addAttribute("puntaje4", puntaje4);
        model.addAttribute("calificacion", calificacion);
		
		model.addAttribute("notas", notas);
		
		//zona ID
		
		String zona = "";
		for(var n: estudiante){
			nombreEstudiante = n.getNombre();
			zona = n.getZona();
        }
		
		ZoneId zonaid = ZoneId.of(zona);
		
		ComponentEstudiante zonaEstudiante = new ComponentEstudiante();
		ZonedDateTime zonaDate = zonaEstudiante.obtenerZonaHoraria(zonaid);
		String zonaparse = zonaDate.toString();
		model.addAttribute("zonaparse", zonaparse);
		return "nota";
	}
}
