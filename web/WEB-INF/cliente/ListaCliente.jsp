<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VetPet - Cadastro de Cliente</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/header.jsp" />
        <table>
            <tr>
                <td>Cliente</td>
                <td>Plano</td>
                <td>Qtd Consultas no mês</td>
                <td>Qtd Consultas no ano</td>
                <td>Qtd Consultas no total</td>
            </tr>
         <c:forEach items="${clientes}" var="cliente">
            <tr>
                <td>${cliente.getNome()}</td>
                <td>${cliente.getPlano().getNome()}</td>
                <td>${cliente.getQtdConsultasMes()}</td>
                <td>${cliente.getQtdConsultasAno()}</td>
                <td>${cliente.getQtdConsultasTotal()}</td>
            </tr>
        </c:forEach>
            </table>
        <jsp:include page="/WEB-INF/footer.jsp" />
    </body>
</html>
