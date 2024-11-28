package com.fdxsoft.curso_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * @PropertySource("classpath:customconfig.properties")//<- Esta anotacion sirve para agregar uno o mas
 * @PropertySource("classpath:otro.properties")//<- archivos personalizados de propiedades
 * 
 * Estas anotacioes fueron quitadas de aqui y trasladadas al archivo de configuracion llamado 
 * ConfigFile.java
 */
@SpringBootApplication
public class CursoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursoSpringApplication.class, args);
	}

}
