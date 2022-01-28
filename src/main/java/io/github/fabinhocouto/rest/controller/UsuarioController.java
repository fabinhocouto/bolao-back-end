package io.github.fabinhocouto.rest.controller;

import io.github.fabinhocouto.domain.entity.Usuario;
import io.github.fabinhocouto.rest.dto.UsuarioDTO;
import io.github.fabinhocouto.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer save( @RequestBody @Valid UsuarioDTO usuarioDTO ){
        Usuario usuario = usuarioService.salvar(usuarioDTO);
        return usuario.getId();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete( @PathVariable Integer id){
        usuarioService.deletar(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody @Valid UsuarioDTO usuarioDTO){
        usuarioService.atualizar(id, usuarioDTO);
    }

}
