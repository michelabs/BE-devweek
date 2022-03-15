package com.dio.devweek.controller;

import com.dio.devweek.entities.Regiao;
import com.dio.devweek.repository.RegiaoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ControllerRegiao {

    private final RegiaoRepository repository;

    public ControllerRegiao(RegiaoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/regioes")
    public ResponseEntity<?> findAllRegioes(){
        try {
            List<Regiao> allRegioes = repository.findAll();
            System.out.println("Achou");
            if (allRegioes.isEmpty())
                System.out.println("Vazia");
                return new ResponseEntity<>(allRegioes, HttpStatus.OK);
         }catch (Exception e){
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        }

    @GetMapping("/regioes/{id}")
    public ResponseEntity<Regiao> findRegiaoById(@PathVariable Long id){
        Optional<Regiao> regiaoEscolhidaOptional = repository.findById(id);
        if(regiaoEscolhidaOptional.isPresent()){
            Regiao regiaoEscolhida =  regiaoEscolhidaOptional.get();
            return new ResponseEntity<>(regiaoEscolhida, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/regioes/novo")
    public void putRegiao(Regiao newRegiao){
        repository.save(newRegiao);
    }

    @DeleteMapping("/regioes/delete/{id}")
    public void deleteRegiao(@PathVariable Long id){
        repository.deleteById(id);
    }
}
