package com.votacao.cadastros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class CadastroController {
    @Autowired
    private EleitorRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Eleitor cadastrar(@RequestBody Eleitor eleitor){
        return repository.save(eleitor);
    }

    @GetMapping
    public Iterable<Eleitor> listar(){
        return repository.findAll();
    }
}
