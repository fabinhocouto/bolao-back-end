package io.github.fabinhocouto.service;

import io.github.fabinhocouto.domain.entity.Usuario;
import io.github.fabinhocouto.rest.dto.UsuarioDTO;

public interface UsuarioService {
    Usuario salvar (UsuarioDTO usuarioDTO);
    void deletar (Integer id);
    void atualizar (Integer id, UsuarioDTO usuarioDTO);
}
