package br.com.fdte.firstproject.resource;
import br.com.fdte.firstproject.model.Pessoa;
import br.com.fdte.firstproject.model.Telefone;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("index")
@CrossOrigin(origins = "*")
public class IndexResource {
    @GetMapping("/find")
    public ResponseEntity find() {
        Pessoa pessoa = new Pessoa();
        pessoa.setEmail("igor.salvati@fdte.io");
        pessoa.setNome("Igor");

        Telefone telefone = new Telefone();
        telefone.setDDD("11");
        telefone.setNumero("12345678");
        //Cria o telefone celular da pessoa.
        Telefone telefone2 = new Telefone();
        telefone2.setDDD("12");
        telefone2.setNumero("87654321;");

        //Cria uma lista de telefones e guarda dentro da pessoa.
        List<Telefone> telefones = new ArrayList<Telefone>();
        telefones.add(telefone);
        telefones.add(telefone2);
        pessoa.setTelefones(telefones);

        return ResponseEntity.ok(pessoa);
    }

    @GetMapping("")
    public ResponseEntity findVazio() {
        return ResponseEntity.ok("Teste vazio");
    }

    @GetMapping("/teste")
    public ResponseEntity teste() {
        return ResponseEntity.ok("Teste");
    }
}
