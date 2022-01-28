package io.github.fabinhocouto.rest.dto;

import io.github.fabinhocouto.domain.enums.StatusJogo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InformacaoJogoDTO {

    private Integer codigo;

    private Integer numeroMaximoAposta;

    private String statusJogo;

    private String dataInicio;

    private BigDecimal valorAposta;

    private String dataTermino;

    private List<InformacaoApostaDTO> apostas;
}
