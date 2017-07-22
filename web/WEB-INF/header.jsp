<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<h1> Sistema de Marcação de Consultas da Clinica Veterinária VetPet</h1>
<c:if test="${usuario !=  null}">
    <p> Olá ${usuario}</p>
</c:if>