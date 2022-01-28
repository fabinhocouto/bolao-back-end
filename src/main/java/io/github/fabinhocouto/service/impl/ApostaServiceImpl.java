package io.github.fabinhocouto.service.impl;

import io.github.fabinhocouto.domain.entity.Aposta;
import io.github.fabinhocouto.domain.entity.Jogo;
import io.github.fabinhocouto.domain.entity.Usuario;
import io.github.fabinhocouto.domain.enums.StatusAposta;
import io.github.fabinhocouto.domain.repository.ApostaRepository;
import io.github.fabinhocouto.domain.repository.JogoRepository;
import io.github.fabinhocouto.domain.repository.UsuarioRepository;
import io.github.fabinhocouto.exception.RegraNegocioException;
import io.github.fabinhocouto.rest.dto.ApostaDTO;
import io.github.fabinhocouto.service.ApostaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
public class ApostaServiceImpl implements ApostaService {

    private final ApostaRepository apostaRepository;
    private final UsuarioRepository usuarioRepository;
    private final JogoRepository jogoRepository;

    @Override
    @Transactional
    public Aposta salvar(ApostaDTO apostaDTO) {

        Usuario usuario = usuarioRepository
                .findById(apostaDTO.getUsuario())
                .orElseThrow(() -> new RegraNegocioException("Código de Usuário inválido."));

        Jogo jogo = jogoRepository
                .findById(apostaDTO.getJogo())
                .orElseThrow(() -> new RegraNegocioException("Código de Jogo inválido."));

        Aposta aposta = new Aposta();
        aposta.setUsuario(usuario);
        aposta.setJogo(jogo);
        aposta.setDataAposta(LocalDate.now());
        aposta.setStatusAposta(StatusAposta.AGUARDANDO_CONFIRMACAO_PAGAMENTO);
        aposta.setNumeros(apostaDTO.getNumeros());

        return apostaRepository.save(aposta);

    }

    
}
