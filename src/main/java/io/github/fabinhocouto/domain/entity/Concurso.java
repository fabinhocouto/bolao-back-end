package io.github.fabinhocouto.domain.entity;

import io.github.fabinhocouto.domain.enums.TipoConcurso;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Concurso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "data_concurso")
    private LocalDate dataConcurso;

    @Column(name = "resultado")
    private String resultado;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_concurso")
    private TipoConcurso tipoConcurso;
}
