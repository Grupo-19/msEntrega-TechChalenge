package com.fiap.msEntrega.infra.controller.entrega;

import com.fiap.msEntrega.app.usecases.entrega.*;
import com.fiap.msEntrega.domain.entrega.Entrega;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/entrega")
@Tag(name = "Entregas", description = "Endpoints para gerenciamento de entregas")
public class EntregaController {

    private final CadastrarUmaEntrega cadastrarUmaEntrega;
    private final ConsultarMelhorRota consultarMelhorRota;
    private final FinalizarUmaEntrega finalizarUmaEntrega;
    private final IniciarEntrega iniciarEntrega;
    private final ObterTodasEntregas obterTodasEntregas;

    public EntregaController(CadastrarUmaEntrega cadastrarUmaEntrega, ConsultarMelhorRota consultarMelhorRota, FinalizarUmaEntrega finalizarUmaEntrega, IniciarEntrega iniciarEntrega, ObterTodasEntregas obterTodasEntregas) {
        this.cadastrarUmaEntrega = cadastrarUmaEntrega;
        this.consultarMelhorRota = consultarMelhorRota;
        this.finalizarUmaEntrega = finalizarUmaEntrega;
        this.iniciarEntrega = iniciarEntrega;
        this.obterTodasEntregas = obterTodasEntregas;
    }

    @PostMapping
    @Operation(summary = "Receber Entrega", description = "Recebe um pedido e cadastra como entrega a ser feita.")
    public EntregaDTO receberEntrega(@RequestBody EntregaDTO dto){
        Entrega entrega = cadastrarUmaEntrega.cadastrarUmaEntrega(
                new Entrega(
                        dto.id(),
                        dto.idEntregador(),
                        dto.status(),
                        dto.idPedido(),
                        dto.idCliente(),
                        dto.idEndereco()
                ));

        return new EntregaDTO(
                entrega.getId(),
                entrega.getIdEntregador(),
                entrega.getStatus(),
                entrega.getIdPedido(),
                entrega.getIdCliente(),
                entrega.getIdEndereco()
        );
    }

    @GetMapping("/rotas")
    @Operation(summary = "Consultar melhores rotas", description = "Consultar as melhores rotas para entregar à partir de um endereço, a origem sempre será a FIAP São Paulo.")
    public String consultarMelhorRota(@RequestParam Long id){
        return consultarMelhorRota.consultarMelhorRota(id);
    }

    @PutMapping("/finalizar")
    @Operation(summary = "Finalizar Entrega", description = "Finaliza a entrega.")
    public EntregaDTO finalizarEntrega(@RequestParam Long idEntrega){
        Entrega entrega = finalizarUmaEntrega.finalizarUmaEntrega( idEntrega);
        return new EntregaDTO(
                entrega.getId(),
                entrega.getIdEntregador(),
                entrega.getStatus(),
                entrega.getIdPedido(),
                entrega.getIdCliente(),
                entrega.getIdEndereco()
        );
    }

    @PutMapping("/iniciar")
    @Operation(summary = "Iniciar Entrega", description = "Inicia a entrega.")
    public EntregaDTO iniciarEntrega(@RequestParam Long idEntregador, @RequestParam Long idEntrega){
        Entrega entrega = iniciarEntrega.iniciarEntrega(idEntregador, idEntrega);
        return new EntregaDTO(
                entrega.getId(),
                entrega.getIdEntregador(),
                entrega.getStatus(),
                entrega.getIdPedido(),
                entrega.getIdCliente(),
                entrega.getIdEndereco()
        );
    }

    @GetMapping
    @Operation(summary = "Consultar todos as entregas", description = "Consulta todos as entregas.")
    public List<EntregaDTO> listarEntregas(){
        List<EntregaDTO> entregas = new ArrayList<>();
        obterTodasEntregas.obterTodasEntregas().forEach( v -> {
            entregas.add(new EntregaDTO(
                    v.getId(),
                    v.getIdEntregador(),
                    v.getStatus(),
                    v.getIdPedido(),
                    v.getIdCliente(),
                    v.getIdEndereco()
            ));
        });

        return entregas;
    }
}
