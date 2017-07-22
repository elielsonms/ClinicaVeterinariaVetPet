<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VetPet - Login</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/header.jsp" />
        <form method="post" action="${request.getContextPath()}/Login">
            Usuario <input name="usuario" type="text"/> <br/>
            Senha <input name="senha" type="password"/>
            <input type="submit" value="Enviar"/>
            ${mensagem}
        </form>
        <a href="${request.getContextPath()}/cliente/Cadastro">Novo Cliente</a>
    </body>
</html>
