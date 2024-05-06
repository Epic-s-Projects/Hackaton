package com.example.java.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.java.Model.Usuario;
import java.util.List;


public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
    Usuario findByEmail(String email);
    Usuario existsByEmail(String email);
}
