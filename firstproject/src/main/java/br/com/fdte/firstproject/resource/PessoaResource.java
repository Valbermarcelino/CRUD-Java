package br.com.fdte.firstproject.resource;

import br.com.fdte.firstproject.model.Pessoa;
import br.com.fdte.firstproject.service.PessoaService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pessoa")
@CrossOrigin(origins = "*")
public class PessoaResource {
    @Autowired
    private PessoaService pessoaService;

    protected final Logger logger = Logger.getLogger(PessoaResource.class);

    @PostMapping
    public ResponseEntity saveOrUpdatePessoa(@RequestBody Pessoa pessoa) {
        try {
            logger.info("Iniciar cadastro pessoa " + pessoa.getEmail());
            return ResponseEntity.ok(pessoaService.save(pessoa));
        } catch (Exception pe) {
            return ResponseEntity.badRequest().body(pe.getMessage());
        }
    }

    @GetMapping("")
    public ResponseEntity listAll() {
        try {
            //logger.info("Iniciar cadastro de telefone " + telefone.getDDD());
            return  ResponseEntity.ok(pessoaService.listar());
        } catch (Exception pe) {
            return ResponseEntity.badRequest().body(pe.getMessage());
        }
    }


    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable long id){
        return pessoaService.busca(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    //@GetMapping("busca")
    //public ResponseEntity search(@RequestParam (required = false) String nome, @RequestParam (required = false) String email){
//        return pessoaService.busca(1L) busca jpa repository
//                .map(record -> ResponseEntity.ok().body(record))
//                .orElse(ResponseEntity.notFound().build());
    //}

    @PutMapping(value="/{id}")
    public ResponseEntity update(@PathVariable("id") long id,
                                 @RequestBody Pessoa pessoa) {
        return pessoaService.busca(id)
                .map(record -> {
                    record.setNome(pessoa.getNome());
                    record.setEmail(pessoa.getEmail());
                    Pessoa updated = pessoaService.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> delete(@PathVariable long id) {
        return pessoaService.busca(id)
                .map(record -> {
                    pessoaService.deletar(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
