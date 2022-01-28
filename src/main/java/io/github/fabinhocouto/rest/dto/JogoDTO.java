package io.github.fabinhocouto.rest.dto;

import io.github.fabinhocouto.domain.enums.StatusJogo;
import io.github.fabinhocouto.domain.enums.TipoConcurso;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JogoDTO {

    @NotNull(message = "{campo.numeromaximoaposta.obrigatorio}")
    private Integer numeroMaximoAposta;

    @NotNull(message = "{campo.status.jogo.obrigatorio}")
    private StatusJogo statusJogo;

    @NotNull(message = "{campo.datainicio.jogo.obrigatorio}")
    private LocalDate dataInicio;

    @NotNull(message = "{campo.valoraposta.jogo.obrigatorio}")
    private BigDecimal valorAposta;

    private LocalDate dataTermino;
}
