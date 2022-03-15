package com.dio.devweek.controller;

import com.dio.devweek.entities.FaixaEtaria;
import com.dio.devweek.repository.FaixaEtariaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ControllerFaixaEtaria {

    private final FaixaEtariaRepository fRepository;

    public ControllerFaixaEtaria(FaixaEtariaRepository fRepository) {
        this.fRepository = fRepository;
    }

    @GetMapping("/faixaetaria")
    public ResponseEntity<?> findFaixaEtariaById(){
        try{
            List<FaixaEtaria> listaCompletaFaixaEtaria = fRepository.findAll();
            return new ResponseEntity<>(listaCompletaFaixaEtaria, HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/faixaetaria/{id}")
    public ResponseEntity<FaixaEtaria> findFaixaEtariaById(@PathVariable Long id){
        try{
            Optional<FaixaEtaria> faixaEtariaById = fRepository.findById(id);
            if(faixaEtariaById.isPresent()){
                FaixaEtaria faixaEtariaUnid = faixaEtariaById.get();
                return new ResponseEntity<>(faixaEtariaUnid, HttpStatus.OK);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/faixaetaria/novo")
    public FaixaEtaria novaFaixaEtaria(@RequestBody FaixaEtaria novaFaixaEtaria){
       return fRepository.save(novaFaixaEtaria);
    }

    @DeleteMapping("/faixaetaria/delete/{id}")
    public void deleteFaixaEtaria(@PathVariable Long id){
        fRepository.deleteById(id);
    }

}
