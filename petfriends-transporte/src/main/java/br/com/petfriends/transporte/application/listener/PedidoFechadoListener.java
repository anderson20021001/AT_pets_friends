package br.com.petfriends.transporte.application.listener;

import br.com.petfriends.transporte.domain.model.event.PedidoFechadoEvent;
import br.com.petfriends.transporte.domain.repository.TransporteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PedidoFechadoListener {

    private final TransporteRepository repository;

    @RabbitListener(queues = "pedido.fechado")
    public void consumir(PedidoFechadoEvent event) {
        repository.findAll().stream()
                .filter(t -> t.getPedidoId().equals(event.pedidoId()))
                .findFirst()
                .ifPresent(t -> {
                    t.marcarComoEntregue();
                    repository.save(t);
                });
    }
}
