package com.example.viennaapp.models;

import java.util.List;

public class Invitado {

    private int idInvitado;
    private String nombre;
    private String apellido;
    private double dni;
    private byte estadoInvitado;
    private List<EventoInvitado> eventoInvitado;

    public Invitado() {
    }

    public Invitado(int idInvitado, String nombre, String apellido, double dni, byte estadoInvitado, List<EventoInvitado> eventoInvitado) {
        this.idInvitado = idInvitado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.estadoInvitado = estadoInvitado;
        this.eventoInvitado = eventoInvitado;
    }

    public int getIdInvitado() {
        return idInvitado;
    }

    public void setIdInvitado(int idInvitado) {
        this.idInvitado = idInvitado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getDni() {
        return dni;
    }

    public void setDni(double dni) {
        this.dni = dni;
    }

    public byte getEstadoInvitado() {
        return estadoInvitado;
    }

    public void setEstadoInvitado(byte estadoInvitado) {
        this.estadoInvitado = estadoInvitado;
    }

    public List<EventoInvitado> getEventoInvitado() {
        return eventoInvitado;
    }

    public void setEventoInvitado(List<EventoInvitado> eventoInvitado) {
        this.eventoInvitado = eventoInvitado;
    }

    @Override
    public String toString() {
        return "Invitado{" +
                "idInvitado=" + idInvitado +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dni +
                ", estadoInvitado=" + estadoInvitado +
                ", eventoInvitado=" + eventoInvitado +
                '}';
    }
}
