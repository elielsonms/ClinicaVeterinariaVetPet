<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VetPet - Selecionar Data da Consulta</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/header.jsp" />
        <form action="${request.getContextPath()}/consulta/InformarDados" method="post">
            <select name="id_horario">
                <c:forEach items="${horariosLivres}" var="hoarioLivre">
                    <option value="<c:out value="${hoarioLivre.idHorario}"/>">${hoarioLivre.horario} - ${hoarioLivre.medico}</option>
                </c:forEach>
            </select>
            <input type="submit" value="Selecionar"/>
        </form>
        <jsp:include page="/WEB-INF/footer.jsp" />
    </body>
</html>
