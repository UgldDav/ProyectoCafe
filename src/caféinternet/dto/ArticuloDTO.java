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
public class ArticuloDTO extends BaseDTO{

    private Integer PK_IdArticulo;
    private String Nombre;
    private String Descripcion;
    private Integer Cantidad;
    private Double PrecioUnitario;

    public ArticuloDTO() {
    }

    public ArticuloDTO(Integer PK_IdArticulo, String Nombre, String Descripcion, Integer Cantidad, Double PrecioUnitario, String ultUsuario, String ultFecha) {
        super(ultUsuario, ultFecha);
        this.PK_IdArticulo = PK_IdArticulo;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Cantidad = Cantidad;
        this.PrecioUnitario = PrecioUnitario;
    }

    public ArticuloDTO(Integer PK_IdArticulo, String Nombre, String Descripcion, Integer Cantidad, Double PrecioUnitario) {
        this.PK_IdArticulo = PK_IdArticulo;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Cantidad = Cantidad;
        this.PrecioUnitario = PrecioUnitario;
    }

    public Integer getPK_IdArticulo() {
        return PK_IdArticulo;
    }

    public void setPK_IdArticulo(Integer PK_IdArticulo) {
        this.PK_IdArticulo = PK_IdArticulo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Integer getCantidad() {
        return Cantidad;
    }

    public void setCantidad(Integer Cantidad) {
        this.Cantidad = Cantidad;
    }

    public Double getPrecioUnitario() {
        return PrecioUnitario;
    }

    public void setPrecioUnitario(Double PrecioUnitario) {
        this.PrecioUnitario = PrecioUnitario;
    }
         
    
}
