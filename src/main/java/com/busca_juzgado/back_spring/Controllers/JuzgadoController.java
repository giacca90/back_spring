package com.busca_juzgado.back_spring.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.busca_juzgado.back_spring.Models.Juzgado;
import com.busca_juzgado.back_spring.Services.JuzgadoService;

@RestController
@RequestMapping("juzgados")
@CrossOrigin(origins = "http://localhost:4200")
public class JuzgadoController {

    @Autowired
    private JuzgadoService service;

    @GetMapping()
    public ResponseEntity<?> getAllJuzgados() {
        try {
            return new ResponseEntity<List<Juzgado>>(this.service.getAllJuzgados(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/custom")
    public ResponseEntity<?> getCustomJuzgado(@RequestBody Juzgado juzgado) {
        try {
            return new ResponseEntity<List<Juzgado>>(this.service.getCustomJuzgado(juzgado), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/nombre")
    public ResponseEntity<?> getJuzgadoForNombre(@RequestBody String nombre) {
        try {
            return new ResponseEntity<List<Juzgado>>(this.service.getJuzgadoForNombre(nombre), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/pueblo")
    public ResponseEntity<?> getJuzgadoForPueblo(@RequestBody String nombre) {
        try {
            return new ResponseEntity<List<Juzgado>>(this.service.getJuzgadoForPueblo(nombre), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/provincia")
    public ResponseEntity<?> getJuzgadoForProvincia(@RequestBody String nombre) {
        try {
            return new ResponseEntity<List<Juzgado>>(this.service.getJuzgadoForProvincia(nombre), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/comunidad")
    public ResponseEntity<?> getJuzgadoForComunidad(@RequestBody String nombre) {
        try {
            return new ResponseEntity<List<Juzgado>>(this.service.getJuzgadoForComunidad(nombre), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}