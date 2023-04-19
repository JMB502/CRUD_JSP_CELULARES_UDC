<%-- 
    Document   : agregar
    Created on : 6/04/2023, 11:24:59 PM
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <h1>AGREGAR CELULAR </h1>
            <form action="controlador">
                ID : <br>
                MODELO: <br>
                <input type="text" name ="txtmodelo"><br>
                MARCA: <br>
                <input type="text" name ="txtmarca"><br>
                IMEI: <br>
                <input type="text" name ="txtimei"><br>
                <input type="submit" name="accion" value="Agregar"><br>
                
            </form>
        </div>
    </body>
</html>
