package com.negocio.ubi.api.rest.Service;

import com.negocio.ubi.api.rest.Entity.User;
import com.negocio.ubi.api.rest.Repository.URepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class SUser {
    @Autowired
     URepository uRepository;

    public List<User> list(){
        return uRepository.findAll();
    }

}
