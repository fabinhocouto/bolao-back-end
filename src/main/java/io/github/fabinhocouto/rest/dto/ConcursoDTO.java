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
public class ConcursoDTO {

    @NotNull(message = "{campo.data.concurso.obrigatorio}")
    private LocalDate dataConcurso;

    @NotNull(message = "{campo.resultado.concurso.obrigatorio}")
    private String resultado;

    @NotNull(message = "{campo.tipo.concurso.obrigatorio}")
    private TipoConcurso tipoConcurso;
}
