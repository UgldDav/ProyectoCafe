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
public class UsuarioDTO extends BaseDTO{
    private Integer PK_IdUsuario;
    private String Contraseña;
    private String NombreCompleto;

    public UsuarioDTO() {
    }

    
    public UsuarioDTO(Integer PK_IdUsuario, String Contraseña, String NombreCompleto, String ultUsuario, String ultFecha) {
        super(ultUsuario, ultFecha);
        this.PK_IdUsuario = PK_IdUsuario;
        this.Contraseña = Contraseña;
        this.NombreCompleto = NombreCompleto;
    }

    public UsuarioDTO(Integer PK_IdUsuario, String Contraseña, String NombreCompleto) {
        this.PK_IdUsuario = PK_IdUsuario;
        this.Contraseña = Contraseña;
        this.NombreCompleto = NombreCompleto;
    }

    public Integer getPK_IdUsuario() {
        return PK_IdUsuario;
    }

    public void setPK_IdUsuario(Integer PK_IdUsuario) {
        this.PK_IdUsuario = PK_IdUsuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public void setNombreCompleto(String NombreCompleto) {
        this.NombreCompleto = NombreCompleto;
    }
    
    
}
