package com.example.viennaapp.models;

public class Empleado {

    private int idEmpleado;
    private String nombre;
    private String apellido;
    private String correo;
    private String clave;
    private byte estadoEmpleado;

    public Empleado() {
    }

    public Empleado(int idEmpleado, String nombre, String apellido, String correo, String clave, byte estadoEmpleado) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.clave = clave;
        this.estadoEmpleado = estadoEmpleado;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
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

    public byte getEstadoEmpleado() {
        return estadoEmpleado;
    }

    public void setEstadoEmpleado(byte estadoEmpleado) {
        this.estadoEmpleado = estadoEmpleado;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "idEmpleado=" + idEmpleado +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", correo='" + correo + '\'' +
                ", clave='" + clave + '\'' +
                ", estadoEmpleado=" + estadoEmpleado +
                '}';
    }
}
