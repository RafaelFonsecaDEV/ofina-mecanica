package com.gitbub.RafaelFonsecaDEV.ofina.mecanica.Entidade;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Entidade que representa um orçamento da oficina.
 */

@Entity
public class Orcamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /** Nome do cliente que solicitou o orçamento */
    private String cliente;
     /** Data e hora em que o orçamento foi criado */
    private LocalDateTime dataHora;
     /** Nome do vendedor responsável */
    private String vendedor;

    /** Descrição detalhada do orçamento */
    @Column(columnDefinition = "TEXT")
    private String descricao;

    /** Valor orçado para o serviço */
    private BigDecimal valor;

    public void setId(Long id) {

    }

    // Getters e Setters


}
