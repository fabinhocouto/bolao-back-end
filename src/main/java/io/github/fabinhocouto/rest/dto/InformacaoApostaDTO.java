package io.github.fabinhocouto.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InformacaoApostaDTO {

    private String nomeUsuario;

    private String numeros;
}
