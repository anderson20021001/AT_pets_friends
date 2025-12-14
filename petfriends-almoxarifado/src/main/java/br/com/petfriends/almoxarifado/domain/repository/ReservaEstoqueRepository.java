package br.com.petfriends.almoxarifado.domain.repository;

import br.com.petfriends.almoxarifado.domain.model.aggregate.ReservaEstoque;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ReservaEstoqueRepository
        extends JpaRepository<ReservaEstoque, UUID> {

    Optional<ReservaEstoque> findByPedidoId(UUID pedidoId);
}
