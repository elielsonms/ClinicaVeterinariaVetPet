<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VetPet - Meus Animais</title>
        <style>
            td{
                margin:5px;
                padding:5px;
            }
        </style>
    </head>
    <body>
        <jsp:include page="/WEB-INF/header.jsp" />
        <table>
            <tr>
                <th>Animal</th>
            </tr>
         <c:forEach items="${animais}" var="animal">
            <tr>
                <td>${animal.getNome()}</td>
            </tr>
        </c:forEach>
            </table>
        <jsp:include page="/WEB-INF/footer.jsp" />
    </body>
</html>