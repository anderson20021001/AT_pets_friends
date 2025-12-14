package br.com.petfriends.almoxarifado.application.listener;

import br.com.petfriends.almoxarifado.application.service.ReservaEstoqueService;
import br.com.petfriends.almoxarifado.domain.model.event.PedidoFechadoEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class PedidoFechadoEventListener {

    private final ReservaEstoqueService service;

    public PedidoFechadoEventListener(ReservaEstoqueService service) {
        this.service = service;
    }

    @RabbitListener(queues = "pedido.fechado")
    public void receberEvento(PedidoFechadoEvent event) {
        service.reservar(
                event.getPedidoId(),
                event.getQuantidadeItens()
        );
    }
}
