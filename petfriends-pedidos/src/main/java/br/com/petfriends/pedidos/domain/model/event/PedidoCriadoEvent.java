package br.com.petfriends.pedidos.domain.model.event;

import java.io.Serializable;
import java.util.UUID;

public record PedidoCriadoEvent(UUID pedidoId) implements Serializable {
}
