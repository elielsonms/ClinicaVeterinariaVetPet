<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">

    <title>VetPet - Login</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">


    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
       <jsp:include page="/WEB-INF/header.jsp" />
    <div class="container">
        <form method="post" action="${request.getContextPath()}/Login" class="form-signin">
        <h2 class="form-signin-heading">Acessar</h2>
        <label for="inputEmail" class="sr-only">Usuário</label>
        <input type="text" id="inputUsuario" class="form-control" placeholder="Usuário" required autofocus name="usuario">
        <label for="inputSenha" class="sr-only">Password</label>
        <input type="password" id="inputSenha" class="form-control" placeholder="Senha" required name="senha" />
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
         <a href="${request.getContextPath()}/cliente/Cadastro">Novo Cliente</a>
      </form>
    </div> <!-- /container -->
     ${mensagem}

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>