package br.com.petfriends.almoxarifado.domain.model.aggregate;

import br.com.petfriends.almoxarifado.domain.model.enums.StatusReserva;
import br.com.petfriends.almoxarifado.domain.model.valueobject.Quantidade;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "reserva_estoque")
public class ReservaEstoque {

    @Id
    private UUID id;

    @Column(nullable = false)
    private UUID pedidoId;

    @Embedded
    private Quantidade quantidade;

    @Enumerated(EnumType.STRING)
    private StatusReserva status;

    protected ReservaEstoque() {
    }

    public ReservaEstoque(UUID pedidoId, Quantidade quantidade) {
        this.id = UUID.randomUUID();
        this.pedidoId = pedidoId;
        this.quantidade = quantidade;
        this.status = StatusReserva.RESERVADO;
    }

    public UUID getId() {
        return id;
    }

    public UUID getPedidoId() {
        return pedidoId;
    }

    public Quantidade getQuantidade() {
        return quantidade;
    }

    public StatusReserva getStatus() {
        return status;
    }

    public void cancelar() {
        this.status = StatusReserva.CANCELADO;
    }
}
