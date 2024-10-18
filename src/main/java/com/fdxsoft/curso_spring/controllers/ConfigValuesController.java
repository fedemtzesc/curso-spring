package com.fdxsoft.curso_spring.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
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
        return values;
    }
    
}
