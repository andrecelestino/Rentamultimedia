<%@page import="br.com.rentamultimedia.entidade.Fornecedor"%>
<%@page import="br.com.rentamultimedia.dao.FornecedorJpaController"%>
<%@page import="br.com.rentamultimedia.dao.emf.Factory"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="br.com.rentamultimedia.entidade.Produtofornecedor"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>listar produto</title>
        <%@include file="include/media.jsp"%>
        <style>
            #listarproduto{
                margin: 10px 10px 10px 280px;/*margens*/
            }
        </style>
    </head>
    <body>
        <div id="all">
            <div id="menu_listarfuncionario">
                <%@include file="include/menu.jsp"%>
            </div>
            <div id="conteudo">
                <div id="listarproduto">
                        <%
                            List<Produtofornecedor> listapf;
                            listapf=(List<Produtofornecedor>)request.getAttribute("listapf");
                            if(listapf!=null){  
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
                        <%
                            for(int i=0;i<listapf.size();i++){
                            Produtofornecedor pf;
                            pf=listapf.get(i);
                        %>
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
                        <%    
                            }
                        %>
                        <%
                            }
                        %>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
