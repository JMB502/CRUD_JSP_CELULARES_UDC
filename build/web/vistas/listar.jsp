<%-- 
    Document   : listar
    Created on : 6/04/2023, 11:24:51 PM
    Author     : USUARIO
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="modelo.celulares"%>
<%@page import="modeloDAO.celularesDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <h1>
                CELULARES
            </h1>
            <a href="controlador?accion=add">AGREGAR NUEVO CELULAR</a>
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>MODELO</th>
                        <th>MARCA</th>
                        <th>IMEI</th>
                        
                    </tr>
                </thead>
                <%
                celularesDAO dao= new celularesDAO();
                List <celulares> list=dao.listar();
                Iterator<celulares>iter=list.iterator();
                celulares cel =null;
                while (iter.hasNext()){
                cel=iter.next();
                
                
                %>
                <tbody>
                    <tr>
                        <td><%= cel.getId()%></td>
                        <td><%= cel.getModelo()%></td>
                        <td><%= cel.getMarca()%></td>
                        <td><%= cel.getImei()%></td>
                        <td>
                            
                            <a href="controlador?accion=editar&id=<%= cel.getId()%>">EDITAR</a>
                            <a <a href="controlador?accion=eliminar&id=<%= cel.getId()%>">ELIMINAR</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </div>
    </body>
</html>