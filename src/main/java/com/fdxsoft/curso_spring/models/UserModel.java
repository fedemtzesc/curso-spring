package com.fdxsoft.curso_spring.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
    private String name;
    private String lastName;
    private String email;
    private String telephone;
}
