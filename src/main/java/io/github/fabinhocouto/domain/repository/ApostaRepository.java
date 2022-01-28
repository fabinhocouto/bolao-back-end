package io.github.fabinhocouto.domain.repository;

import io.github.fabinhocouto.domain.entity.Aposta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApostaRepository extends JpaRepository<Aposta, Integer> {

}
