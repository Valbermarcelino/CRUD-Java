package br.com.fdte.firstproject.service;

import br.com.fdte.firstproject.model.Telefone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TelefoneService {
    @Autowired
    private JpaRepository<Telefone, Long> repository;

    public Telefone save(Telefone entity) {
        return repository.save(entity);
    }

    public List<Telefone> listar(){
        return repository.findAll();
    }

    public Optional<Telefone> busca(long entity){
        return repository.findById(entity);
    }

    public Optional<Telefone> deletar(long entity){
        repository.deleteById(entity);
        return null;
    }

    /*public  Telefone deletar(Telefone entity){
        return repository.delete(entity);
    }

    public Telefone deletarTodos(){
        repository.deleteAll();
        return null;
    }

    */
}
