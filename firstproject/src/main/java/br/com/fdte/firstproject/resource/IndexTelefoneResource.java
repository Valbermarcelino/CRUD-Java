package br.com.fdte.firstproject.resource;

import br.com.fdte.firstproject.model.Telefone;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tel")
@CrossOrigin(origins = "*")
public class IndexTelefoneResource {
    @GetMapping("/find")
    public ResponseEntity find() {
        Telefone telefone = new Telefone();
        telefone.setDDD("12");
        telefone.setNumero("999999999");
        return ResponseEntity.ok(telefone);
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
