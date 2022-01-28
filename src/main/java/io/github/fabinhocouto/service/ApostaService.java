package io.github.fabinhocouto.service;

import io.github.fabinhocouto.domain.entity.Aposta;
import io.github.fabinhocouto.domain.enums.StatusAposta;
import io.github.fabinhocouto.rest.dto.ApostaDTO;

public interface ApostaService {
    Aposta salvar(ApostaDTO apostaDTO);
}
