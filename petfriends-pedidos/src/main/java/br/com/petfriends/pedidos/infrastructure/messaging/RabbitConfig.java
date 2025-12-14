package br.com.petfriends.pedidos.infrastructure.messaging;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String EXCHANGE_PEDIDOS = "pedido.exchange";
    public static final String ROUTING_KEY_PEDIDO_CRIADO = "pedido.criado";

    @Bean
    public TopicExchange pedidoExchange() {
        return new TopicExchange(EXCHANGE_PEDIDOS);
    }
}
