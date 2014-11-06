<%@page import="br.com.rentamultimedia.entidade.Fornecedor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>excluir fornecedor</title>
        <%@include file="include/media.jsp" %>
        <style>
            #excluirfornecedor{
                margin: 10px 10px 10px 300px;/*margens*/
            }
        </style>
         <script>
            function validaexcluirfornecedor(excluirfornecedor){
                /*coleta dados da busca*/
                var codforn=excluirfornecedor.CodProduto.value;
                
                /*valida codigo fornecedor*/
                if(codforn==""){
                    alert("informe o Número do Fornecedor");
                    excluirfornecedor.CodForn.focus();
                    return false;
                }
            }
        </script>
    </head>
    <body>
         <div id="all">
            <div id="menu_excluifornecedor">
                <%@include file="include/menu.jsp" %>
            </div>
            <div id="conteudo">
                 <div id="excluirfornecedor">
                     <form action="ConsultaExcluirFornecedor.do" method="POST" name="excluirfornecedor" onsubmit="return validaexcluirfornecedor(this)">
                        Número do Produto:<input type="text" name="CodForn"/>
                        <input type="submit" value="buscar"/><br/><br/>
                    </form>
                     <%
                     Fornecedor forn;
                     forn=(Fornecedor)request.getAttribute("fornecedor");
                     if(forn!=null){
                     %>
                    <table border="1">
                        <tr>
                            <th>Número do Fornecedor</th>    
                            <th>Razão Social</th>
                            <th>CNPJ</th>
                            <th>Telefone</th>
                            <th>Endereço</th>
                            <th>Inscrição Estadual</th>
                            <th>Excluir</th>
                        </tr>
                        <tr>
                            <td><%=forn.getCodForn()%></td>
                            <td><%=forn.getRazaoForn()%></td>
                            <td><%=forn.getCNPJForn()%></td>
                            <td><%=forn.getTelForn()%></td>
                            <td><%=forn.getEndForn()%></td>
                            <td><%=forn.getInscriEstadForn()%></td>
                            <td><a href="ExcluirFornecedor.do?CodForn=<%=forn.getCodForn()%>" onclick="return confirm('Confirma exclusão do fornecedor?')">excluir</a></td>
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
