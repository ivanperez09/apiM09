package com.example.apiprueba.modelo.entidades;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserConsultaDTO {
    private String username;
    private String avatar;
    private String rol;
}
