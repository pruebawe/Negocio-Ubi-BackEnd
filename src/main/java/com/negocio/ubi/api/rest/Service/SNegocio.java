package com.negocio.ubi.api.rest.Service;

import com.negocio.ubi.api.rest.Entity.Negocio;
import com.negocio.ubi.api.rest.Entity.User;
import com.negocio.ubi.api.rest.Repository.NRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SNegocio {

    @Autowired
    NRepository nRepository;

    public List<Negocio> list(){
        return nRepository.findAll();
    }

    public Optional<Negocio> getOne(Long id){
        return nRepository.findById(id);
    }

    public Optional<Negocio> getByNombre(String nombre){
        return nRepository.findByNombre(nombre);
    }

    public void save (Negocio negocio){
        nRepository.save(negocio);
    }

    public void delete(Long id){
        nRepository.deleteById(id);
    }

    public boolean existsById(Long id){
        return nRepository.existsById(id);
    }

    public boolean existsByNombre(String nombre){
        return nRepository.existsByNombre(nombre);
    }
}
