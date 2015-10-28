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
public class ArticuloPorProveedorDTO extends BaseDTO{
Integer FK_PK_IdArticulo;
Integer FK_PK_IdProveedor;

    public ArticuloPorProveedorDTO() {
    }


    public ArticuloPorProveedorDTO(Integer FK_PK_IdArticulo, Integer FK_PK_IdProveedor, String ultUsuario, String ultFecha) {
        super(ultUsuario, ultFecha);
        this.FK_PK_IdArticulo = FK_PK_IdArticulo;
        this.FK_PK_IdProveedor = FK_PK_IdProveedor;
    }

    public ArticuloPorProveedorDTO(Integer FK_PK_IdArticulo, Integer FK_PK_IdProveedor) {
        this.FK_PK_IdArticulo = FK_PK_IdArticulo;
        this.FK_PK_IdProveedor = FK_PK_IdProveedor;
    }

    public Integer getFK_PK_IdArticulo() {
        return FK_PK_IdArticulo;
    }

    public void setFK_PK_IdArticulo(Integer FK_PK_IdArticulo) {
        this.FK_PK_IdArticulo = FK_PK_IdArticulo;
    }

    public Integer getFK_PK_IdProveedor() {
        return FK_PK_IdProveedor;
    }

    public void setFK_PK_IdProveedor(Integer FK_PK_IdProveedor) {
        this.FK_PK_IdProveedor = FK_PK_IdProveedor;
    }


}
