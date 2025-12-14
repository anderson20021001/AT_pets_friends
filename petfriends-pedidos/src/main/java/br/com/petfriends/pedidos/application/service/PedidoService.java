package br.com.petfriends.pedidos.application.service;

import br.com.petfriends.pedidos.domain.model.aggregate.Pedido;
import br.com.petfriends.pedidos.domain.model.event.PedidoCriadoEvent;
import br.com.petfriends.pedidos.domain.repository.PedidoRepository;
import br.com.petfriends.pedidos.infrastructure.messaging.RabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final RabbitTemplate rabbitTemplate;

    public PedidoService(PedidoRepository pedidoRepository,
                         RabbitTemplate rabbitTemplate) {
        this.pedidoRepository = pedidoRepository;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Transactional
    public Pedido criarPedido() {
        Pedido pedido = Pedido.criar();
        pedidoRepository.save(pedido);

        PedidoCriadoEvent event = new PedidoCriadoEvent(pedido.getId());

        rabbitTemplate.convertAndSend(
                RabbitConfig.EXCHANGE_PEDIDOS,
                RabbitConfig.ROUTING_KEY_PEDIDO_CRIADO,
                event
        );

        return pedido;
    }
}
