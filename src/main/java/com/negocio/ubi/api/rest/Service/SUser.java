package com.negocio.ubi.api.rest.Service;

import com.negocio.ubi.api.rest.Entity.User;
import com.negocio.ubi.api.rest.Repository.URepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SUser {
    @Autowired
     URepository uRepository;

    public List<User> list(){
        return uRepository.findAll();
    }

    public Optional<User> getOne(Long id){
        return uRepository.findById(id);
    }

    public Optional<User> getByNombre(String nombre){
        return uRepository.findByNombre(nombre);
    }

    public void save (User user){
        uRepository.save(user);
    }

    public void delete(Long id){
        uRepository.deleteById(id);
    }

    public boolean existsById(Long id){
        return uRepository.existsById(id);
    }

    public boolean existsByNombre(String nombre){
        return uRepository.existsByNombre(nombre);
    }

}
