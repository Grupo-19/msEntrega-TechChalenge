package com.fiap.msEntrega.domain.entrega;

public class Entrega {

    private Long id;
    private Long idEntregador;
    private String status;
    private Long idPedido;
    private Long idCliente;
    private Long idEndereco;

    public Entrega() {
    }

    public Entrega(Long idEntregador, String status, Long idPedido, Long idCliente, Long idEndereco) {
        this.idEntregador = idEntregador;
        this.status = status;
        this.idPedido = idPedido;
        this.idCliente = idCliente;
        this.idEndereco = idEndereco;
    }

    public Entrega(Long id, Long idEntregador, String status, Long idPedido, Long idCliente, Long idEndereco) {
        this.id = id;
        this.idEntregador = idEntregador;
        this.status = status;
        this.idPedido = idPedido;
        this.idCliente = idCliente;
        this.idEndereco = idEndereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdEntregador() {
        return idEntregador;
    }

    public void setIdEntregador(Long idEntregador) {
        this.idEntregador = idEntregador;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
    }
}
