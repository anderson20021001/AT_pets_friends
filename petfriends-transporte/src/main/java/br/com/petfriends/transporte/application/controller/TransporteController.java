package br.com.petfriends.transporte.application.controller;

import br.com.petfriends.transporte.application.service.TransporteService;
import br.com.petfriends.transporte.domain.model.aggregate.Transporte;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transportes")
@RequiredArgsConstructor
public class TransporteController {

    private final TransporteService service;

    @GetMapping
    public List<Transporte> listarTodos() {
        return service.listarTodos();
    }
}
