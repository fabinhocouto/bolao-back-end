package io.github.fabinhocouto.service.impl;

import io.github.fabinhocouto.domain.entity.Concurso;
import io.github.fabinhocouto.domain.repository.ConcursoRepository;
import io.github.fabinhocouto.rest.dto.ConcursoDTO;
import io.github.fabinhocouto.service.ConcursoService;
import jdk.internal.org.objectweb.asm.Type;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ConcursoServiceImpl implements ConcursoService {

    private final ConcursoRepository concursoRepository;

    @Override
    @Transactional
    public Concurso salvar(ConcursoDTO concursoDTO) {

        Concurso concurso = new Concurso();
        concurso.setDataConcurso(concursoDTO.getDataConcurso());
        concurso.setTipoConcurso(concursoDTO.getTipoConcurso());
        concurso.setResultado(concursoDTO.getResultado());

        return concursoRepository.save(concurso);

    }

    @Override
    @Transactional
    public void deletar(Integer id) {

        concursoRepository
                .findById(id)
                .map(concurso -> {
                    concursoRepository.delete(concurso);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Concurso não encontrado."));
    }

    @Override
    @Transactional
    public void atualizar(Integer id, ConcursoDTO concursoDTO) {

        concursoRepository
                .findById(id)
                .map(concurso -> {
                    concurso.setDataConcurso(concursoDTO.getDataConcurso());
                    concurso.setTipoConcurso(concursoDTO.getTipoConcurso());
                    concurso.setResultado(concursoDTO.getResultado());
                    concursoRepository.save(concurso);
                    return Type.VOID;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Concurso não encontrado."));

    }
}
