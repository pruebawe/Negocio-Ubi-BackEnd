package com.negocio.ubi.api.rest.Contoller;


import com.negocio.ubi.api.rest.Dto.DtoNegocio;
import com.negocio.ubi.api.rest.Entity.Negocio;
import com.negocio.ubi.api.rest.Security.Controller.Mensaje;
import com.negocio.ubi.api.rest.Service.SNegocio;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/negocios")
public class CNegocio {

    @Autowired
    SNegocio sNegocio;

    @GetMapping("/lista")
    public ResponseEntity<List<Negocio>> list(){
        List<Negocio> list = sNegocio.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("detalle/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        if(!sNegocio.existsById(id)){
            return new ResponseEntity<>(new Mensaje("No existe el Id"), HttpStatus.BAD_REQUEST);
        }

        Negocio negocio = sNegocio.getOne(id).get();
        return new ResponseEntity<>(negocio, HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody DtoNegocio dtoNegocio){
        if(StringUtils.isBlank(dtoNegocio.getNombre())){
            return new ResponseEntity<>(new Mensaje ("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if(sNegocio.existsByNombre(dtoNegocio.getNombre())){
            return new ResponseEntity<>(new Mensaje ("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }

        Negocio negocio = new Negocio(
                dtoNegocio.getNombre(),
                dtoNegocio.getDescripcion(),
                dtoNegocio.getDireccion(),
                dtoNegocio.getLatitud(),
                dtoNegocio.getLongitud(),
                dtoNegocio.getHorarioInicio(),
                dtoNegocio.getHorarioFin());
        sNegocio.save(negocio);
        return new ResponseEntity<>(new Mensaje ("Negocio creado"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody DtoNegocio dtoNegocio){
        if(!sNegocio.existsById(id)){
            return new ResponseEntity<>(new Mensaje("No existe el Id"), HttpStatus.BAD_REQUEST);
        }

        if(sNegocio.existsByNombre(dtoNegocio.getNombre()) && sNegocio.getByNombre(dtoNegocio.getNombre()).get().getId() !=id){
            return new ResponseEntity<>(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }

        if(StringUtils.isBlank(dtoNegocio.getNombre())){
            return new ResponseEntity<>(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }

        Negocio negocio = sNegocio.getOne(id).get();

        negocio.setNombre(dtoNegocio.getNombre());
        negocio.setDescripcion(dtoNegocio.getDescripcion());
        negocio.setDireccion(dtoNegocio.getDireccion());
        negocio.setLatitud(dtoNegocio.getLatitud());
        negocio.setLongitud(dtoNegocio.getLongitud());
        negocio.setHorarioInicio(dtoNegocio.getHorarioInicio());
        negocio.setHorarioFin(dtoNegocio.getHorarioFin());

        sNegocio.save(negocio);

        return new ResponseEntity<>(new Mensaje("Negocio actualizado"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        if(!sNegocio.existsById(id)){
            return new ResponseEntity<>(new Mensaje ("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sNegocio.delete(id);
        return new ResponseEntity<>(new Mensaje("Negocio eliminado"), HttpStatus.OK);
    }

}
