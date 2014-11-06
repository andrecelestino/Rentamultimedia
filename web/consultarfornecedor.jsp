<%@page import="br.com.rentamultimedia.entidade.Fornecedor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>consultar fornecedor</title>
        <%@include file="include/media.jsp" %>
         <style>
            #consultarfornecedor{
                margin: 10px 10px 10px 340px;/*margens*/
            }
        </style>
        <script>
            function validaconsultafornecedor(consultafornecedor){
                /*coleta dados da busca*/
                var codforn=consultafornecedor.CodForn.value;
                
                /*valida codigo produto*/
                if(codforn==""){
                    alert("informe o Número do Fornecedor");
                    consultafornecedor.CodForn.focus();
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
                 <div id="consultarfornecedor">
                     <form action="ConsultaFornecedor.do" method="POST" name="consultafornecedor" onsubmit="return validaconsultafornecedor(this)">
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
                        </tr>
                        <tr>
                            <td><%=forn.getCodForn()%></td>
                            <td><%=forn.getRazaoForn()%></td>
                            <td><%=forn.getCNPJForn()%></td>
                            <td><%=forn.getTelForn()%></td>
                            <td><%=forn.getEndForn()%></td>
                            <td><%=forn.getInscriEstadForn()%></td>
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
