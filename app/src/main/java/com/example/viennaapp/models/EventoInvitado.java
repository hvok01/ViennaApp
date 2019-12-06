package com.example.viennaapp.models;

public class EventoInvitado {

    private int idEvento;
    private int idInvitado;
    private byte estadoRelacion;
    private Evento evento;
    private Invitado invitado;




    public EventoInvitado() {
    }

    public EventoInvitado(int idEvento, int idInvitado, byte estadoRelacion, Evento evento, Invitado invitado) {
        this.idEvento = idEvento;
        this.idInvitado = idInvitado;
        this.estadoRelacion = estadoRelacion;
        this.evento = evento;
        this.invitado = invitado;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public int getIdInvitado() {
        return idInvitado;
    }

    public void setIdInvitado(int idInvitado) {
        this.idInvitado = idInvitado;
    }

    public byte getEstadoRelacion() {
        return estadoRelacion;
    }

    public void setEstadoRelacion(byte estadoRelacion) {
        this.estadoRelacion = estadoRelacion;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Invitado getInvitado() {
        return invitado;
    }

    public void setInvitado(Invitado invitado) {
        this.invitado = invitado;
    }

    @Override
    public String toString() {
        return "EventoInvitado{" +
                "idEvento=" + idEvento +
                ", idInvitado=" + idInvitado +
                ", estadoRelacion=" + estadoRelacion +
                ", evento=" + evento +
                ", invitado=" + invitado +
                '}';
    }
}