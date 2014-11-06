<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>consultar funcionario</title>
        <%@include file="include/media.jsp"%>
        <style>
            #consultarfuncionario{
                margin: 10px 10px 10px 440px;/*margens*/
            }
        </style>
        <script>
            function validaconsultafuncionario(consultafuncionario){
                /*coleta dados da busca*/
                var codfunc=consultafuncionario.CodFunc.value;
                
                /*valida codigo funcionario*/
                if(codfunc==""){
                    alert("informe o Número do Funcionário");
                    consultafuncionario.CodFunc.focus();
                    return false;
                }
            }
        </script>
    </head>
    <body>
       <div id="all">
            <div id="menu_consultarfuncionario">
                <%@include file="include/menu.jsp"%>
            </div>
            <div id="conteudo">
                <div id="consultarfuncionario">
                    <form action="ConsultaFuncionario.do" method="POST" name="consultafuncionario" onsubmit="return  validaconsultafuncionario(this)">
                        Número do Funcionário:<input type="text" name="CodFunc"/>
                        <input type="submit" value="buscar"/><br/><br/>
                    </form>
                    <%
                        Funcionario func=(Funcionario)request.getAttribute("funcionario");
                        if(func!=null){
                    %>
                    <table border="1">
                        <tr>
                            <th>Nome</th>
                            <th>CPF</th>
                            <th>Telefone</th>
                            <th>RG</th>
                            <th>Idade</th>
                            <th>Login</th>
                            <th>Senha</th>
                            <th>Perfil</th>
                        </tr>
                        <tr>
                            <td><%=func.getNomFunc()%></td>
                            <td><%=func.getCPFFuncionario()%></td>
                            <td><%=func.getTelFuncionario()%></td>
                            <td><%=func.getRGFuncionario()%></td>
                            <td><%=func.getIdadeFunc()%></td>
                            <td><%=func.getLoginFunc()%></td>
                            <td><%=func.getSenhaFunc()%></td>
                            <td><%
                                if(func.getPerfilFunc()==1){
                                %>
                                Gerente
                                <%
                                }
                                %>
                                <%
                                if(func.getPerfilFunc()==2){
                                %>
                                Vendedor
                                <%
                                }
                                %>
                            </td>
                        </tr>    
                    <%
                    }
                    %>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
