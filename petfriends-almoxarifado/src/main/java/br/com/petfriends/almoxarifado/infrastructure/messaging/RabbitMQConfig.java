package br.com.petfriends.almoxarifado.infrastructure.messaging;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue pedidoFechadoQueue() {
        return new Queue("pedido.fechado", true);
    }
}
