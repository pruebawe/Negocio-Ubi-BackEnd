package com.negocio.ubi.api.rest.Repository;

import com.negocio.ubi.api.rest.Entity.Negocio;
import com.negocio.ubi.api.rest.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NRepository extends JpaRepository<Negocio, Long> {

    public Optional<Negocio> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);

}
