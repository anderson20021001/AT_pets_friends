package br.com.petfriends.transporte.domain.model.event;

import java.util.UUID;

public record PedidoCriadoEvent(
        UUID pedidoId
) {
}
