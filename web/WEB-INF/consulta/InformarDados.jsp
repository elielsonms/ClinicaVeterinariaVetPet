<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VetPet - Informar dados da Consulta</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/header.jsp" />
        <form action="${request.getContextPath()}/consulta/Salvar" method="post">
            <input type="hidden" value="${idHorario}" name="id_horario"/>

            Cliente ${nomeCliente}<br/>
            Animal <input type="text" name="animal"/><br/>
            Medico ${nomeMedico}<br/>
            Data <fmt:formatDate pattern="dd/MM/yyyy hh:mm" value="${dataSelecionada}"/><br/>
    
            <input value="Salvar" type="submit"/>
        </form>
        <jsp:include page="/WEB-INF/footer.jsp" />
    </body>
</html>
