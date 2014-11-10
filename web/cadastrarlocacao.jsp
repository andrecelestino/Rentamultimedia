<%@page import="br.com.rentamultimedia.entidade.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="br.com.rentamultimedia.dao.emf.Factory"%>
<%@page import="br.com.rentamultimedia.dao.ClienteJpaController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>cadastrar locacao</title>
        <%@include file="include/media.jsp"%>
        <style>
            #cadastrarlocacao{
                border-style: solid;/*estilo da borda*/
                border-width: 1px;/*espessura da borda*/
                border-radius: 10px;/*arredondar borda*/
                width: 500px;/*largura*/
                height: 510px;/*altura*/
                margin: 10px 10px 10px 440px;/*margens*/
                padding: 40px 10px 10px 90px;/**/
            }
        </style>
    </head>
    <body>
        <div id="all">
            <div id="menu_cadastrarlocacao">
                <%@include file="include/menu.jsp" %>
            </div>
            <div id="conteudo">
                <div id="cadastrarlocacao">
                    <form action="" method="POST">
                        Data do Pedido:<input type="date" name="DataPedido"/><br/><br/>
                        <%
                        Factory factory=new Factory();
                        ClienteJpaController cjc=new ClienteJpaController(factory.getFactory());
                        List<Cliente> listac=cjc.findClienteEntities();
                        %>
                        Cliente:<select name="CodClienteFK">
                            <option value="--Selecione um Cliente--">--Selecione um Cliente--</option>
                            <%
                            if(listac!=null){
                            for(int i=0;i<listac.size();i++){
                                Cliente c=listac.get(i);
                            %>    
                            <option value="<%=c.getCodCliente()%>">Nº<%=c.getCodCliente()%> - <%=c.getNomeCliente()%></option>
                            <%
                            }
                            }
                            %>
                                </select><br/><br/>
                        Data de Devolução:<input type="date" name="DataDevolucao"/><br/><br/>
                        Motivo da Devolução:<input type="text" name="MotivoDevolucao"/><br/><br/>
                        <%
                        Funcionario func=(Funcionario)request.getSession().getAttribute("funcionario");
                        %>
                        <input type="hidden" value="<%=func.getCodFunc()%>" name="CodFuncFK"/>
                        Valor do Pedido:<input type="text" name="ValorPed"/><br/><br/>
                        Valor de Desconto:<input type="text" name="ValorDesc"/><br/><br/>
                        Tipo de Pagamento:<select name="TipoPagto">
                        <option value="--Selecione o Tipo de Pagamento--">--Selecione o Tipo de Pagamento--</option>
                        <option value="Débito">Débito</option>
                        <option value="Crédito">Crédito</option>
                        </select><br/><br/>
                        Número da Nota Fiscal:<input type="text" name="NumNF"/><br/><br/>
                        E-mail da Nota Fiscal:<input type="text" name="EmailNF"/><br/><br/>
                        Data de Emissão da Nota Fiscal:<input type="date" name="DataEmissaoNF"/><br/><br/>
                        Desconto do Pedido:<input type="text" name="DscPedido"/><br/><br/>
                        Valor da Nota Fiscal:<input type="text" name="ValorNF"/><br/><br/>
                        Data de Entrega:<input type="date" name="DataEntrega"/><br/><br/>
                        Endereço da Entrega:<input type="text" name="EndEntrega"/><br/><br/>
                        <input type="submit" value="cadastrar"/>
                    </form>
                </div>
            </div>
        </div> 
    </body>
</html>
