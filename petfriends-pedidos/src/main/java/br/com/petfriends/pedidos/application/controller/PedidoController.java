package br.com.petfriends.pedidos.application.controller;

import br.com.petfriends.pedidos.application.service.PedidoService;
import br.com.petfriends.pedidos.domain.model.aggregate.Pedido;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido criarPedido() {
        return pedidoService.criarPedido();
    }
}
