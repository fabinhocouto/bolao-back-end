package io.github.fabinhocouto.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApostaDTO {

    @NotNull(message = "{campo.usuario.aposta.obrigatorio}")
    private Integer usuario;

    @NotNull(message = "{campo.jogo.aposta.obrigatorio}")
    private Integer jogo;

    @NotNull(message = "{campo.numeros.aposta.obrigatorio}")
    private String numeros;
}
