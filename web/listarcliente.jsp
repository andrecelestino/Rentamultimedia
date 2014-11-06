<%@page import="java.util.List"%>
<%@page import="br.com.rentamultimedia.entidade.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>listar cliente</title>
        <%@include file="include/media.jsp"%>
        <style>
            #listarcliente{
                margin: 10px 10px 10px 350px;/*margens*/
            }
        </style>
    </head>
    <body>
        <div id="all">
            <div id="menu_listarcliente">
                <%@include file="include/menu.jsp" %>
            </div>
            <div id="conteudo">
                <div id="listarcliente">
                    <%
                        List<Cliente> listac;
                        listac=(List<Cliente>)request.getAttribute("listac");
                        if(listac!=null){
                    %>
                    <%
                        for(int i=0;i<listac.size();i++){
                        Cliente c;
                        c=listac.get(i);
                    %>
                    <table border="1">
                         <tr>
                            <th>Número do Cliente</th>
                            <th>Tipo Cliente</th>
                            <th>Nome</th>
                            <%
                                if(c.getTipocliente().getTipoCliente().contentEquals("fisica")){
                            %>
                            <th>CPF</th>
                            <th>RG</th>
                            <%
                                }
                            %>
                            <th>Tel</th>
                            <th>Endereco</th>
                            <%
                                if(c.getTipocliente().getTipoCliente().contentEquals("juridica")){
                            %>
                            <th>CNPJ</th>
                            <%
                                }
                            %>
                            </tr>
                            <tr>
                            <td><%=c.getCodCliente()%></td>
                            <td><%=c.getTipocliente().getTipoCliente()%></td>
                            <td><%=c.getNomeCliente()%></td>
                            <%
                                if(c.getTipocliente().getTipoCliente().contentEquals("fisica")){
                            %>
                            <td><%=c.getCPFCliente()%></td>
                            <td><%=c.getRGCliente()%></td>     
                            <%
                                }
                            %>
                            <td><%=c.getTelCliente()%></td>
                            <td><%=c.getEndCliente()%></td>
                            <%
                                if(c.getTipocliente().getTipoCliente().contentEquals("juridica")){
                            %>                            
                            <td><%=c.getTipocliente().getCNPJCliente()%></td>
                            <%
                                }
                            %>
                            </tr>
                    </table><br/>
                    <%
                        }
                    %>
                    <%
                        }
                    %>
                </div>
            </div>
        </div>
    </body>
</html>
