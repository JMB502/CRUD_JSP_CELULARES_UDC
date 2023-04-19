/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static jdk.nashorn.internal.runtime.Debug.id;
import modelo.celulares;
import modeloDAO.celularesDAO;

/**
 *
 * @author USUARIO
 */
public class controlador extends HttpServlet {
    
    
    String listar ="vistas/listar.jsp";
    String agregar ="vistas/agregar.jsp";
    String editar ="vistas/editar.jsp";
    celulares cel=new celulares();
    celularesDAO dao=new celularesDAO();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet controlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String acceso = "";
        String action=request.getParameter("accion");
        if (action.equalsIgnoreCase("listar")){
        acceso=listar;
        }
        
        
        
        
        
        
        /*AGREGAR*/
        else if(action.equalsIgnoreCase("add")){
            acceso=agregar;
        
        
        }
        
        else if(action.equalsIgnoreCase("Agregar")){
            
            String modelo=request.getParameter("txtmodelo");
            String marca=request.getParameter("txtmarca");
            String imei=request.getParameter("txtimei");
            
            cel.setModelo(modelo);
            cel.setMarca(marca);
            cel.setImei(imei);
            dao.agregar(cel);
            acceso=listar;
        
        }
        /*EDITAR*/
        else if(action.equalsIgnoreCase("editar")){
        request.setAttribute("idcel",request.getParameter("id"));
        acceso=editar;
                
        
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            int id = Integer.parseInt(request.getParameter("txtid"));
            String modelo=request.getParameter("txtmodelo");
            String marca=request.getParameter("txtmarca");
            String imei=request.getParameter("txtimei");
            
            cel.setId(id);
            cel.setModelo(modelo);
            cel.setMarca(marca);
            cel.setImei(imei);
            dao.editar(cel);
            acceso =listar;
        }
        
        /*ELIMINAR */
        
        else if(action.equalsIgnoreCase("eliminar")){
        int id=Integer.parseInt(request.getParameter("id"));
        cel.setId(id);
        dao.eliminar(id);
        acceso=listar;
        
        
        }
        
        RequestDispatcher vista=request.getRequestDispatcher(acceso);
        vista.forward(request, response);
        
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
