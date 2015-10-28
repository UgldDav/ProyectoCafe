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
public class BaseDTO {
    private String ultUsuario;
    private String ultFecha;

    public BaseDTO(String ultUsuario, String ultFecha) {
        this.ultUsuario = ultUsuario;
        this.ultFecha = ultFecha;
    }

    public BaseDTO() {
    }

    public String getUltUsuario() {
        return ultUsuario;
    }

    public void setUltUsuario(String ultUsuario) {
        this.ultUsuario = ultUsuario;
    }

    public String getUltFecha() {
        return ultFecha;
    }

    public void setUltFecha(String ultFecha) {
        this.ultFecha = ultFecha;
    }
    
    
}
