package com.weg.ClientePedido.controller;

import com.weg.ClientePedido.dto.pedido.PedidoRequisicaoDTO;
import com.weg.ClientePedido.dto.pedido.PedidoRespostaDTO;
import com.weg.ClientePedido.model.Pedido;
import com.weg.ClientePedido.service.PedidoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService service;

    @PostMapping
    public ResponseEntity<PedidoRespostaDTO> cadastrarPedido(@Valid @RequestBody PedidoRequisicaoDTO pedido){
        PedidoRespostaDTO pedidoSalvo = service.cadastrarPedido(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoSalvo);
    }

    @GetMapping
    public ResponseEntity<List<PedidoRespostaDTO>> listarPedido(){
        return ResponseEntity.ok(service.listarPedidos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoRespostaDTO> buscarPedidoPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPedidoPorId(id));
    }

    @GetMapping("/{id}/{descricao}")
    public ResponseEntity<PedidoRespostaDTO> buscarPedidoPorIdEDescricao(@PathVariable Long id, @PathVariable String descricao){
        return ResponseEntity.ok(service.buscarPedidoPorIdEDescricao(id, descricao));
    }

    @GetMapping("/clienteId/{id}")
    public ResponseEntity<List<PedidoRespostaDTO>> buscarPedidoPeloIdDoCliente(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPedidoPeloIdDoCliente(id));
    }

    @GetMapping("/clienteNome/{nome}")
    public ResponseEntity<List<PedidoRespostaDTO>> buscarPedidoPeloNomeCliente(@PathVariable String nome){
        return ResponseEntity.ok(service.buscarPedidoPeloNomeDoCliente(nome));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoRespostaDTO> atualizarPedidoPeloNome(@Valid @PathVariable Long id, @RequestBody PedidoRequisicaoDTO pedido){
        return ResponseEntity.ok(service.atualizarPedido(id, pedido));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPedido(@PathVariable Long id){
        service.deletarPedido(id);
        return ResponseEntity.noContent().build();
    }
}
