<%-- 
    Document   : login
    Created on : 17/07/2017, 19:42:37
    Author     : elielsonms
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="${request.getContextPath()}/Login">
            Usuario <input name="usuario" type="text"/> <br/>
            Senha <input name="senha" type="password"/>
        </form>
    </body>
</html>
