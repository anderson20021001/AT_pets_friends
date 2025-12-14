package br.com.petfriends.transporte.application.listener;

import br.com.petfriends.transporte.application.service.TransporteService;
import br.com.petfriends.transporte.domain.model.event.PedidoCriadoEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PedidoCriadoListener {

    private final TransporteService transporteService;

    @RabbitListener(queues = "pedido-criado")
    public void consumir(PedidoCriadoEvent event) {
        transporteService.criarTransporte(event.pedidoId());
    }
}
