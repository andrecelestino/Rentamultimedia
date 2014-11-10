<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>listar funcionario</title>
        <%@include file="include/media.jsp"%>
        <style>
            #listarfuncionario{
                margin: 10px 10px 10px 350px;/*margens*/
            }
        </style>
    </head>
    <body>
    <div id="all">
            <div id="menu_listarfuncionario">
                <%@include file="include/menu.jsp"%>
            </div>
            <div id="conteudo">
                <div id="listarfuncionario">
                        <%
                            List<Funcionario> listaf;
                            listaf=(List<Funcionario>)request.getAttribute("listaf");
                            if(listaf!=null){  
                        %>
                        <table border="1">
                        <tr>
                            <th>Número do Funcionário</th>
                            <th>Nome</th>
                            <th>CPF</th>
                            <th>Telefone</th>
                            <th>RG</th>
                            <th>Idade</th>
                            <th>Login</th>
                            <th>Senha</th>
                            <th>Perfil</th>
                        </tr>
                        <%
                            for(int i=0;i<listaf.size();i++){
                            Funcionario func;
                            func=listaf.get(i);
                        %>
                         <tr>
                            <td><%=func.getCodFunc()%></td>
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
                        <%
                            }
                        %>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
