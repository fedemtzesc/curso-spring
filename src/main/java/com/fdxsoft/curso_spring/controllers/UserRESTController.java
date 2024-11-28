package com.fdxsoft.curso_spring.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fdxsoft.curso_spring.dto.UserDTO;
import com.fdxsoft.curso_spring.models.UserModel;


@RestController
@RequestMapping("/api")
public class UserRESTController {
    
    @GetMapping("test-text")
    public String testText() {
        return "Se retorna una cadena de texto simple";
    }

    // Este ejemplo solo regresa una cadena de texto que depente del parametro que se reciba
    @GetMapping("saludo-parametro")
    public String saludoTextoConOSinParametro(@RequestParam(required = false) String name) {
        if(name==null){
            return "Hola sin el parametro name en el URL!";
        }else{
        return "Hola " + name + "!";
        }
    }
    
    // Ejemplo de respueta con un objeto DTO (Data Transfer Object)
    @GetMapping("user-dto")
    public UserDTO getUserDTOResponse() {
        UserDTO userDTO = new UserDTO();
        UserModel userModel = new UserModel("Elizabeth", "Martinez", "chuky@gmail.com", "8119990675");
        userDTO.setTittle("Objeto DTO respondido!");
        userDTO.setUser(userModel);
        return userDTO;
    }

    /*
     * Ejemplo de creacion de una lista de objetos devuelta
     */
    @GetMapping("user-dto-list")
    public List<UserDTO> getUserDTOList() {
        List<UserDTO> users = new ArrayList<>();

        for(int i=1; i<=1000;i++){
            UserDTO userDTO = new UserDTO();
            UserModel userModel = new UserModel("Name"+i, "LastName"+i, "user"+i+"@gmail.com", "81199906"+i);
            userDTO.setTittle("Objeto DTO " + i);
            userDTO.setUser(userModel);
            Random rnd = new Random();
            int j = Math.abs(rnd.nextInt())%9;
            List<String> lst = List.of("Conejo " + j,"Pollo " + j);
            userDTO.setLista(lst);
            users.add(userDTO);
        }
        
        return users;
    }

    @GetMapping("path/{variable}")
    public String getMethodName(@PathVariable String variable) {
        return "EL valor de la variable es " + variable;
    }
    
    
}
