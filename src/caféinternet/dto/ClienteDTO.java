/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caféinternet.dto;

/**
 *
 * @author David
 */
public class ClienteDTO extends BaseDTO{
    private Integer PK_IdCliente;
    private String Nombre;
    private String Apellidos;
    private String FechaNacimiento;
    private String Observaciones;
    private String Direccion;
    private Integer Telefono;

    public ClienteDTO() {
    }

    public ClienteDTO(Integer PK_IdCliente, String Nombre, String Apellidos, String FechaNacimiento, String Direccion, Integer Telefono, String Observaciones, String ultUsuario, String ultFecha) {
        super(ultUsuario, ultFecha);
        this.PK_IdCliente = PK_IdCliente;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.FechaNacimiento = FechaNacimiento;
        this.Observaciones = Observaciones;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
    }

    public ClienteDTO(Integer PK_IdCliente, String Nombre, String Apellidos, String FechaNacimiento, String Observaciones, String Direccion, Integer Telefono) {
        this.PK_IdCliente = PK_IdCliente;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.FechaNacimiento = FechaNacimiento;
        this.Observaciones = Observaciones;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
    }

    public Integer getPK_IdCliente() {
        return PK_IdCliente;
    }

    public void setPK_IdCliente(Integer PK_IdCliente) {
        this.PK_IdCliente = PK_IdCliente;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(String FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public Integer getTelefono() {
        return Telefono;
    }

    public void setTelefono(Integer Telefono) {
        this.Telefono = Telefono;
    }
    
 
}
