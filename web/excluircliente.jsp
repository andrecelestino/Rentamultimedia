<%@page import="br.com.rentamultimedia.entidade.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>excluir cliente</title>
        <%@include file="include/media.jsp" %>
        <style>
            #excluircliente{
                margin: 10px 10px 10px 350px;/*margens*/
            }
        </style>
        <script>
            function validaconsultacliente(consultacliente){
                /*coleta dados dos formulario*/
                var codcliente=consultacliente.CodCliente.value;
                
                if(codcliente==""){
                    alert('informe o Número do Cliente');
                    consultacliente.CodCliente.focus();
                    return false;
                }
            }            
        </script>
    </head>
    <body>
        <div id="all">
            <div id="menu_excluircliente">
                <%@include file="include/menu.jsp" %>
            </div>
            <div id="conteudo">
                <div id="excluircliente">
                    <form action="ConsultaExcluirCliente.do" method="POST" name="consultacliente" onsubmit="return validaconsultacliente(this)">
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
                            <th>Excluir</th>
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
                            <td><a href="ExcluirCliente.do?CodCliente=<%=c.getCodCliente()%>" onclick="return confirm('Confirma exclusão do Cliente?')">excluir</a></td>
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
