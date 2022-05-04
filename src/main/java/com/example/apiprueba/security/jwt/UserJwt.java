package com.example.apiprueba.security.jwt;

import com.example.apiprueba.modelo.entidades.UserConsultaDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UserJwt extends UserConsultaDTO {
    private String token;

    @Builder(builderMethodName = "jwtUsuariJwtBuilder")
    public UserJwt(String username, String avatar, String rol, String token){
        super(username,avatar,rol);
        this.token =token;
    }
}
