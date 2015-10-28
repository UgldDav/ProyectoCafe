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
public class ProveedorDTO extends BaseDTO{
    private Integer PK_IdProveedor;
    private String Nombre;
    private String Direccion;
    private Integer Telefono;
    private String Correo;

    public ProveedorDTO() {
    }

    public ProveedorDTO(Integer PK_IdProveedor, String Nombre, String Direccion,Integer Telefono,String Correo, String ultUsuario, String ultFecha) {
        super(ultUsuario, ultFecha);
        this.PK_IdProveedor = PK_IdProveedor;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Telefono=Telefono;
        this.Correo=Correo;
    }

    public ProveedorDTO(Integer PK_IdProveedor, String Nombre, String Direccion,Integer Telefono, String Correo ) {
        this.PK_IdProveedor = PK_IdProveedor;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
         this.Telefono=Telefono;
        this.Correo=Correo;
    }

    public Integer getPK_IdProveedor() {
        return PK_IdProveedor;
    }

    public void setPK_IdProveedor(Integer PK_IdProveedor) {
        this.PK_IdProveedor = PK_IdProveedor;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
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

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }
    
    
}
