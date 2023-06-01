package br.com.fdte.firstproject.resource;

import br.com.fdte.firstproject.model.Telefone;
import br.com.fdte.firstproject.service.TelefoneService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("telefone")
@CrossOrigin(origins = "*")//* para qualquer um que quiser usar; se fosse no site seria uma url(lalala.alguma.coisa) do site
public class TelefoneResource {
    @Autowired
    private TelefoneService telefoneService;

    protected final Logger logger = Logger.getLogger(TelefoneResource.class);

    @PostMapping
    public ResponseEntity saveOrUpdateTelefone(@RequestBody Telefone telefone) {
        try {
            logger.info("Iniciar cadastro de telefone " + telefone.getNumero());
            return ResponseEntity.ok(telefoneService.save(telefone));
        } catch (Exception pe) {
            return ResponseEntity.badRequest().body(pe.getMessage());
        }
    }


    @GetMapping("")
    public ResponseEntity listAll() {
        try {
            //logger.info("Iniciar cadastro de telefone " + telefone.getDDD());
            return  ResponseEntity.ok(telefoneService.listar());
        } catch (Exception pe) {
            return ResponseEntity.badRequest().body(pe.getMessage());
        }
    }


    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable long id){
        return telefoneService.busca(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(value="/{id}")
    public ResponseEntity update(@PathVariable("id") long id,
                                 @RequestBody Telefone telefone) {
        return telefoneService.busca(id)
                .map(record -> {
                    record.setDDD(telefone.getDDD());
                    record.setNumero(telefone.getNumero());
                    Telefone updated = telefoneService.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> delete(@PathVariable long id) {
        return telefoneService.busca(id)
                .map(record -> {
                    telefoneService.deletar(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    /*

    @DeleteMapping("{idTel}")
    public @ResponseBody ResponseEntity<String> delete(@PathVariable Long idTel) {
        return new ResponseEntity<String>("DELETE Response", HttpStatus.OK);
    }

    @PatchMapping

    @PutMapping("/put")
    public @ResponseBody ResponseEntity<String> put() {
        return new ResponseEntity<String>("PUT Response", HttpStatus.OK);
    }

     }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));

    @DeleteMapping("/deletartodos")
    public ResponseEntity deleteAll() {
        try {
            telefoneService.deletarTodos();
            //logger.info("foram deletados: ");
            return  ResponseEntity.ok("DELETOU");
        } catch (Exception pe) {
            return ResponseEntity.badRequest().body(pe.getMessage());
        }
    }

    https://www.baeldung.com/learn-spring-course

    https://www.devmedia.com.br/hibernate-mapping-mapeando-relacionamentos-entre-entidades/29445

    http://www.universidadejava.com.br/materiais/jpa-manytoone/

    https://www.youtube.com/watch?v=O03ialWcZJc - não olhei

    https://www.caelum.com.br/apostila-java-web/spring-mvc/

    instalar:
    https://www.digitalocean.com/community/tutorials/como-instalar-o-java-no-ubuntu-com-apt-get-pt
    http://postgresguide.com/setup/install.html

    @GetMapping("/get/{id}")
    public @ResponseBody ResponseEntity<String>
      getById(@PathVariable String id) {
        return new ResponseEntity<String>("GET Response : "
          + id, HttpStatus.OK);
    }*/
}
