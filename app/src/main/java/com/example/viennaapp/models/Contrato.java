package com.example.viennaapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Contrato {

    @SerializedName("idContrato")
    private int idContrato;
    @SerializedName("estadoContrato")
    private byte estadoContrato;
    @SerializedName("precioFinal")
    private double precioFinal;
    @SerializedName("idEvento")
    private int idEvento ;
    @SerializedName("pagado")
    private byte pagado ;
    @SerializedName("evento")
    private Evento evento ;

    public Contrato() {
    }

    public Contrato(int idContrato, byte estadoContrato, double precioFinal, int idEvento, byte pagado, Evento evento) {
        this.idContrato = idContrato;
        this.estadoContrato = estadoContrato;
        this.precioFinal = precioFinal;
        this.idEvento = idEvento;
        this.pagado = pagado;
        this.evento = evento;
    }

    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    public byte getEstadoContrato() {
        return estadoContrato;
    }

    public void setEstadoContrato(byte estadoContrato) {
        this.estadoContrato = estadoContrato;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public byte getPagado() {
        return pagado;
    }

    public void setPagado(byte pagado) {
        this.pagado = pagado;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    @Override
    public String toString() {
        return "Contrato{" +
                "idContrato=" + idContrato +
                ", estadoContrato=" + estadoContrato +
                ", precioFinal=" + precioFinal +
                ", idEvento=" + idEvento +
                ", pagado=" + pagado +
                ", evento=" + evento +
                '}';
    }
}
