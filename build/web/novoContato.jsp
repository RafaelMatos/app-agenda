<%-- 
    Document   : novoContato
    Created on : 01/02/2019, 16:28:56
    Author     : work
--%>

<%@page import="model.Contato"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <div>
            <h1>Novo Contato</h1>
            <form action="inserirContato" method="POST">
                <label for="txtNome" class="">Nome: </label>
                <input id="txtNome" type="text" class="" name="nome" placeholder="Seu nome"><br>
                
                <label for="txtTel" class="">Telefone: </label>
                <input id="txtTel" type="text" class="" name="tel" placeholder="(xx)xxxxx-xxxx"><br>
                
                <label for="txtCel" class="">Celular: </label>
                <input id="txtCel" type="text" class="" name="cel" placeholder="(xx)xxxxx-xxxx"><br>
                
                <label for="txtEmail" class="">E-mail: </label>
                <input id="txtEmail" type="email" class="" name="email" placeholder="Seu e-mail favorito"><br>
                
                <input type="submit" value="Salvar">
            </form>
            
        </div>
       
    </body>
</html>
