package io.github.fabinhocouto.domain.entity;

import io.github.fabinhocouto.domain.enums.StatusJogo;
import io.github.fabinhocouto.domain.enums.TipoConcurso;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name="numero_maximo_aposta")
    private Integer numeroMaximoAposta;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_jogo")
    private StatusJogo statusJogo;

    @Column(name="data_inicio")
    private LocalDate dataInicio;

    @Column(name="data_termino")
    private LocalDate dataTermino;

    @Column(name = "valor_aposta", precision = 20, scale = 2)
    private BigDecimal valorAposta;

    @OneToMany(mappedBy = "jogo")
    private List<Aposta> apostas;
}
