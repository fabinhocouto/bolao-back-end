package io.github.fabinhocouto.service.impl;

import io.github.fabinhocouto.domain.entity.Concurso;
import io.github.fabinhocouto.domain.entity.Usuario;
import io.github.fabinhocouto.domain.repository.ConcursoRepository;
import io.github.fabinhocouto.domain.repository.UsuarioRepository;
import io.github.fabinhocouto.rest.dto.ConcursoDTO;
import io.github.fabinhocouto.rest.dto.UsuarioDTO;
import io.github.fabinhocouto.service.ConcursoService;
import io.github.fabinhocouto.service.UsuarioService;
import jdk.internal.org.objectweb.asm.Type;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public Usuario salvar(UsuarioDTO usuarioDTO) {

        Usuario usuario = new Usuario();
        usuario.setCpf(usuarioDTO.getCpf());
        usuario.setNome(usuarioDTO.getNome());

        return usuarioRepository.save(usuario);

    }

    @Override
    @Transactional
    public void deletar(Integer id) {

        usuarioRepository
                .findById(id)
                .map(usuario -> {
                    usuarioRepository.delete(usuario);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Usuário não encontrado."));
    }

    @Override
    @Transactional
    public void atualizar(Integer id, UsuarioDTO usuarioDTO) {

        usuarioRepository
                .findById(id)
                .map(usuario -> {
                    usuario.setCpf(usuarioDTO.getCpf());
                    usuario.setNome(usuarioDTO.getNome());
                    usuarioRepository.save(usuario);
                    return Type.VOID;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado."));

    }
}
