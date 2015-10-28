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
public class FacturaDTO extends BaseDTO{
    private Integer PK_IdFactura;
    private String Fecha;
    private Integer FK_PK_IdCliente;

    public FacturaDTO() {
    }

    public FacturaDTO(Integer PK_IdFactura, Integer FK_PK_IdCliente, String Fecha, String ultUsuario, String ultFecha) {
        super(ultUsuario, ultFecha);
        this.PK_IdFactura = PK_IdFactura;
        this.Fecha = Fecha;
        this.FK_PK_IdCliente = FK_PK_IdCliente;
    }

    public FacturaDTO(Integer PK_IdFactura, Integer FK_PK_IdCliente, String Fecha) {
        this.PK_IdFactura = PK_IdFactura;
        this.Fecha = Fecha;
        this.FK_PK_IdCliente = FK_PK_IdCliente;
    }

    public Integer getPK_IdFactura() {
        return PK_IdFactura;
    }

    public void setPK_IdFactura(Integer PK_IdFactura) {
        this.PK_IdFactura = PK_IdFactura;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public Integer getFK_PK_IdCliente() {
        return FK_PK_IdCliente;
    }

    public void setFK_PK_IdCliente(Integer FK_PK_IdCliente) {
        this.FK_PK_IdCliente = FK_PK_IdCliente;
    }
    
    
}
