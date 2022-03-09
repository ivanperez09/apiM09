package com.example.apiprueba.controladores;

import com.example.apiprueba.modelo.entidades.Sneaker;
import com.example.apiprueba.modelo.servicios.ServicioSneakers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControladorSneaker {
    private final ServicioSneakers serviciosnk;

    public ControladorSneaker(ServicioSneakers servicioSneakers) {
        this.serviciosnk = servicioSneakers;
    }

    @GetMapping("/sneakers")
    public ResponseEntity<Object>listSneakers(){
        List<Sneaker> sneakerList = serviciosnk.listAllSneakers();
        if (sneakerList == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(sneakerList);
    }

    @GetMapping("/sneakers/{id}")
    public ResponseEntity<Object>sneakerByID(@PathVariable Integer id){
        Sneaker snk = serviciosnk.findSneaker(id);
        if (snk == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(snk);
    }

    @PostMapping("/sneakers")
    public ResponseEntity<Object>createSneaker(@RequestBody Sneaker sneaker){
        Sneaker snk = serviciosnk.addSneaker(sneaker);
        return new ResponseEntity<>(snk, HttpStatus.CREATED);
    }

    @PutMapping("/sneakers")
    public ResponseEntity<Object>updateSneaker(@RequestBody Sneaker sneaker){
        Sneaker snk = serviciosnk.updateSneaker(sneaker);
        return new ResponseEntity<>(snk, HttpStatus.CREATED);
    }

    @DeleteMapping("/sneakers/{id}")
    public ResponseEntity<Object>deleteSneaker(@RequestBody Integer id){
        Sneaker snk = serviciosnk.findSneaker(id);
        if (snk == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(snk);
    }

}
