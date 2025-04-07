package com.gitbub.RafaelFonsecaDEV.ofina.mecanica.Service;

import com.gitbub.RafaelFonsecaDEV.ofina.mecanica.Entidade.Orcamento;
import com.gitbub.RafaelFonsecaDEV.ofina.mecanica.Repository.Repositor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class Servicos {

    @Service
    public class OrcamentoService {
        @Autowired
        private Repositor.OrcamentoRepository repository;

        public Orcamento salvar(Orcamento orcamento) {
            return repository.save(orcamento);
        }

        public List<Orcamento> listarTodos() {
            return repository.findAll(Sort.by(Sort.Direction.DESC, "dataHora"));
        }

        public void deletar(Long id) {
            repository.deleteById(id);
        }

        public Optional<Orcamento> buscarPorId(Long id) {
            return repository.findById(id);
        }

        public List<Orcamento> filtrar() {
            // implementar lógica de filtro usando o método do repositório
            return List.of();
        }
    }


}
