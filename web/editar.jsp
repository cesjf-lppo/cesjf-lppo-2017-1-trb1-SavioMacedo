<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : index
    Created on : 03/04/2017, 13:04:02
    Author     : savio
--%>
<%@include file="/imports/head.jsp" %>
<div class="panel-heading">
    <h3 class="panel-title"><strong><i class="fa fa-list-alt"></i> Editar Patrimonio Movel</strong></h3>
</div>
<div class="panel-body">
    <form method="post">
        <div class="form-group">
            <span>Série: ${equipamentos.serie}</span>
        </div>
        <div class="form-group">
            <input class="form-control" name="local" value="${equipamentos.local}">
        </div>
        <div class="form-group">
            <select class="form-control" name="selecao" id="selecao">
                <option value="0" ${equipamentos.estado==0?"selected":""}>Novo</option>
                <option value="1" ${equipamentos.estado==1?"selected":""}>Em Uso</option>
                <option value="2" ${equipamentos.estado==2?"selected":""}>Danificado</option>
                <option value="3" ${equipamentos.estado==3?"selected":""}>Perdido</option>
            </select>
        </div>
</div>
<div class="panel-footer">
    <button type="submit" class="btn btn-success"> Salvar</button>
</div>
<%@include file="/imports/footer.jsp" %>