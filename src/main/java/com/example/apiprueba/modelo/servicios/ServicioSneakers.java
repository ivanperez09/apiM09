package com.example.apiprueba.modelo.servicios;

import com.example.apiprueba.modelo.entidades.Sneaker;
import com.example.apiprueba.modelo.repositorios.RepositorioSneaker;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioSneakers {
    private final RepositorioSneaker repoSnk;

    public ServicioSneakers(RepositorioSneaker repoSnk) {
        this.repoSnk = repoSnk;
    }

    //Lista todas las Sneakers
    public List<Sneaker> listAllSneakers(){
        return repoSnk.findAll();
    }

    //Busca sneaker por ID
    public Sneaker findSneaker(Integer id){
        return repoSnk.findById(id).orElse(null);
    }

    //Añadir Sneaker
    public Sneaker addSneaker(Sneaker sneaker){
        return repoSnk.save(sneaker);
    }

    //Update Sneaker
    public Sneaker updateSneaker(Sneaker sneaker){
        Sneaker snk = null;
        if (repoSnk.existsById(sneaker.getSneakerId())) snk = repoSnk.save(sneaker);
        return snk;
    }

    //Elimina Sneaker
    public Sneaker deleteSneaker(Integer id){
        Sneaker res = repoSnk.findById(id).orElse(null);
        if(res != null) repoSnk.deleteById(id);
        return res;
    }
}
