package com.entrevista.components;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

import org.springframework.stereotype.Component;


@Component
public class ComponentEstudiante {
	
	private String  pregunta1 = "¿ Cual es el lenguaje de programación más famoso y por que es java ?",
            pregunta2 = "¿ Quien es el creador de java ?",
            pregunta3 = "¿ En que año fue desarrollado java ?",
            pregunta4 = "¿Qué código de los siguientes tiene que ver con la herencia?";
	
	
	
	
	
	 public String getPregunta1() {
		return pregunta1;
	}

	public void setPregunta1(String pregunta1) {
		this.pregunta1 = pregunta1;
	}

	public String getPregunta2() {
		return pregunta2;
	}

	public void setPregunta2(String pregunta2) {
		this.pregunta2 = pregunta2;
	}

	public String getPregunta3() {
		return pregunta3;
	}

	public void setPregunta3(String pregunta3) {
		this.pregunta3 = pregunta3;
	}

	public String getPregunta4() {
		return pregunta4;
	}

	public void setPregunta4(String pregunta4) {
		this.pregunta4 = pregunta4;
	}
	
	public Collection<String> preguntaUnoArray() {
		var opciones1 = Arrays.asList("Java", "Python","c", "Javascript" );
	    Collections.shuffle(opciones1);
		return opciones1;
	}
	
	public Collection<String> preguntaDosArray() {
		var opciones2 = Arrays.asList("Guido van Rossum", "Yukihiro Matsumoto","James Gosling", "Bjarne Stroustrup" );
        Collections.shuffle(opciones2);
		return opciones2;
	}
	
	public Collection<String> preguntaTresArray() {
		var opciones3 = Arrays.asList("1995", "1992","2001", "1999" );
        Collections.shuffle(opciones3);
		return opciones3;
	}
	
	public Collection<String> preguntaCuatroArray() {
		var opciones4 = Arrays.asList("public class Componente inherit Producto", "public class Componente extends Producto",
                "public class Componente belong to Producto", "public class Componente implements Producto" );
        Collections.shuffle(opciones4);
		return opciones4;
	}
	
	
	public ZonedDateTime obtenerZonaHoraria(ZoneId zone) {
		
		//obtener zonas horarias
        //		Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        //        for (String zoneId : availableZoneIds) {
        //            System.out.println(zoneId);
        //        }

		
		//zonas horarias que aplique
        //ZoneId zoneIdBg = ZoneId.of("America/Bogota");
        //ZoneId zoneIdMx = ZoneId.of("America/Mexico_City");
        //ZoneId zoneIdUs = ZoneId.of("US/Central");
        
		
		return  ZonedDateTime.now(zone);
		
	}
	

}
