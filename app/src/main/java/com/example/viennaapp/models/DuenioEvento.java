package com.example.viennaapp.models;

public class DuenioEvento {

    private int idDuenioEvento ;
    private String nombre ;
    private String apellido;
    private String correo ;
    private String clave ;
    private byte estadoDuenio;

    public DuenioEvento() {
    }

    public DuenioEvento(int idDuenioEvento, String nombre, String apellido, String correo, String clave, byte estadoDuenio) {
        this.idDuenioEvento = idDuenioEvento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.clave = clave;
        this.estadoDuenio = estadoDuenio;
    }

    public int getIdDuenioEvento() {
        return idDuenioEvento;
    }

    public void setIdDuenioEvento(int idDuenioEvento) {
        this.idDuenioEvento = idDuenioEvento;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public byte getEstadoDuenio() {
        return estadoDuenio;
    }

    public void setEstadoDuenio(byte estadoDuenio) {
        this.estadoDuenio = estadoDuenio;
    }

    @Override
    public String toString() {
        return "DuenioEvento{" +
                "idDuenioEvento=" + idDuenioEvento +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", correo='" + correo + '\'' +
                ", clave='" + clave + '\'' +
                ", estadoDuenio=" + estadoDuenio +
                '}';
    }
}
