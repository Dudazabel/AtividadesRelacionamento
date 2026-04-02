package com.weg.ClientePedido.controller;

import com.weg.ClientePedido.dto.cliente.ClienteRequisicaoDTO;
import com.weg.ClientePedido.dto.cliente.ClienteRespostaDTO;
import com.weg.ClientePedido.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;

    @PostMapping
    public ClienteRespostaDTO cadastrarCliente(@Valid @RequestBody ClienteRequisicaoDTO cliente){
        return service.cadastrarCliente(cliente);
    }

    @GetMapping
    public List<ClienteRespostaDTO> listarClientes(){
        return service.listarClientes();
    }

    @GetMapping("/{id}")
    public ClienteRespostaDTO buscarClientePorId(@Valid @PathVariable Long id){
        return service.buscarClientePorId(id);
    }

    @GetMapping("/{id}/{nome}")
    public ClienteRespostaDTO buscarClientePorIdENome(@Valid @PathVariable Long id, @PathVariable String nome){
        return service.buscarClientePorIdENome(id, nome);
    }

    @PutMapping("/{id}")
    public ClienteRespostaDTO atualizarCliente(@Valid @PathVariable Long id, @RequestBody ClienteRequisicaoDTO cliente){
        return service.atualizarCliente(id, cliente);
    }

    @DeleteMapping("/{id}")
    public void deletarCliente(@Valid @PathVariable Long id){
        service.deletarCliente(id);
    }
}
