package io.github.fabinhocouto.domain.entity;

import io.github.fabinhocouto.domain.enums.StatusAposta;
import io.github.fabinhocouto.domain.enums.StatusJogo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Aposta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "jogo_id")
    private Jogo jogo;

    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuario usuario;

    @Column(name="numeros")
    private String numeros;

    @Column(name="data_aposta")
    private LocalDate dataAposta;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_aposta")
    private StatusAposta statusAposta;
}
