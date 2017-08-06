<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VetPet - Planos</title>
        <style>
            .plano{
                width: 100px;
                margin: 5px;
                padding:5px;
                border: 1px solid black;
                float:left;
            }
            .meu_plano{
                border:1px solid red;
            }
        </style>
    </head>
    <body>
        <jsp:include page="/WEB-INF/header.jsp" />
        <form method="post" action="${request.getContextPath()}/plano/Planos">
            <input type="submit" name="opcao" value="+"/>
            <input type="submit" name="opcao" value="-"/>
            <div style="text-align: center; width: 100%">
                <span class="plano ${classeGratuito}">
                    <p>Grauito</p>
                    <p>Consultas por ano: 1</p>
                    <p>Consultas por mês: 1</p>
                    <p>valor: R$00,00</p>
                </span>
                <span class="plano ${classeBasico}">
                    <p>Básico</p>
                    <p>Consultas por ano: 60</p>
                    <p>Consultas por mês: 5</p>
                    <p>valor: R$50,00</p>
                </span>
                <span class="plano ${classeEspecial}">
                    <p>Especial</p>
                    <p>Consultas por ano: 120</p>
                    <p>Consultas por mês: 10</p>
                    <p>valor: R$70,00</p>
                </span>
                <span class="plano ${classeSupremo}">
                    <p>Supremo</p>
                    <p>Consultas por ano: 360</p>
                    <p>Consultas por mês: 30</p>
                    <p>valor: R$100,00</p>
                </span>
            </div>
            <div style="clear:both"></div>
        </form>
        <jsp:include page="/WEB-INF/footer.jsp" />
    </body>
</html>
