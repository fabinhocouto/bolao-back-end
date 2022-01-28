package io.github.fabinhocouto.domain.repository;


import io.github.fabinhocouto.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
