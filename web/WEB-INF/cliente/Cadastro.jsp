<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> Sistema de Marcação de Consultas da Clinica Veterinária VetPet</h1>
        <form action="${request.getContextPath()}/cliente/Cadastro" method="post">
            Nome <input type="text" name="nome"/> <br/>
            Usuario <input type="text" name="usuario"/> <br/>
            Senha <input type="password" name="senha"/> <br/>
            <input value="Salvar" type="submit"/>
        </form>
        <a href='${request.getContextPath()}/index.html'>Voltar</a>
    </body>
</html>