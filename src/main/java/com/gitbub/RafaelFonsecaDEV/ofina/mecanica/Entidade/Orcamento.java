package com.gitbub.RafaelFonsecaDEV.ofina.mecanica.Entidade;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Orcamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cliente;
    private LocalDateTime dataHora;
    private String vendedor;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    private BigDecimal valor;

    public void setId(Long id) {

    }

    // Getters e Setters


}
