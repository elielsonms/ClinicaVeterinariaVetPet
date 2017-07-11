<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> Sistema de Marcação de Consultas da Clinica Veterinária VetPet</h1>
        <form action="/consulta/InformarDados" method="post">
            <select name="data">
                <c:forEach items="${datasPossiveis}" var="dataPossivel">
                <option value="<c:out value="${dataPossivel}"/>"><c:out value="${dataPossivel}"/></option>
                </c:forEach>
            </select>
            <input type="submit" value="Selecionar"/>
        </form>
        <a href='index.html'>Voltar</a>
    </body>
</html>
