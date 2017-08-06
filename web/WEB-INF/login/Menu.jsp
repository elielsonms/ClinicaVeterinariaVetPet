<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>VetPet - Menu</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <jsp:include page="/WEB-INF/header.jsp" />
        <a href="${request.getContextPath()}/consulta/SelecionarData">Marcar Consulta</a> <br/>
        <a href="${request.getContextPath()}/consulta/ConsultasAgendadas">Visualizar Agendadas</a><br/>
        <a href="${request.getContextPath()}/cliente/ListaCliente">Clientes</a><br/>
        <a href="${request.getContextPath()}/plano/Planos">Planos</a><br/>
        <a href="${request.getContextPath()}/animal/Meus">Meus Animais</a><br/>
        <a href="${request.getContextPath()}/Sair">Sair</a>
    </body>
</html>
