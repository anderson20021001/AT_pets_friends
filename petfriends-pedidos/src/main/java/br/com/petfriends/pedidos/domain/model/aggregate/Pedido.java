package br.com.petfriends.pedidos.domain.model.aggregate;

import br.com.petfriends.pedidos.domain.model.enums.PedidoStatus;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    private UUID id;

    @Enumerated(EnumType.STRING)
    private PedidoStatus status;

    protected Pedido() {
    }

    private Pedido(UUID id, PedidoStatus status) {
        this.id = id;
        this.status = status;
    }

    public static Pedido criar() {
        return new Pedido(UUID.randomUUID(), PedidoStatus.CRIADO);
    }

    public void pagar() {
        this.status = PedidoStatus.PAGO;
    }

    public UUID getId() {
        return id;
    }

    public PedidoStatus getStatus() {
        return status;
    }
}
