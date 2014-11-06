<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.rentamultimedia.entidade.Funcionario" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>excluir funcionario</title>
        <%@include file="include/media.jsp" %>
         <style>
            #excluirfuncionario{
                margin: 10px 10px 10px 440px;/*margens*/
            }
        </style>
        <script>
            function validaexcluirfuncionario(excluirfuncionario){
                /*coleta dados da busca*/
                var codfunc=excluirfuncionario.CodFunc.value;
                
                /*valida codigo funcionario*/
                if(codfunc==""){
                    alert("informe o Número do Funcionário");
                    excluirfuncionario.CodFunc.focus();
                    return false;
                }
            }
        </script>
    </head>
    <body>
        <div id="all">
            <div id="menu_excluirfuncionario">
                <%@include file="include/menu.jsp" %>
            </div>
            <div id="conteudo">
                 <div id="excluirfuncionario">
                     <form action="ConsultaExcluirFuncionario.do" method="POST" name="excluirfuncionario" onsubmit="return validaexcluirfuncionario(this)">
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
                            <th>Excluir</th>
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
                            <td><a href="ExcluirFuncionario.do?CodFunc=<%=func.getCodFunc()%>" onclick="return confirm('Confirma exclusão do funcionario?')">excluir</a></td>
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

