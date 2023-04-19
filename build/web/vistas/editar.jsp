<%-- 
    Document   : editar
    Created on : 6/04/2023, 11:25:12 PM
    Author     : USUARIO
--%>

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
         <%
         celularesDAO dao = new celularesDAO();
         int id = Integer.parseInt((String)request.getAttribute("idcel"));
         celulares c=(celulares)dao.list(id);
         
         
         %>
         
            <h1>EDITAR CELULAR </h1>
            <form action="controlador">
                ID : <br>
                MODELO: <br>
                <input type="text" name ="txtmodelo" value="<%= c.getModelo()%>"><br>
                MARCA: <br>
                <input type="text" name ="txtmarca" value="<%= c.getMarca()%>"><br>
                IMEI: <br>
                <input type="text" name ="txtimei" value="<%= c.getImei()%>"><br>
                
                <input type="hidden" name ="txtid" value="<%= c.getId()%>">
                <input type="submit" name="accion" value="Actualizar"><br>
                <a href="controlador?accion=listar">REGRESAR</a>
                
            </form>
        </div>
    </body>
</html>
