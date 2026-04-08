package com.weg.ClientePedido.controller;

import com.weg.ClientePedido.dto.cliente.ClienteRequisicaoDTO;
import com.weg.ClientePedido.dto.cliente.ClienteRespostaDTO;
import com.weg.ClientePedido.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;

    @PostMapping
    public ResponseEntity<ClienteRespostaDTO> cadastrarCliente(@Valid @RequestBody ClienteRequisicaoDTO cliente){
        ClienteRespostaDTO clienteSalvo = service.cadastrarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
    }

    @GetMapping
    public ResponseEntity<List<ClienteRespostaDTO>> listarClientes(){
        return ResponseEntity.ok(service.listarClientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteRespostaDTO> buscarClientePorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarClientePorId(id));
    }

    @GetMapping("/{id}/{nome}")
    public ResponseEntity<ClienteRespostaDTO> buscarClientePorIdENome(@PathVariable Long id, @PathVariable String nome){
        return ResponseEntity.ok(service.buscarClientePorIdENome(id, nome));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteRespostaDTO> atualizarCliente(@Valid @PathVariable Long id, @RequestBody ClienteRequisicaoDTO cliente){
        return ResponseEntity.ok(service.atualizarCliente(id, cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id){
        service.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }
}
