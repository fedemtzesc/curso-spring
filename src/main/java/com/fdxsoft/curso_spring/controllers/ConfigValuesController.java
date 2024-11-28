package com.fdxsoft.curso_spring.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class ConfigValuesController {
    @Value("${config.owner.app}")
    private String ownerApp;
    @Value("${config.owner.age}")
    private int ownerAge;
    @Value("${config.creation.date}")
    private String startDate;
    @Value("${config.ending.date}")
    private String endDate;
    @Value("${config.owner.carer}")
    private String ownerCarer;
    @Value("#{'${config.owner.sisters}'.toUpperCase().trim().split(',')}")
    private String[] sisterList;
    @Value("#{'${config.owner.sisters}'.toUpperCase()}")
    private String stringList;
    //Para los tipos de dato mapa se tiene que usar esta sintaxis
    @Value("#{${config.values.map}}")
    private Map<String,Object> mapa;
    //Y podemos obtener llaves del mapa de forma individual asi:
    @Value("#{${config.values.map}.price}") //la llave price esta en el mapa en el *.properties
    private String price;

    //Otra manera de acceder a las variables de los archivos properties es usando el bean que 
    //acompaña a Spring-Boot llamado Environment
    @Autowired
    Environment env;

    @GetMapping("/show-config-values")
    public Map<String, Object> getConfigValues(@Value("${config.owner.sisters}") List<String> sisters) {
        //En este ejemplo podemos ver que el Value puede ir como Parametro Formal de la Funcion
        Map<String, Object> values = new HashMap<>();
        values.put("config.owner.app", ownerApp);
        values.put("config.owner.age", ownerAge);
        values.put("config.creation.date", startDate);
        values.put("config.ending.date", endDate);
        values.put("config.owner.carer", ownerCarer);
        values.put("config.owner.sisters", sisters);
        values.put("config.owner.sisters2", sisterList);
        values.put("systers.upper", stringList);
        values.put("mapa", mapa);
        values.put("price", price);
        //Estos son dos ejemplos de uso del bean Environment
        values.put("env.message",env.getProperty("env.message"));
        values.put("code", env.getProperty("env.code", Long.class));

        return values;
    }
    
}
