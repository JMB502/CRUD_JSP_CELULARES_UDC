/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import configuracion.conexion;
import interfaces.crud_jsp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.celulares;

/**
 *
 * @author USUARIO
 */
public class celularesDAO implements crud_jsp {
    conexion cn=new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    celulares c=new celulares();
   
   @Override
   
   
   public List listar() {
       ArrayList<celulares>list=new ArrayList<>();
       String sql ="select * from celulares";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                
                celulares cel   = new celulares();
            cel.setId(rs.getInt("id"));
            cel.setModelo(rs.getString("modelo"));
            cel.setMarca(rs.getString("marca"));
            cel.setImei(rs.getString("imei"));
                list.add(cel);
                
            
            }  
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public celulares list(int id) {
        String sql ="select * from celulares where id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                
              
            c.setId(rs.getInt("id"));
            c.setModelo(rs.getString("modelo"));
            c.setMarca(rs.getString("marca"));
            c.setImei(rs.getString("imei"));
            
                
            
            }  
        } catch (Exception e) {
        }
        return c;
    }

    @Override
    public boolean agregar(celulares cel) {
        String sql ="insert into celulares (modelo, marca, imei)values('"+ cel.getModelo()+"','"+cel.getMarca()+"','"+cel.getImei()+"')";
        try {
           con=cn.getConnection();
           ps=con.prepareStatement(sql);
           ps.executeUpdate();
        } catch (Exception e) {
        }
        
        
        return false;
    }

    @Override
    public boolean editar(celulares cel) {
               String sql ="update celulares set modelo='"+ cel.getModelo()+"',marca='"+cel.getMarca()+"',imei='"+cel.getImei()+"'where id="+cel.getId();
               try {
            con=cn.getConnection();
           ps=con.prepareStatement(sql);
           ps.executeUpdate();
        } catch (Exception e) {
            
        }
               return false;
               
               
    }

    @Override
    public boolean eliminar(int id) {
       String sql ="delete from celulares where id="+id;
        try {
              con=cn.getConnection();
           ps=con.prepareStatement(sql);
           ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
    
    
}
