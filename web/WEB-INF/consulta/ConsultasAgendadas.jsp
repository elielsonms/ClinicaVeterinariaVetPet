<%-- 
    Document   : ConsultasAgendadas
    Created on : 10/07/2017, 20:45:16
    Author     : elielsonms
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Servlet ConsultasAgendadas</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1> Sistema de Marcação de Consultas da Clinica Veterinária VetPet</h1>
    <c:forEach items="${consultas}" var="consulta">
        <p>
            Consulta do cliente <c:out value="${consulta.getCliente().getNome()}"/> 
            para o animal <c:out value="${consulta.getAnimal().getNome()}"/> 
            com o veterinario <c:out value="${consulta.getMedico().getNome()}"/> 
            foi agendada para o dia <c:out value="${consulta.getData()}"/>
        </p>
    </c:forEach>
    <c:if test="${consultas == null}">
                Nenhuma Consulta agendada <br/><br/>
    </c:if>
        <a href='${request.getContextPath()}/index.html'>Voltar</a>
    </body>
</html>
