package com.fdxsoft.curso_spring.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fdxsoft.curso_spring.dto.UserDTO;
import com.fdxsoft.curso_spring.models.UserModel;

import jakarta.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/api")
public class RequestParamController {
    @GetMapping("/parametro-test")
    public String getGreetingParam(@RequestParam(required = false) String nombre) {
        if(nombre==null){
            return "Falta capturar el parametro nombre";
        }else{
            return "Hola " + nombre.toUpperCase();
        }
    }

    @GetMapping("/user-dto-param")
    public UserDTO getUserDTOParam(@RequestParam(required = false) String name, 
                                    @RequestParam(required = false) String lastName,
                                    @RequestParam(required = false) String email,
                                    @RequestParam(required = false, defaultValue = "n/a") String phone) {
        List<String> frutas = List.of("Papaya","Fresa", "Durazno", "Naranja");
        UserDTO userDTO = new UserDTO();
        userDTO.setTittle("Datos se obtuvieron como parametros!");
        userDTO.setLista(frutas);
        userDTO.setUser(new UserModel(name, lastName, email, phone));
        return userDTO;
    }

    // Este metodo se utiliza cuando son muchos los parametros que se tienen que recibir
    @GetMapping("httpservletrequest")
    public UserModel requestExample(HttpServletRequest request){
        UserModel userModel = new UserModel();
        userModel.setName(request.getParameter("name"));
        userModel.setLastName(request.getParameter("lastName"));
        userModel.setEmail(request.getParameter("email"));
        userModel.setTelephone(request.getParameter("telephone"));

        return userModel;
    }
}
