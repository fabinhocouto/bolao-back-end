package io.github.fabinhocouto.service;

import io.github.fabinhocouto.domain.entity.Jogo;
import io.github.fabinhocouto.domain.enums.StatusJogo;
import io.github.fabinhocouto.rest.dto.JogoDTO;

import java.util.Optional;

public interface JogoService {
    Jogo salvar (JogoDTO jogoDTO);
    void deletar (Integer id);
    void atualizar (Integer id, JogoDTO jogoDTO);
    void atualizarStatusJogo(Integer id, StatusJogo statusJogo);
    Optional<Jogo> obterJogoCompleto(Integer id);
}
