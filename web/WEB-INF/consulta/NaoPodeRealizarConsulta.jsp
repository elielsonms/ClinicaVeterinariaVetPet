<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VetPet - Consulta salva com sucesso</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/header.jsp" />
        <h2>Olá ${cliente.getNome()} sua quantidade de consultas para seu plano já terminou</h2>
        <jsp:include page="/WEB-INF/footer.jsp" />
    </body>
</html>