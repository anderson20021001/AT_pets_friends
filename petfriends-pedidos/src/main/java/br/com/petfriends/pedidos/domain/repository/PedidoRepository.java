package br.com.petfriends.pedidos.domain.repository;

import br.com.petfriends.pedidos.domain.model.aggregate.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PedidoRepository extends JpaRepository<Pedido, UUID> {
}
