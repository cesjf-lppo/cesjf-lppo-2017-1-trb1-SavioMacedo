<%-- 
    Document   : index
    Created on : 03/04/2017, 13:04:02
    Author     : savio
--%>
<%@include file="/imports/head.jsp" %>
<div class="panel-heading">
    <h3 class="panel-title"><strong><i class="fa fa-plus-square"></i> Cadastrar Patrimonio</strong></h3>
</div>
<form method="post">
    <div class="panel-body">
        <fieldset>
            <legend>Cadastro</legend>
            <div class="form-group">
                <input type="number" name="serie" id="serie" class="form-control" placeholder="Numero de Serie" aria-describedby="sizing-addon2">
            </div>
            <div class="form-group">
                <input type="text" name="local" id="local" class="form-control" placeholder="Local" aria-describedby="sizing-addon2">
            </div>
            <div class="form-group">
                <label for="selecao">Estado:</label>
                <select class="form-control" name="selecao" id="selecao">
                  <option value="0">Novo</option>
                  <option value="1">Em Uso</option>
                  <option value="2">Danificado</option>
                  <option value="3">Perdido</option>
                </select>
            </div>
            <div class="form-group">
                <label for="descricao">Descrição:</label>
                <textarea class="form-control" rows="5" id="descricao" name="descricao"></textarea>
             </div>
        </fieldset>
    </div>
    <div class="panel-footer">
        <div class="pull-right">
            <button type="submit" class="btn btn-success"><i class="fa fa-plus-circle"></i> Cadastrar</button>
        </div>
        <div class="clearfix"></div>
    </div>
</form>
<%@include file="/imports/footer.jsp" %>