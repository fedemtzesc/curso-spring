package com.fdxsoft.curso_spring.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdxsoft.curso_spring.models.UserModel;


@RestController
@RequestMapping("/api")
public class PathVariableController {
    
    @GetMapping("/path-num/{variablenum}")
    public String getPathVariableNumeric(@PathVariable int variablenum) {
        return "La variable del path es: " + variablenum;
    }

    @GetMapping("/path-str/{variablestr}")
    public String getPathVariableString(@PathVariable String variablestr) {
        return "La variable del path es: " + variablestr;
    }

    // Este ejemplo muestra que se pueden usar mas de un path variable
    /*
     * Este es el path de ejemcplo para este end-point:
     * http://localhost:5050/api/mix/remignton/Perro,Gato,Chango,Elefante,Gato,Jirafa,Huron
     */
    @GetMapping("/mix/{product}/{lista}")
    public Map<String, Object> getKeyValueMap(@PathVariable String product, @PathVariable List<String> lista) {
        Map<String, Object> json = new HashMap<>();
        json.put(product, lista);
        return json;
    }

    @PostMapping("/same-body")
    public UserModel postMethodName(@RequestBody UserModel entity) {
        return entity;
    }
    
}
