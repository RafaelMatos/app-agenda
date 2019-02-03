<%-- 
    Document   : listarContatos
    Created on : 02/02/2019, 00:16:50
    Author     : work
--%>

<%@page import="model.Contato"%>
<%@page import="java.util.List"%>
<%@page import="dao.JDBCContatoDAO"%>
<%@page import="java.sql.Connection"%>
<%@page import="dao.FabricaConexao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Contatos</title>
    </head>
    <body>
        <%
            FabricaConexao fabrica = new FabricaConexao();
            Connection conn = fabrica.criarConexao();
            JDBCContatoDAO dao = new JDBCContatoDAO(conn);
            
           List<Contato> contatos = dao.listarTodos();
            
            fabrica.fecharConexao();
        %>
        <h1>Lista de Contatos! </h1>
        <table border="1" cellpadding="10" >
            <tr>
                <th>id</th>
                <th>Nome</th>
                <th>Telefone</th>
                <th>Celular</th>
                <th>E-mail</th>
            </tr>
            <% for (Contato c:contatos){ %>
            <tr>
                <td> <%= c.getId() %> </td>
                <td> <%= c.getNome() %> </td>
                <td> <%= c.getTelefone()%> </td>
                <td> <%= c.getCelular()%> </td>
                <td> <%= c.getEmail()%> </td>
            </tr>
            <% } %>
        </table>
    </body>
</html>
