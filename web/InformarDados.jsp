<%-- 
    Document   : MarcarConsulta
    Created on : 17/06/2017, 14:45:34
    Author     : aluno
--%>

<%@page import="bd.Dados"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> Sistema de Marcação de Consultas da Clinica Veterinária VetPet</h1>
        <form action="AgendarConsulta" method="post">
            Cliente <input type="text" name="cliente"/> <br/>
            Animal <input type="text" name="animal"/><br/>
            Medico <select name="medico">
                <% for(int i=0;i< Dados.medicos().size();i++){ %>
                <option value="<%= Dados.medicos().get(i) %>"><%= Dados.medicos().get(i) %></option>
                <% } %>
                </select>     
            
            <br/>
            Data <input type="text" name="data" value="<%=request.getParameter("data") %>"/><br/>
            <input value="Salvar" type="submit"/>
        </form>
        <a href='index.html'>Voltar</a>
    </body>
</html>
