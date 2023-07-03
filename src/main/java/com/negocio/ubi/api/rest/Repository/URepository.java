package com.negocio.ubi.api.rest.Repository;

import com.negocio.ubi.api.rest.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface URepository extends JpaRepository<User, Long>{
    public Optional<User> fyndByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
