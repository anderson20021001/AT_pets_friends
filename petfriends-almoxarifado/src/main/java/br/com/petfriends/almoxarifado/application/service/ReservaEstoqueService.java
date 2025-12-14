package br.com.petfriends.almoxarifado.application.service;

import br.com.petfriends.almoxarifado.domain.model.aggregate.ReservaEstoque;
import br.com.petfriends.almoxarifado.domain.model.valueobject.Quantidade;
import br.com.petfriends.almoxarifado.domain.repository.ReservaEstoqueRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ReservaEstoqueService {

    private final ReservaEstoqueRepository repository;

    public ReservaEstoqueService(ReservaEstoqueRepository repository) {
        this.repository = repository;
    }

    public void reservar(UUID pedidoId, int quantidadeItens) {
        ReservaEstoque reserva = new ReservaEstoque(
                pedidoId,
                new Quantidade(quantidadeItens)
        );
        repository.save(reserva);
    }
}
