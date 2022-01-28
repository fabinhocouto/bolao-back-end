package io.github.fabinhocouto.rest.dto;

import io.github.fabinhocouto.domain.enums.TipoConcurso;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtualizacaoNovoStatusApostaDTO {

    private String novoStatusAposta;
}
