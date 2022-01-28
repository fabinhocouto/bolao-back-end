package io.github.fabinhocouto.service.impl;

import io.github.fabinhocouto.domain.entity.Concurso;
import io.github.fabinhocouto.domain.entity.Jogo;
import io.github.fabinhocouto.domain.enums.StatusJogo;
import io.github.fabinhocouto.domain.repository.ConcursoRepository;
import io.github.fabinhocouto.domain.repository.JogoRepository;
import io.github.fabinhocouto.rest.dto.ConcursoDTO;
import io.github.fabinhocouto.rest.dto.JogoDTO;
import io.github.fabinhocouto.service.ConcursoService;
import io.github.fabinhocouto.service.JogoService;
import jdk.internal.org.objectweb.asm.Type;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JogoServiceImpl implements JogoService {

    private final JogoRepository jogoRepository;

    @Override
    @Transactional
    public Jogo salvar(JogoDTO jogoDTO) {

        Jogo jogo = new Jogo();
        jogo.setNumeroMaximoAposta(jogoDTO.getNumeroMaximoAposta());
        jogo.setStatusJogo(StatusJogo.ABERTO_APOSTAS);
        jogo.setDataInicio(LocalDate.now());
        jogo.setValorAposta(jogoDTO.getValorAposta());

        return jogoRepository.save(jogo);

    }

    @Override
    @Transactional
    public void deletar(Integer id) {

        jogoRepository
                .findById(id)
                .map(jogo -> {
                    jogoRepository.delete(jogo);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Jogo não encontrado."));
    }

    @Override
    @Transactional
    public void atualizar(Integer id, JogoDTO jogoDTO) {

        jogoRepository
                .findById(id)
                .map(jogo -> {
                    jogo.setNumeroMaximoAposta(jogoDTO.getNumeroMaximoAposta());
                    jogo.setStatusJogo(jogoDTO.getStatusJogo());
                    jogo.setDataInicio(jogoDTO.getDataInicio());
                    jogo.setDataTermino(jogoDTO.getDataTermino());
                    jogo.setValorAposta(jogoDTO.getValorAposta());
                    
                    jogoRepository.save(jogo);
                    return Type.VOID;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jogo não encontrado."));

    }

    @Override
    @Transactional
    public void atualizarStatusJogo( Integer id, StatusJogo statusJogo ) {
        jogoRepository
                .findById(id)
                .map( jogo -> {
                    jogo.setStatusJogo(statusJogo);
                    return jogoRepository.save(jogo);
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jogo não encontrado.") );
    }

    @Override
    public Optional<Jogo> obterJogoCompleto(Integer id) {
        return jogoRepository.findByIdFetchApostas(id);
    }
}
