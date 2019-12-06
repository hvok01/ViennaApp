package com.example.viennaapp.models;

public class Sala {

    private int idSala;
    private int capacidadMaxima;
    private String nombre;
    private byte disponibilidad;
    private byte estadoSala;

    public Sala() {
    }

    public Sala(int idSala, int capacidadMaxima, String nombre, byte disponibilidad, byte estadoSala) {
        this.idSala = idSala;
        this.capacidadMaxima = capacidadMaxima;
        this.nombre = nombre;
        this.disponibilidad = disponibilidad;
        this.estadoSala = estadoSala;
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(byte disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public byte getEstadoSala() {
        return estadoSala;
    }

    public void setEstadoSala(byte estadoSala) {
        this.estadoSala = estadoSala;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "idSala=" + idSala +
                ", capacidadMaxima=" + capacidadMaxima +
                ", nombre='" + nombre + '\'' +
                ", disponibilidad=" + disponibilidad +
                ", estadoSala=" + estadoSala +
                '}';
    }
}
