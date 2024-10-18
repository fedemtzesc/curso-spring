package com.fdxsoft.curso_spring.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fdxsoft.curso_spring.models.UserModel;



@Controller
public class UserController {

    @Value("${BUSSINESS_NAME}")
    private String bussiness_name;

    @Value("${program.author}")
    private String app_author;
    
    @GetMapping("details")
    public String details() {
        
        return "details";
    }

    //Aqui ya estamos llamando a una plantilla de Thymeleaf
    //La cual se configura dentro del archivo HTML escribiendo 
    //lo siguiente en el tag principal de HTML:
    //      <html lang="en" xmlns:th="http://www.thymeleaf.org">
    @GetMapping("pasoparametrosmodel")
    public String pasoParametrosConModel(Model model) {
         model.addAttribute("tittle", "Paso de parametros");
         model.addAttribute("h1Content", "Usando el objeto Model de Spring");
         model.addAttribute("name", "Federico");
         model.addAttribute("lastname", "Martinez");
         return "pasoparametros";
    }

    @GetMapping("pasoparametrosmap")
    public String pasoParametrosConModel(Map<String, Object> model) {
         model.put("tittle", "Paso de parametros");
         model.put("h1Content", "Usando el objeto Model de Spring");
         model.put("name", "Federico");
         model.put("lastname", "Martinez");
         //La misma plantilla funciona tanto para recibir parametros con 
         //Model o con Map
         return "pasoparametros";
    }

    @GetMapping("paso-de-datos-a-html")
    public String pasoDatosAPagHTML(Model model){
        
        UserModel userModel = new UserModel("Alicia", "Martinez", "pdlga_alicia@gmail.com", null);
        model.addAttribute("user", userModel);
        model.addAttribute("tittle", "Paso de Datos a Pagina");
        model.addAttribute("bussiness_name", bussiness_name);
        model.addAttribute("app_author", app_author);
        return "paginausuario";
    }

    //Listado de objetos JSON
    @GetMapping("json-user-list-response-body")
    @ResponseBody //Esta anotacion le permite al controlador comportarse como un RESTController
    public  Map<String, Object> jsonUserListResponse() {
        Map<String, Object> userList = new HashMap<>();
        for(int i=0; i<5; i++){
            UserModel userTemp = new UserModel("Name" + i, "LastName" + i, "user"+i+"@gmail.com", "8911009941" + i);
            userList.put("User" + i, userTemp);
        }
        
        return userList;
    }

    @GetMapping("model-map-list")
    public String modelMapList(ModelMap modelMap) {
        //@ModelAttribute("users") reemplaza la linea de abajo    
        //modelMap.addAttribute("users", users);
        modelMap.addAttribute("title", "Listado de Usuarios Modelo!");
        return "list";
    }
    
    @ModelAttribute("users")
    public List<UserModel> getUserList(){
        List<UserModel> users = new ArrayList<>();
        for(int i=0; i<10; i++){ 
            UserModel userTemp = new UserModel("Name" + i, "LastName" + i, "user"+i+"@gmail.com", "891100994" + i);
            users.add(userTemp);
        }
        return users;
    }
    
}
