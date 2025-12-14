@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE = "pedido.exchange";
    public static final String QUEUE = "pedido-criado";
    public static final String ROUTING_KEY = "pedido.criado";

    @Bean
    public TopicExchange pedidoExchange() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Queue pedidoCriadoQueue() {
        return new Queue(QUEUE, true);
    }

    @Bean
    public Binding bindingPedidoCriado() {
        return BindingBuilder
                .bind(pedidoCriadoQueue())
                .to(pedidoExchange())
                .with(ROUTING_KEY);
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
