/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import modelo.celulares;

/**
 *
 * @author USUARIO
 */
public interface crud_jsp {
    public List listar();
    public celulares list(int id);
    public boolean agregar (celulares cel);
    public boolean editar (celulares cel);
    public boolean eliminar (int id);
    
    


}
