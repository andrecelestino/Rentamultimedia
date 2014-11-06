<%@page import="br.com.rentamultimedia.entidade.Fornecedor"%>
<%@page import="java.util.List"%>
<%@page import="br.com.rentamultimedia.dao.FornecedorJpaController"%>
<%@page import="br.com.rentamultimedia.dao.emf.Factory"%>
<%@page import="br.com.rentamultimedia.entidade.Produtofornecedor"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>alterar produto</title>
        <%@include file="include/media.jsp" %>
        <style>
            #alterarproduto{
                border-style: solid;/*estilo da borda*/
                border-width: 1px;/*espessura da borda*/
                border-radius: 10px;/*arredondar borda*/
                width: 500px;/*largura*/
                height: 350px;/*altura*/
                padding: 40px 10px 10px 90px;/*espaço interno ate a borda*/
                margin: 10px 10px 10px 440px;/*margens*/
            }
            #numerodoproduto{
                margin: 10px 10px 10px 440px;/*margens*/
            }
        </style>
        <script>
            function validaconsultaproduto(consultaproduto){
                /*coleta dados da busca*/
                var codproduto=consultaproduto.CodProduto.value;
                
                if(codproduto==""){
                    alert('informe o Número do Produto');
                    consultaproduto.CodProduto.focus();
                    return false;
                }
            }
            
            function validaalterarproduto(alterarproduto){
                
                /*coleta dados do formulario*/
                var tipoproduto=alterarproduto.TipoProduto.value;
                var marcaproduto=alterarproduto.MarcaProduto.value;
                var nomeproduto=alterarproduto.NomeProduto.value;
                var datacompra=alterarproduto.DataCompra.value;
                var nfcompra=alterarproduto.NFCompra.value;
                var quantidadeprd=alterarproduto.QuantidadePrd.value;
                var codfornfk=alterarproduto.CodFornFK.value;
                
                /*valida tipo produto*/
                if(tipoproduto==""){
                    alert('o campo Tipo de Produto esta vazio');
                    alterarproduto.TipoProduto.focus();
                    return false;
                }
                if(tipoproduto.length>20){
                    alert('voce digitou o Tipo de Produto maior que 20 caracteres');
                    alterarproduto.TipoProduto.focus();
                    return false;
                }
                
                /*valida marca*/
                if(marcaproduto==""){
                    alert('o campo Marca esta vazio');
                    alterarproduto.MarcaProduto.focus();
                    return false;
                }
                if(marcaproduto.length>30){
                    alert('voce digitou a Marca maior que 30 caracteres');
                    alterarproduto.MarcaProduto.focus();
                    return false;
                }
                
                /*valida nome*/
                if(nomeproduto==""){
                    alert('o campo Nome esta vazio');
                    alterarproduto.NomeProduto.focus();
                    return false;
                }
                if(nomeproduto.length>30){
                    alert('voce digitou o Nome maior que 30 caracteres');
                    alterarproduto.NomeProduto.focus();
                    return false;
                }
                
                /*valida data de compra*/
                if(datacompra==""){
                    alert('o campo Data de Compra esta vazio');
                    alterarproduto.DataCompra.focus();
                    return false;
                }
                
                /*valida nr nota fiscal*/
                if(nfcompra==""){
                    alert('o campo Nr Nota Fiscal esta vazio');
                    alterarproduto.NFCompra.focus();
                    return false;
                }
                if(nfcompra.length>20){
                    alert('voce digitou o Nr Nota Fiscal maior que 20 caracteres');
                    alterarproduto.NFCompra.focus();
                    return false;
                }
                
                   /*valida quantidade*/
                if(quantidadeprd==""){
                    alert('o campo Quantidade esta vazio');
                    alterarproduto.QuantidadePrd.focus();
                    return false;
                }
                if(quantidadeprd.length>20){
                    alert('voce digitou a Quantidade maior que 20 caracteres');
                    alterarproduto.QuantidadePrd.focus();
                    return false;
                }
                
                /*valida fornecedor*/
                if(codfornfk=="--Selecione o Fornecedor--"){
                    alert('selecione um fornecedor');
                    alterarproduto.CodFornFK.focus();
                    return false;
                }
                                
                /*confirma cadastro*/
                 if(confirm('confirma o alteracao do produto?')){
                    //document.cadastrarproduto.submit();
                }else{
                    alterarproduto.TipoProduto.focus();
                return false;
                }
            }
        </script>
    </head>
    <body>
        <div id="all">
            <div id="menu_alterarproduto">
                <%@include file="include/menu.jsp" %>
            </div>
            <div id="conteudo">
                <div id="numerodoproduto">
                    <form action="ConsultaAlterarProduto.do" method="POST" name="consultaproduto" onsubmit="return validaconsultaproduto(this)">
                        Número do Produto:<input type="text" name="CodProduto"/>
                        <input type="submit" value="buscar"/>
                    </form>
                </div>
                <%
                    Produtofornecedor pf;
                    pf=(Produtofornecedor)request.getAttribute("pf");
                    if(pf!=null){
                %>
                <div id="alterarproduto">
                    <form action="AlterarProduto.do" method="POST" name="alterarproduto" onsubmit="return validaalterarproduto(this)">
                        Número do Produto:<%=pf.getCodPrdForn()%><br/><br/>
                        <input type="hidden" value="<%=pf.getCodPrdForn()%>" name="CodPrdForn"/>
                        Tipo de Produto: <input type="text" value="<%=pf.getProduto().getTipoProduto()%>" name="TipoProduto"/><br/><br/>
                        Marca: <input type="text" value="<%=pf.getProduto().getMarcaProduto()%>" name="MarcaProduto"/><br/><br/>
                        Nome: <input type="text" value="<%=pf.getProduto().getNomeProduto()%>" name="NomeProduto"/><br/><br/>
                        <%
                        Date d=pf.getProduto().getDataCompra();
                        SimpleDateFormat formatar = new SimpleDateFormat("yyyy-MM-dd");
                        %>
                        Data de Compra: <input value="<%=formatar.format(d)%>" type="date" name="DataCompra"/><br/><br/>
                        Nr Nota Fiscal: <input value="<%=pf.getProduto().getNFCompra()%>" type="text" name="NFCompra"/><br/><br/>
                        Quantidade: <input type="text" value="<%=pf.getQuantidadePrd()%>" name="QuantidadePrd"/><br/><br/>
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
                        <%
                        if(pf.getCodFornFK()==forn.getCodForn()){
                        %>
                        <option value="<%=forn.getCodForn()%>" selected=""><%=forn.getRazaoForn()%></option>
                        <%
                        }else{
                        %>
                        <option value="<%=forn.getCodForn()%>"><%=forn.getRazaoForn()%></option>
                        <%
                            }
                            }
                            }
                        %>
                        </select><br/><br/>
                        <input type="submit" value="alterar"/> 
                    </form>
                </div> 
                <%
                    }
                %>
            </div>
        </div>
    </body>
</html>
