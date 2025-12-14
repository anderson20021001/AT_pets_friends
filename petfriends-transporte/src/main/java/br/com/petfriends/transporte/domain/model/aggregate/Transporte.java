package br.com.petfriends.transporte.domain.model.aggregate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
public class Transporte {

    @Id
    private UUID id;

    private UUID pedidoId;

    private String status;

    public Transporte(UUID pedidoId) {
        this.id = UUID.randomUUID();
        this.pedidoId = pedidoId;
        this.status = "CRIADO";
    }

    public void marcarComoEntregue() {
        this.status = "ENTREGUE";
    }
}
