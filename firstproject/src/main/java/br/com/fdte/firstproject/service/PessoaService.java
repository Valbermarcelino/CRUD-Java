package br.com.fdte.firstproject.service;

import br.com.fdte.firstproject.model.Pessoa;
import br.com.fdte.firstproject.model.Telefone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    @Autowired
    private JpaRepository<Pessoa, Long> repository;

    public Pessoa save(Pessoa entity) {
        return repository.save(entity);
    }

    public List<Pessoa> listar(){
        return repository.findAll();
    }

    public Optional<Pessoa> busca(long entity){
        return repository.findById(entity);
    }

    public Optional<Pessoa> deletar(long entity){
        repository.deleteById(entity);
        return null;
    }

    public void teste() {
//        repository.
    }
}
