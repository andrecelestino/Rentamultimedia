<%@page import="br.com.rentamultimedia.entidade.Fornecedor"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>listar fornecedor</title>
        <%@include file="include/media.jsp"%>
        <style>
            #listarfornecedor{
                margin: 10px 10px 10px 330px;/*margens*/
            }
        </style>
    </head>
    <body>
        <div id="all">
            <div id="menu_listarfornecedor">
                <%@include file="include/menu.jsp"%>
            </div>
            <div id="conteudo">
                <div id="listarfornecedor">
                        <%
                            List<Fornecedor> listaf;
                            listaf=(List<Fornecedor>)request.getAttribute("listaf");
                            if(listaf!=null){  
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
                        <%
                            for(int i=0;i<listaf.size();i++){
                            Fornecedor forn;
                            forn=listaf.get(i);
                        %>
                         <tr>
                            <td><%=forn.getCodForn()%></td>
                            <td><%=forn.getRazaoForn()%></td>
                            <td><%=forn.getCNPJForn()%></td>
                            <td><%=forn.getTelForn()%></td>
                            <td><%=forn.getEndForn()%></td>
                            <td><%=forn.getInscriEstadForn()%></td>
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
