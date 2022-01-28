package io.github.fabinhocouto.rest.controller;

import io.github.fabinhocouto.domain.entity.Aposta;
import io.github.fabinhocouto.domain.entity.Concurso;
import io.github.fabinhocouto.domain.entity.Jogo;
import io.github.fabinhocouto.rest.dto.ConcursoDTO;
import io.github.fabinhocouto.rest.dto.InformacaoApostaDTO;
import io.github.fabinhocouto.rest.dto.InformacaoJogoDTO;
import io.github.fabinhocouto.rest.dto.JogoDTO;
import io.github.fabinhocouto.service.ConcursoService;
import io.github.fabinhocouto.service.JogoService;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/jogos")
public class JogoController {

    private JogoService jogoService;

    public JogoController(JogoService jogoService) {
        this.jogoService = jogoService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer save( @RequestBody @Valid JogoDTO jogoDTO ){
        Jogo jogo = jogoService.salvar(jogoDTO);
        return jogo.getId();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete( @PathVariable Integer id){
        jogoService.deletar(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody @Valid JogoDTO jogoDTO){
        jogoService.atualizar(id, jogoDTO);
    }

    @GetMapping("{id}")
    public InformacaoJogoDTO getById(@PathVariable Integer id ){
        return jogoService
                .obterJogoCompleto(id)
                .map( p -> converter(p) )
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Jogo não encontrado."));
    }

    private InformacaoJogoDTO converter(Jogo jogo){
        return InformacaoJogoDTO
                .builder()
                .codigo(jogo.getId())
                .numeroMaximoAposta(jogo.getNumeroMaximoAposta())
                .statusJogo(jogo.getStatusJogo().name())
                .dataInicio(jogo.getDataInicio().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .valorAposta(jogo.getValorAposta())
                //.dataTermino(jogo.getDataTermino().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .apostas(converter(jogo.getApostas()))
                .build();
    }

    private List<InformacaoApostaDTO> converter(List<Aposta> apostas){
        if(CollectionUtils.isEmpty(apostas)){
            return Collections.emptyList();
        }
        return apostas.stream().map(
                aposta -> InformacaoApostaDTO
                        .builder()
                        .nomeUsuario(aposta.getUsuario().getNome())
                        .numeros(aposta.getNumeros())
                        .build()
        ).collect(Collectors.toList());
    }

}
