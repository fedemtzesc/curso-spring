package com.fdxsoft.curso_spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

                                                //                  Forward vs Redirec
@Controller                                     //La diferencia es que con el Forward se mantiene dentro de 
public class HomeController {                   //la misma peticion HTTP, y no se pierden los parametros que
    @GetMapping({"", "/", "/home"})             //viajan dentro del Request, tampoco cambia la ruta URL, ya 
    public String redirectAction() {            //que no hace un "refresh" de la pagina, sino que, despacha
        return "redirect:/model-map-list";      //a otra accion del controlador pero sin recargar la pagina.
    }                                           //
                                                //Mientras que el redirect cambia la ruta URL, reinicia el
    @GetMapping({"/fdx", "/fdxsoft", "/fede"})  //Request, y refresca el navegador. Ademas de que todos los
    public String forwardActgion() {            //parametros que viajaban en el Request antes del "redirect"
        return "forward:/paso-de-datos-a-html"; //se pierden en este nuevo request.
    }
                                                
}
