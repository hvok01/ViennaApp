package com.example.viennaapp.models;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Evento {

    @SerializedName("idEvento")
    private int idEvento;
    @SerializedName("nombre")
    private String nombre;
    @SerializedName("inicioEvento")
    private Date inicioEvento;
    @SerializedName("finEvento")
    private Date finEvento;
    @SerializedName("cantidadAsistentes")
    private int cantidadAsistentes;
    @SerializedName("precioEntrada")
    private double precioEntrada;
    @SerializedName("estadoEvento")
    private byte estadoEvento;
    @SerializedName("idSala")
    private int idSala;
    @SerializedName("idDuenioEvento")
    private int idDuenioEvento;
    @SerializedName("sala")
    private Sala sala;
    @SerializedName("duenioEvento")
    private DuenioEvento duenioEvento;
    @SerializedName("eventoInvitado")
    private List<EventoInvitado> eventoInvitado;

    public Evento() {
    }

    public Evento(int idEvento, String nombre, Date inicioEvento, Date finEvento, int cantidadAsistentes, double precioEntrada, byte estadoEvento, int idSala, int idDuenioEvento, Sala sala, DuenioEvento duenioEvento, List<EventoInvitado> eventoInvitado) {
        this.idEvento = idEvento;
        this.nombre = nombre;
        this.inicioEvento = inicioEvento;
        this.finEvento = finEvento;
        this.cantidadAsistentes = cantidadAsistentes;
        this.precioEntrada = precioEntrada;
        this.estadoEvento = estadoEvento;
        this.idSala = idSala;
        this.idDuenioEvento = idDuenioEvento;
        this.sala = sala;
        this.duenioEvento = duenioEvento;
        this.eventoInvitado = eventoInvitado;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getInicioEvento() {
        return inicioEvento;
    }

    public void setInicioEvento(Date inicioEvento) {
        this.inicioEvento = inicioEvento;
    }

    public Date getFinEvento() {
        return finEvento;
    }

    public void setFinEvento(Date finEvento) {
        this.finEvento = finEvento;
    }

    public int getCantidadAsistentes() {
        return cantidadAsistentes;
    }

    public void setCantidadAsistentes(int cantidadAsistentes) {
        this.cantidadAsistentes = cantidadAsistentes;
    }

    public double getPrecioEntrada() {
        return precioEntrada;
    }

    public void setPrecioEntrada(double precioEntrada) {
        this.precioEntrada = precioEntrada;
    }

    public byte getEstadoEvento() {
        return estadoEvento;
    }

    public void setEstadoEvento(byte estadoEvento) {
        this.estadoEvento = estadoEvento;
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public int getIdDuenioEvento() {
        return idDuenioEvento;
    }

    public void setIdDuenioEvento(int idDuenioEvento) {
        this.idDuenioEvento = idDuenioEvento;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public DuenioEvento getDuenioEvento() {
        return duenioEvento;
    }

    public void setDuenioEvento(DuenioEvento duenioEvento) {
        this.duenioEvento = duenioEvento;
    }

    public List<EventoInvitado> getEventoInvitado() {
        return eventoInvitado;
    }

    public void setEventoInvitado(List<EventoInvitado> eventoInvitado) {
        this.eventoInvitado = eventoInvitado;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "idEvento=" + idEvento +
                ", nombre='" + nombre + '\'' +
                ", inicioEvento=" + inicioEvento +
                ", finEvento=" + finEvento +
                ", cantidadAsistentes=" + cantidadAsistentes +
                ", precioEntrada=" + precioEntrada +
                ", estadoEvento=" + estadoEvento +
                ", idSala=" + idSala +
                ", idDuenioEvento=" + idDuenioEvento +
                ", sala=" + sala +
                ", duenioEvento=" + duenioEvento +
                ", eventoInvitado=" + eventoInvitado +
                '}';
    }
}
