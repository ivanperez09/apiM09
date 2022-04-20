package com.example.apiprueba.controladores;

import com.example.apiprueba.modelo.entidades.User;
import com.example.apiprueba.modelo.entidades.UserConsultaDTO;
import com.example.apiprueba.modelo.servicios.ServicioUser;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
@RestController
public class ControladorRegistroLoginUsuarios {
    private final ServicioUser servicioUser;

    public ControladorRegistroLoginUsuarios(ServicioUser servicioUser) {
        this.servicioUser = servicioUser;
    }

    @GetMapping("/me")
    public UserConsultaDTO checkWhoAmI(@AuthenticationPrincipal User user) {
        return new UserConsultaDTO(user.getUsername(), user.getAvatar(), user.getRol());
    }

    /*
    {
    "username":"Montse",
    "password":"1234",
    "avatar":"http://imatge.com"
    }
    Afegeix id automàticament
     */
    @PostMapping("/users")
    public ResponseEntity<?> newUser(@RequestBody User newUser) {
        try {
            User res = servicioUser.creatNewUser(newUser);
            UserConsultaDTO user = new UserConsultaDTO(res.getUsername(), res.getAvatar(), res.getRol());
            return new ResponseEntity<UserConsultaDTO>(user, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException ex) {
            //per si intentem afegir 2 usuaris amb el mateix username, saltarà excepció
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }

    @GetMapping("/users")
    public ResponseEntity<?> llistarUsuarisDTO() {
        List<User> res = servicioUser.llistarUsuaris();
        List<UserConsultaDTO> aux = new ArrayList();
        for (User user : res) {
            aux.add(new UserConsultaDTO(user.getUsername(), user.getAvatar(), user.getRol()));
        }
        if (res.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else return ResponseEntity.ok(aux);
    }
}
