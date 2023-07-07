package com.negocio.ubi.api.rest.Contoller;

import com.negocio.ubi.api.rest.Security.Controller.Mensaje;
import org.apache.commons.lang3.StringUtils;
import com.negocio.ubi.api.rest.Dto.DtoUser;
import com.negocio.ubi.api.rest.Entity.User;
import com.negocio.ubi.api.rest.Service.SUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class CUser {

    @Autowired
    SUser sUser;

    @GetMapping("/lista")
    public ResponseEntity<List<User>> list(){
        List<User> list = sUser.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("detalle/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        if(!sUser.existsById(id)){
            return new ResponseEntity<>(new Mensaje("No existe el Id"), HttpStatus.BAD_REQUEST);
        }

        User user = sUser.getOne(id).get();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody DtoUser dtoUser){
        if(StringUtils.isBlank(dtoUser.getNombre())){
            return new ResponseEntity<>(new Mensaje ("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if(sUser.existsByNombre(dtoUser.getNombre())){
            return new ResponseEntity<>(new Mensaje ("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }

        User user = new User(dtoUser.getNombre(), dtoUser.getMail(), dtoUser.getTipoUsuario());
        sUser.save(user);
        return new ResponseEntity<>(new Mensaje ("Usuario creado"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody DtoUser dtoUser){
        if(!sUser.existsById(id)){
            return new ResponseEntity<>(new Mensaje("No existe el Id"), HttpStatus.BAD_REQUEST);
        }

        if(sUser.existsByNombre(dtoUser.getNombre()) && sUser.getByNombre(dtoUser.getNombre()).get().getId() !=id){
            return new ResponseEntity<>(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }

        if(StringUtils.isBlank(dtoUser.getNombre())){
            return new ResponseEntity<>(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }

        User user = sUser.getOne(id).get();

        user.setNombre(dtoUser.getNombre());
        user.setMail(dtoUser.getMail());
        user.setTipoUsuario(dtoUser.getTipoUsuario());

        sUser.save(user);

        return new ResponseEntity<>(new Mensaje("Usuario actualizado"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        if(!sUser.existsById(id)){
            return new ResponseEntity<>(new Mensaje ("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sUser.delete(id);
        return new ResponseEntity<>(new Mensaje("Usuario eliminada"), HttpStatus.OK);
    }


}
