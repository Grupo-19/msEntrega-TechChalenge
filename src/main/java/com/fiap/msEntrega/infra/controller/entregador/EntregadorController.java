package com.fiap.msEntrega.infra.controller.entregador;

import com.fiap.msEntrega.app.usecases.entregador.*;
import com.fiap.msEntrega.domain.entrega.Entrega;
import com.fiap.msEntrega.domain.entregador.Entregador;
import com.fiap.msEntrega.infra.controller.entrega.EntregaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/entregador")
@Tag(name = "Entregas", description = "Endpoints para gerenciamento de entregas e entregadores")
public class EntregadorController {

    private final CadastrarEntregador cadastrarEntregador;
    private final EditarEntregador editarEntregador;
    private final ExcluirEntregador excluirEntregador;
    private final ObterTodosEntregadores obterTodosEntregadores;

    public EntregadorController(CadastrarEntregador cadastrarEntregador, EditarEntregador editarEntregador, ExcluirEntregador excluirEntregador, ObterTodosEntregadores obterTodosEntregadores) {
        this.cadastrarEntregador = cadastrarEntregador;
        this.editarEntregador = editarEntregador;
        this.excluirEntregador = excluirEntregador;
        this.obterTodosEntregadores = obterTodosEntregadores;
    }

    @PostMapping
    @Operation(summary = "Cadastrar Entregador", description = "Cadastra um novo entregador.")
    public EntregadorDTO cadastrarEntregador(@RequestBody EntregadorDTO dto) {
        Entregador entregador = cadastrarEntregador.cadastrarEntregador(
                new Entregador(dto.id(),
                        dto.nome(),
                        dto.cpf()));

        return new EntregadorDTO(entregador.getId(),
                entregador.getNome(),
                entregador.getCpf()
        );
    }

    @PutMapping
    @Operation(summary = "Editar Entregador", description = "Edita um entregador existente.")
    public EntregadorDTO editarEntregador(@RequestBody EntregadorDTO dto) {
        Entregador entregador = editarEntregador.editarEntregador(
                new Entregador(dto.id(),
                        dto.nome(),
                        dto.cpf()));

        return new EntregadorDTO(entregador.getId(),
                entregador.getNome(),
                entregador.getCpf()
        );
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Demitir Entregador", description = "Demite um entregador, apagando seus dados.")
    public void deletarEntregador(@PathVariable Long id) {
        excluirEntregador.excluirEntregador(id);
    }

    @GetMapping
    @Operation(summary = "Listar Entregadores", description = "Lista todos os entregadores.")
    public List<EntregadorDTO> listarEntregadores() {
        List<EntregadorDTO> entregas = new ArrayList<>();
        obterTodosEntregadores.obterTodosEntregadores()
                .forEach(v -> entregas.add(
                        new EntregadorDTO(
                                v.getId(),
                                v.getNome(),
                                v.getCpf()
                        )
                ));
        return entregas;
    }
}
