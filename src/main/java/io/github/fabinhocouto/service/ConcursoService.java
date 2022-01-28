package io.github.fabinhocouto.service;

import io.github.fabinhocouto.domain.entity.Concurso;
import io.github.fabinhocouto.rest.dto.ConcursoDTO;

public interface ConcursoService {
    Concurso salvar (ConcursoDTO concursoDTO);
    void deletar (Integer id);
    void atualizar (Integer id, ConcursoDTO concursoDTO);
}
