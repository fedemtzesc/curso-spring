package com.fdxsoft.curso_spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
    @PropertySource(value = "classpath:customconfig.properties", encoding = "UTF-8"),
    @PropertySource(value = "classpath:otro.properties", encoding = "UTF-8") //UTF-8 es para mostrar caracteres especiales
})
public class ConfigFile {
    /*
     * Este archivo puede servir para meter todas las configuraicon de archivos de properties
     * que estaria utilizando la aplicacion para funcionar.
     * ENCODING: Para poder mostrar correctamente las vocales atenuadas y las &ntilde tenemos
     * que agregarle al PropertySource el atributo encodig con el valor UTF-8
     */
}
