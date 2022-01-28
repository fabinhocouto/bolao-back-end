package io.github.fabinhocouto.rest.controller;

import io.github.fabinhocouto.domain.entity.Aposta;
import io.github.fabinhocouto.domain.entity.Concurso;
import io.github.fabinhocouto.domain.enums.StatusAposta;
import io.github.fabinhocouto.rest.dto.ApostaDTO;
import io.github.fabinhocouto.rest.dto.AtualizacaoNovoStatusApostaDTO;
import io.github.fabinhocouto.rest.dto.ConcursoDTO;
import io.github.fabinhocouto.rest.dto.UsuarioDTO;
import io.github.fabinhocouto.service.ApostaService;
import io.github.fabinhocouto.service.ConcursoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/apostas")
public class ApostaController {

    private ApostaService apostaService;

    public ApostaController(ApostaService apostaService) {
        this.apostaService = apostaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Aposta salvar(@RequestBody @Valid ApostaDTO apostaDTO){
        return apostaService.salvar(apostaDTO);
    }

}
