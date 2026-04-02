package com.weg.ClientePedido.service;

import com.weg.ClientePedido.dto.pedido.PedidoRequisicaoDTO;
import com.weg.ClientePedido.dto.pedido.PedidoRespostaDTO;
import com.weg.ClientePedido.mapper.PedidoMapper;
import com.weg.ClientePedido.model.Pedido;
import com.weg.ClientePedido.repository.ClienteRepository;
import com.weg.ClientePedido.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoMapper mapper;
    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;

    public PedidoRespostaDTO cadastrarPedido(PedidoRequisicaoDTO pedido){
        clienteRepository.findById(pedido.idCliente())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));
        Pedido pedidoSalvo = mapper.DTOParaEntidade(pedido);
        return mapper.EntidadeParaDTO(pedidoRepository.save(pedidoSalvo));
    }

    public List<PedidoRespostaDTO> listarPedidos(){
        return mapper.EntidadeParaDTOList(pedidoRepository.findAll());
    }

    public PedidoRespostaDTO buscarPedidoPorId(Long id){
        return mapper.EntidadeParaDTO(pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado!")));
    }

    public PedidoRespostaDTO buscarPedidoPorIdEDescricao(Long id, String descricao){
        return mapper.EntidadeParaDTO(pedidoRepository.findByIdAndDescricao(id, descricao)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado!")));
    }

    public List<PedidoRespostaDTO> buscarPedidoPeloIdDoCliente(Long id){
        return mapper.EntidadeParaDTOList(pedidoRepository.findByClienteIdOrderByIdAsc(id));
    }

    public List<PedidoRespostaDTO> buscarPedidoPeloNomeDoCliente(String nome){
        return mapper.EntidadeParaDTOList(pedidoRepository.findByClienteNomeOrderByIdAsc(nome));
    }

    public PedidoRespostaDTO atualizarPedido(Long id, PedidoRequisicaoDTO pedido){
        Pedido pedidoSalvo = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado!"));
        pedidoSalvo.setNome(pedido.nome());
        pedidoSalvo.setDescricao(pedido.descricao());
        pedidoSalvo.setCliente(clienteRepository.findById(pedido.idCliente())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado!")));
        return mapper.EntidadeParaDTO(pedidoRepository.save(pedidoSalvo));
    }

    public void deletarPedido(Long id){
        pedidoRepository.deleteById(id);
    }
}
