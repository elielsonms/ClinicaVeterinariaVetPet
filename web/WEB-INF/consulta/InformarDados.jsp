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
        <form action="${request.getContextPath()}/consulta/Salvar" method="post">
            Cliente <input type="text" name="cliente"/> <br/>
            Animal <input type="text" name="animal"/><br/>
            Medico <select name="medico">
                    <c:forEach items="${medicos}" var="medico">
                    <option value="${medico.getIdMedico()}"><c:out value="${medico.getNome()}"/></option>
                    </c:forEach>
                </select>
            <br/>
            Data <input type="text" name="data" value="${dataSelecionada}"/><br/>
            <input value="Salvar" type="submit"/>
        </form>
        <a href='${request.getContextPath()}/index.html'>Voltar</a>
    </body>
</html>
