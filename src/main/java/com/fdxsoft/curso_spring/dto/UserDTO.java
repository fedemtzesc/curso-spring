package com.fdxsoft.curso_spring.dto;

import java.util.List;

import com.fdxsoft.curso_spring.models.UserModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String tittle;
    private UserModel user;
    private List<String> lista = List.of("Perros", "Gatos");
}
