<%@page import="br.com.rentamultimedia.entidade.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>consultar cliente</title>
        <%@include file="include/media.jsp" %>
         <style>
            #consultarcliente{
                margin: 10px 10px 10px 350px;/*margens*/
            }
        </style>
    </head>
    <body>
       <div id="all">
            <div id="menu_consultarcliente">
                <%@include file="include/menu.jsp" %>
            </div>
            <div id="conteudo">
                <div id="consultarcliente">
                    <form action="ConsultaCliente.do" method="POST">
                        Número do Cliente:<input type="text" name="CodCliente"/>
                        <input type="submit" value="buscar"/><br/><br/>
                    </form>
                    <%
                    Cliente c;
                    c=(Cliente)request.getAttribute("cliente");
                    if(c!=null){
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
                    </table>
                    <%
                    }
                    %>
                </div>
            </div>
        </div> 
    </body>
</html>
