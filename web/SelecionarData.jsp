<%-- 
    Document   : MarcarConsulta
    Created on : 17/06/2017, 14:45:34
    Author     : aluno
--%>

<%@page import="bd.Dados"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="items" value=""/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> Sistema de Marcação de Consultas da Clinica Veterinária VetPet</h1>
        <form action="InformarDados.jsp" method="post">
            <select name="data">
                <% for(int i=0;i<Dados.datasPossiveis().size();i++){ %>
                <option value="<%= Dados.datasPossiveis().get(i) %>"><%= Dados.datasPossiveis().get(i) %></option>
                <% } %>
            </select>
            <input type="submit" value="Selecionar"/>
        </form>
        <a href='index.html'>Voltar</a>
    </body>
</html>
