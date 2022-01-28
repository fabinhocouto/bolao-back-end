package io.github.fabinhocouto.domain.repository;


import io.github.fabinhocouto.domain.entity.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface JogoRepository extends JpaRepository<Jogo, Integer> {

    @Query(" select p from Jogo p left join fetch p.apostas where p.id = :id ")
    Optional<Jogo> findByIdFetchApostas(@Param("id") Integer id);

}
