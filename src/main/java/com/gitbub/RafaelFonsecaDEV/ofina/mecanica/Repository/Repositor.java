package com.gitbub.RafaelFonsecaDEV.ofina.mecanica.Repository;

import com.gitbub.RafaelFonsecaDEV.ofina.mecanica.Entidade.Orcamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

public class Repositor {

    @Repository
    public interface OrcamentoRepository extends JpaRepository<Orcamento, Long> {

        List<Orcamento> findByClienteContainingIgnoreCase(String cliente);

        @Query("SELECT o FROM Orcamento o WHERE " +
                "(:cliente IS NULL OR LOWER(o.cliente) LIKE LOWER(CONCAT('%', :cliente, '%'))) AND " +
                "(:vendedor IS NULL OR LOWER(o.vendedor) LIKE LOWER(CONCAT('%', :vendedor, '%'))) AND " +
                "(:inicio IS NULL OR o.dataHora >= :inicio) AND " +
                "(:fim IS NULL OR o.dataHora <= :fim) " +
                "ORDER BY o.dataHora DESC")
        <Orcamento>
        List<Orcamento> filtrar(
                @Param("cliente") String cliente,
                @Param("vendedor") String vendedor,
                @Param("inicio") LocalDateTime inicio,
                @Param("fim") LocalDateTime fim
        );
    }




}
