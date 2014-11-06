<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>consultar locacao</title>
        <%@include file="include/media.jsp"%>
        <style>
            #consultarcliente{
                border-style: solid;/*estilo da borda*/
                border-width: 1px;/*espessura da borda*/
                border-radius: 10px;/*arredondar borda*/
                width: 880px;/*largura*/
                height: 95px;/*altura*/
                margin: 10px 10px 10px 70px;/*margens*/
                padding: 10px 10px 10px 10px;/**/
            }
            #listalocacao{
                border-style: solid;/*estilo da borda*/
                border-width: 1px;/*espessura da borda*/
                border-radius: 10px;/*arredondar borda*/
                width: 880px;/*largura*/
                height: 400px;/*altura*/
                margin: 10px 10px 10px 70px;/*margens*/
                padding: 10px 10px 10px 10px;/**/
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
                    <form action="" method="post">
                        Número do Cliente:<input type="text" name="id"/>
                        <input type="submit" value="buscar"/>
                    </form>
                    <br/>
                    <table border="1">
                        <tr>
                        <th>Nome</th>
                        <th>CPF</th>
                        <th>CNPJ</th>
                        <th>RG</th>
                        <th>Tel</th>
                        <th>Endereço</th>
                        <th>Locação</th>
                        </tr>
                        <tr>
                        <td>Andre</td>
                        <td>366.741.985-01</td>
                        <td>10.446.587/0001-25</td>
                        <td>047.868.125-1</td>
                        <td>5668-7452</td>     
                        <td>Rua Maria de Jesus, 28</td>
                        <td><a href="#">incluir</a></td>
                        </tr>
                    </table>
                </div>
                <br/><br/>
                <div id="listalocacao">
                    <table border="1">
                        <tr>
                        <th>Equipamento</th>
                        <th>Quantidade</th>
                        <th>Data Locação</th>
                        <th>Data Devolução</th>
                        <th>Valor</th>
                        <th>Tipo de Pagamento</th>
                        <th>Excluir</th>
                        </tr>
                        <tr>
                        <td>Projetor</td>
                        <td>2</td>
                        <td>28/09/2014</td>
                        <td>29/09/2014</td>
                        <td>R$ 300,00</td>
                        <td>A Vista</td>
                        <td><a href="#">excluir</a></td>
                        </tr>
                        <tr>
                        <td>TV</td>
                        <td>1</td>
                        <td>25/09/2014</td>
                        <td>30/09/2014</td>
                        <td>R$ 900,00</td>
                        <td>Cartão de Débito</td>
                        <td><a href="#">excluir</a></td>
                        </tr>
                    </table>
                </div>
            </div>
        </div> 
    </body>
</html>
