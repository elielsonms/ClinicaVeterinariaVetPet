<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VetPet - Consulta salva com sucesso</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/header.jsp" />
        <h2>Olá ${consulta.getCliente().getNome()} sua consulta para o animal ${consulta.getAnimal().getNome()} foi agendada para o dia ${consulta.getHorario().getDataHoraFormatada()}</h2>
        <jsp:include page="/WEB-INF/footer.jsp" />
    </body>
</html>