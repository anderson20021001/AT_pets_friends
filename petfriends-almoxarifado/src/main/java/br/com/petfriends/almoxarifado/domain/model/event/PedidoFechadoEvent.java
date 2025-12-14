package br.com.petfriends.almoxarifado.domain.model.event;

import java.util.UUID;

public class PedidoFechadoEvent {

    private UUID pedidoId;
    private int quantidadeItens;

    public UUID getPedidoId() {
        return pedidoId;
    }

    public int getQuantidadeItens() {
        return quantidadeItens;
    }
}
