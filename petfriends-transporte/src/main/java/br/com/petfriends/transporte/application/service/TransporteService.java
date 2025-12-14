package br.com.petfriends.transporte.application.service;

import br.com.petfriends.transporte.domain.model.aggregate.Transporte;
import br.com.petfriends.transporte.domain.repository.TransporteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransporteService {

    private final TransporteRepository repository;

    public Transporte criarTransporte(UUID pedidoId) {
        Transporte transporte = new Transporte(pedidoId);
        return repository.save(transporte);
    }

    public List<Transporte> listarTodos() {
        return repository.findAll();
    }
}
