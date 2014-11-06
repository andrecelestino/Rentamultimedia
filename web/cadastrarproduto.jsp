<%@page import="br.com.rentamultimedia.entidade.Fornecedor"%>
<%@page import="java.util.List"%>
<%@page import="br.com.rentamultimedia.dao.FornecedorJpaController"%>
<%@page import="br.com.rentamultimedia.dao.emf.Factory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>cadastrar produto</title>
        <%@include file="include/media.jsp" %>
        <style>
            #cadastrarequipamento{
                border-style: solid;/*estilo da borda*/
                border-width: 1px;/*espessura da borda*/
                border-radius: 10px;/*arredondar borda*/
                width: 500px;/*largura*/
                height: 320px;/*altura*/
                padding: 40px 10px 10px 90px;/*espaço interno ate a borda*/
                margin: 10px 10px 10px 440px;/*margens*/
            }
        </style>
        <script>
            function validacadastrarproduto(cadastrarproduto){
                
                /*coleta dados do formulario*/
                var tipoproduto=cadastrarproduto.TipoProduto.value;
                var marcaproduto=cadastrarproduto.MarcaProduto.value;
                var nomeproduto=cadastrarproduto.NomeProduto.value;
                var datacompra=cadastrarproduto.DataCompra.value;
                var nfcompra=cadastrarproduto.NFCompra.value;
                var quantidadeprd=cadastrarproduto.QuantidadePrd.value;
                var codfornfk=cadastrarproduto.CodFornFK.value;
                
                /*valida tipo produto*/
                if(tipoproduto==""){
                    alert('o campo Tipo de Produto esta vazio');
                    cadastrarproduto.TipoProduto.focus();
                    return false;
                }
                if(tipoproduto.length>20){
                    alert('voce digitou o Tipo de Produto maior que 20 caracteres');
                    cadastrarproduto.TipoProduto.focus();
                    return false;
                }
                
                /*valida marca*/
                if(marcaproduto==""){
                    alert('o campo Marca esta vazio');
                    cadastrarproduto.MarcaProduto.focus();
                    return false;
                }
                if(marcaproduto.length>30){
                    alert('voce digitou a Marca maior que 30 caracteres');
                    cadastrarproduto.MarcaProduto.focus();
                    return false;
                }
                
                /*valida nome*/
                if(nomeproduto==""){
                    alert('o campo Nome esta vazio');
                    cadastrarproduto.NomeProduto.focus();
                    return false;
                }
                if(nomeproduto.length>30){
                    alert('voce digitou o Nome maior que 30 caracteres');
                    cadastrarproduto.NomeProduto.focus();
                    return false;
                }
                
                /*valida data de compra*/
                if(datacompra==""){
                    alert('o campo Data de Compra esta vazio');
                    cadastrarproduto.DataCompra.focus();
                    return false;
                }
                
                /*valida nr nota fiscal*/
                if(nfcompra==""){
                    alert('o campo Nr Nota Fiscal esta vazio');
                    cadastrarproduto.NFCompra.focus();
                    return false;
                }
                if(nfcompra.length>20){
                    alert('voce digitou o Nr Nota Fiscal maior que 20 caracteres');
                    cadastrarproduto.NFCompra.focus();
                    return false;
                }
                
                /*valida quantidade*/
                if(quantidadeprd==""){
                    alert('o campo Quantidade esta vazio');
                    cadastrarproduto.QuantidadePrd.focus();
                    return false;
                }
                if(quantidadeprd.length>20){
                    alert('voce digitou a Quantidade maior que 20 caracteres');
                    cadastrarproduto.QuantidadePrd.focus();
                    return false;
                }
                
                /*valida fornecedor*/
                if(codfornfk=="--Selecione o Fornecedor--"){
                    alert('selecione um fornecedor');
                    cadastrarproduto.CodFornFK.focus();
                    return false;
                }
                
                /*confirma cadastro*/
                 if(confirm('confirma o cadastro do produto?')){
                    //document.cadastrarproduto.submit();
                }else{
                    cadastrarproduto.TipoProduto.focus();
                return false;
                }
            }
        </script>
    </head>
    <body>
         <div id="all">
            <div id="menu_cadastrarequipamento">
                <%@include file="include/menu.jsp" %>
            </div>
            <div id="conteudo">
                <div id="cadastrarequipamento">
                    <form action="CadastrarProduto.do" method="POST" name="cadastrarproduto" onsubmit="return validacadastrarproduto(this)">
                        Tipo de Produto: <input type="text" name="TipoProduto"/><br/><br/>
                        Marca: <input type="text" name="MarcaProduto"/><br/><br/>
                        Nome: <input type="text" name="NomeProduto"/><br/><br/>
                        Data de Compra: <input type="date" name="DataCompra"/><br/><br/>
                        Nr Nota Fiscal: <input type="text" name="NFCompra"/><br/><br/>
                        Quantidade: <input type="text" name="QuantidadePrd"/><br/><br/>
                        Fornecedor: <select name="CodFornFK">
                            <option value="--Selecione o Fornecedor--">--Selecione o Fornecedor--</option>
                        <%
                        Factory factory=new Factory();
                        FornecedorJpaController fjc=new FornecedorJpaController(factory.getFactory());
                        List<Fornecedor> listaf=fjc.findFornecedorEntities();
                        if(listaf.isEmpty()!=true){
                            for(int i=0;i<listaf.size();i++){
                                Fornecedor forn=listaf.get(i);
                        %>
                        <option value="<%=forn.getCodForn()%>"><%=forn.getRazaoForn()%></option>
                        <%
                            }
                            }
                        %>
                        </select><br/><br/>
                        <input type="submit" value="Cadastrar"/> 
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
