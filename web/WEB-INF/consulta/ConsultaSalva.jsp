<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> Sistema de Marcação de Consultas da Clinica Veterinária VetPet</h1>
        <h2>Olá ${consulta.getCliente().getNome()} sua consulta para o animal ${consulta.getAnimal().getNome()} foi agendada para o dia ${consulta.getData()}</h2>
        <a href='${request.getContextPath()}/index.html'>Voltar</a>
    </body>
</html>