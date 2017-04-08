<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : index
    Created on : 03/04/2017, 13:04:02
    Author     : savio
--%>
<%@include file="/imports/head.jsp" %>
<div class="panel-heading row">
    <div class="col-xs-4">
        <h3 class="panel-title"><strong><i class="fa fa-list-alt"></i> Patrimonio Movel</strong></h3>
    </div>
    <div class="col-xs-4"></div>
    <div class="col-xs-4">
        <select class="form-control pull-right" name="selecao" id="selecao">
            <option value="0">Novo</option>
            <option value="1">Em Uso</option>
            <option value="2">Danificado</option>
            <option value="3">Perdido</option>
        </select>
    </div>
    <div class="clearfix"></div>
</div>
<div class="panel-body">
    <table class="table">
        <tr>
            <th>#</th>
            <th>Serie</th>
            <th>Local</th>
            <th>Descrição</th>
            <th>Estado</th>
            <th></th>
        </tr>
        <c:forEach var="equipamentos" items="${equipamentos}">
            <tr>
                <td>${equipamentos.id}</td>
                <td>${equipamentos.serie}</td>
                <td>${equipamentos.local}</td>
                <td>${equipamentos.descricao}</td>
                <td>${equipamentos.estado}</td>
                <td><button onclick="editar(${equipamentos.id})" class="btn btn-warning">Editar</button> <button onclick="deletar(${equipamentos.id});" class="btn btn-danger">Excluir</button></td>
             </tr>
        </c:forEach>
    </table>
</div>
<script>
    function deletar(id)
    {
        if(confirm("Você deseja excluir?"))
        {
            window.location="Excluir?id="+id;
        }
    }
    function editar(id)
    {
        window.location="Editar?id="+id;
    }
</script>
<%@include file="/imports/footer.jsp" %>