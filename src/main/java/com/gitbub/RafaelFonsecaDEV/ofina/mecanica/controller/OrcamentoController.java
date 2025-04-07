package com.gitbub.RafaelFonsecaDEV.ofina.mecanica.controller;

import com.gitbub.RafaelFonsecaDEV.ofina.mecanica.Entidade.Orcamento;
import com.gitbub.RafaelFonsecaDEV.ofina.mecanica.Repository.Repositor;
import com.gitbub.RafaelFonsecaDEV.ofina.mecanica.controller.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller responsável pelo CRUD de orçamentos.
 */

@RestController
@RequestMapping("/api/orcamentos")
public class OrcamentoController {

    @Autowired
    private Repositor.OrcamentoRepository repository;
    /**
     * Lista todos os orçamentos em ordem decrescente pela data.*/
    @GetMapping
    public List<Orcamento> listarTodos() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "dataHora"));
    }

    @PostMapping
    public Orcamento criar(@RequestBody @Valid Orcamento orcamento) {
        return repository.save(orcamento);
    }

   /**
     * Atualiza um orçamento existente.*/
     * @param id identificador do orçamento
     * @param orcamento dados atualizados
     * @return orçamento atualizado ou 404 se não encontrado
     

    
    @PutMapping("/{id}")
    public ResponseEntity<Orcamento> atualizar(@PathVariable Long id, @RequestBody @Valid Orcamento orcamento) {
        return repository.findById(id)
                .map(o -> {
                    orcamento.setId(id);
                    return ResponseEntity.ok(repository.save(orcamento));
                }).orElse(ResponseEntity.notFound().build());
    }

       /**
     * Remove um orçamento pelo ID.*/
     * @param id identificador do orçamento
     * @return 200 OK se removido ou 404 se não encontrado
     

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
