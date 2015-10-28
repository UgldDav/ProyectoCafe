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
public class ComputadoraDTO extends BaseDTO{
    private Integer PK_IdComputadora;
    private Integer estado;

    public ComputadoraDTO() {
    }

    
    public ComputadoraDTO(Integer PK_IdComputadora,Integer estado, String ultUsuario, String ultFecha) {
        super(ultUsuario, ultFecha);
        this.PK_IdComputadora = PK_IdComputadora;
        this.estado=estado;
    }

    public ComputadoraDTO(Integer PK_IdComputadora,Integer estado) {
        this.PK_IdComputadora = PK_IdComputadora;
        this.estado=estado;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
    
    public Integer getPK_IdComputadora() {
        return PK_IdComputadora;
    }

    public void setPK_IdComputadora(Integer PK_IdComputadora) {
        this.PK_IdComputadora = PK_IdComputadora;
    }
    
    
    
}
