<%@page import="br.com.rentamultimedia.entidade.Fornecedor"%>
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
        <title>consultar produto</title>
        <%@include file="include/media.jsp" %>
        <style>
            #consultarproduto{
                margin: 10px 10px 10px 280px;/*margens*/
            }
        </style>
        <script>
            function validaconsultaproduto(consultaproduto){
                /*coleta dados da busca*/
                var codproduto=consultaproduto.CodProduto.value;
                
                /*valida codigo produto*/
                if(codproduto==""){
                    alert("informe o Número do Produto");
                    consultaproduto.CodProduto.focus();
                    return false;
                }
            }
        </script>
    </head>
    <body>
       <div id="all">
            <div id="menu_consultarproduto">
                <%@include file="include/menu.jsp" %>
            </div>
            <div id="conteudo">
                 <div id="consultarproduto">
                     <form action="ConsultaProduto.do" method="POST" name="consultaproduto" onsubmit="return validaconsultaproduto(this)">
                        Número do Equipamento:<input type="text" name="CodProduto"/>
                        <input type="submit" value="buscar"/><br/><br/>
                    </form>
                <%
                    Produtofornecedor pf;
                    pf=(Produtofornecedor)request.getAttribute("pf");
                    if(pf!=null){
                %>
                    <table border="1">
                        <tr>
                        <th>Número do Produto</th>    
                        <th>Tipo de Produto</th>
                        <th>Marca</th>
                        <th>Nome</th>
                        <th>Data de Compra</th>
                        <th>Nr Nota Fiscal</th>
                        <th>Quantidade</th>
                        <th>Fornecedor</th>
                        </tr>
                        <tr>
                        <td><%=pf.getCodPrdForn()%></td>
                        <td><%=pf.getProduto().getTipoProduto()%></td>
                        <td><%=pf.getProduto().getMarcaProduto()%></td>
                        <td><%=pf.getProduto().getNomeProduto()%></td>
                        <%
                        Date d=pf.getProduto().getDataCompra();
                        SimpleDateFormat formatar = new SimpleDateFormat("dd-MM-yyyy");
                        %>
                        <td><%=formatar.format(d)%></td>
                        <td><%=pf.getProduto().getNFCompra()%></td>
                        <td><%=pf.getQuantidadePrd()%></td>
                         <%
                        Factory factory=new Factory();
                        FornecedorJpaController fjc=new FornecedorJpaController(factory.getFactory());
                        Fornecedor forn=fjc.findFornecedor(pf.getCodFornFK());
                        %>
                        <td><%=forn.getRazaoForn()%></td>
                        </tr>
                    </table>
                    <%
                        }
                    %>
                </div>
            </div>
        </div>
    </body>
</html>
