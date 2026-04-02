package com.weg.ClientePedido.controller;

import com.weg.ClientePedido.dto.pedido.PedidoRequisicaoDTO;
import com.weg.ClientePedido.dto.pedido.PedidoRespostaDTO;
import com.weg.ClientePedido.model.Pedido;
import com.weg.ClientePedido.service.PedidoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService service;

    @PostMapping
    public PedidoRespostaDTO cadastrarPedido(@Valid @RequestBody PedidoRequisicaoDTO pedido){
        return service.cadastrarPedido(pedido);
    }

    @GetMapping
    public List<PedidoRespostaDTO> listarPedido(){
        return service.listarPedidos();
    }

    @GetMapping("/{id}")
    public PedidoRespostaDTO buscarPedidoPorId(@Valid @PathVariable Long id){
        return service.buscarPedidoPorId(id);
    }

    @GetMapping("/{id}/{descricao}")
    public PedidoRespostaDTO buscarPedidoPorIdEDescricao(@Valid @PathVariable Long id, @PathVariable String descricao){
        return service.buscarPedidoPorIdEDescricao(id, descricao);
    }

    @GetMapping("/clienteId/{id}")
    public List<PedidoRespostaDTO> buscarPedidoPeloIdDoCliente(@Valid @PathVariable Long id){
        return service.buscarPedidoPeloIdDoCliente(id);
    }

    @GetMapping("/clienteNome/{nome}")
    public List<PedidoRespostaDTO> buscarPedidoPeloNomeCliente(@Valid @PathVariable String nome){
        return service.buscarPedidoPeloNomeDoCliente(nome);
    }

    @PutMapping("/{id}")
    public PedidoRespostaDTO atualizarPedidoPeloNome(@Valid @PathVariable Long id, @RequestBody PedidoRequisicaoDTO pedido){
        return service.atualizarPedido(id, pedido);
    }

    @DeleteMapping("/{id}")
    public void deletarPedido(@Valid @PathVariable Long id){
        service.deletarPedido(id);
    }
}
