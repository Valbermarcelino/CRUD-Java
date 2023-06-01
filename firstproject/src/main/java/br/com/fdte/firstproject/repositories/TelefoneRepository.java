package br.com.fdte.firstproject.repositories;

import br.com.fdte.firstproject.model.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {

}
