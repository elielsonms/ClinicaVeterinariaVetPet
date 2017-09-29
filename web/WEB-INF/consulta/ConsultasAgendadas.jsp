<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>VetPet - Lista de Consultas Agendadas</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <jsp:include page="/WEB-INF/header.jsp" />
        <c:forEach items="${consultas}" var="consulta">
            <p>
                Consulta do cliente <c:out value="${consulta.getCliente().getNome()}"/> 
                para o animal <c:out value="${consulta.getAnimal().getNome()}"/> 
                com o veterinario <c:out value="${consulta.getHorario().getMedico().getNome()}"/> 
                foi agendada para o dia <c:out value="${consulta.getHorario().getDataHoraFormatada()}"/>
            </p>
        </c:forEach>
        <c:if test="${consultas == null}">
                Nenhuma Consulta agendada <br/><br/>
        </c:if>
        <jsp:include page="/WEB-INF/footer.jsp" />
    </body>
</html>
