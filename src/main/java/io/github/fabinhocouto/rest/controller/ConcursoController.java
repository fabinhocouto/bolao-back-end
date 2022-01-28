package io.github.fabinhocouto.rest.controller;

import io.github.fabinhocouto.domain.entity.Concurso;
import io.github.fabinhocouto.rest.dto.ConcursoDTO;
import io.github.fabinhocouto.service.ConcursoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/concursos")
public class ConcursoController {

    private ConcursoService concursoService;

    public ConcursoController(ConcursoService concursoService) {
        this.concursoService = concursoService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer save( @RequestBody @Valid ConcursoDTO concursoDTO ){
        Concurso concurso = concursoService.salvar(concursoDTO);
        return concurso.getId();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete( @PathVariable Integer id){
        concursoService.deletar(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody @Valid ConcursoDTO concursoDTO){
        concursoService.atualizar(id, concursoDTO);
    }

}
