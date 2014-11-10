<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.rentamultimedia.entidade.Funcionario" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>alterar funcionario</title>
        <%@include file="include/media.jsp" %>
        <style>
            #alterarfuncionario{
                border-style: solid;/*estilo da borda*/
                border-width: 1px;/*espessura da borda*/
                border-radius: 10px;/*arredondar borda*/
                width: 500px;/*largura*/
                height: 230px;/*altura*/
                padding: 40px 10px 10px 90px;/*espaço interno ate a borda*/
                margin: 10px 10px 10px 440px;/*margens*/
            }
            
            #numerodofuncionario{
                margin: 10px 10px 10px 440px;/*margens*/
            }
        </style>
        <script>
            function validaconsultafuncionario(consultafuncionario){
                /*coleta dados da busca*/
                var codfunc=consultafuncionario.CodFunc.value;
                
                /*valida consulta*/
                if(codfunc==""){
                    alert("informe o Número do Funcionário");
                    consultafuncionario.CodFunc.focus();
                    return false;
                }
            }
            
            function validaalterarfuncionario(alterarfuncionario){
                
                /*coleta em variaveis todos dados do formulario*/
                var nomfunc=alterarfuncionario.NomFunc.value;
                var cpffuncionario=alterarfuncionario.CPFFuncionario.value;
                var telfuncionario=alterarfuncionario.TelFuncionario.value;
                var rgfuncionario=alterarfuncionario.RGFuncionario.value;
                var idadefunc=alterarfuncionario.IdadeFunc.value;
                var loginfunc=alterarfuncionario.LoginFunc.value;
                var senhafunc=alterarfuncionario.SenhaFunc.value;
                var perfilfunc=alterarfuncionario.PerfilFunc.value;
                
                /*valida nome*/
                if(nomfunc==""){
                    alert("o campo Nome esta vazio");
                    alterarfuncionario.NomFunc.focus();
                    return false;
                }
                if(nomfunc.length>50){
                    alert("voce digitou um Nome maior que 50 caracteres");
                    alterarfuncionario.NomFunc.focus();
                    return false;
                }
                
                /*valida CPF*/
                if(cpffuncionario==""){
                    alert("o campo CPF esta vazio");
                    alterarfuncionario.CPFFuncionario.focus();
                    return false;
                }
                      
                if(cpffuncionario.length>11){
                    alert("voce digitou um CPF maior que 11 digitos");
                    alterarfuncionario.CPFFuncionario.focus();
                    return false;
                }
                if(cpffuncionario.length<11){
                    alert("voce digitou um CPF menor que 11 digitos");
                    alterarfuncionario.CPFFuncionario.focus();
                    return false;
                }
                
                /*valida Telefone*/
                if(telfuncionario==""){
                    alert("o campo Telefone esta vazio");
                    alterarfuncionario.TelFuncionario.focus();
                    return false;
                }
                if(telfuncionario.length>12){
                    alert("voce digitou um Telefone maior que 12 digitos");
                    alterarfuncionario.TelFuncionario.focus();
                    return false;
                }
                if(telfuncionario.length<12){
                    alert("voce digitou um Telefone menor que 12 digitos");
                    alterarfuncionario.TelFuncionario.focus();
                    return false;
                }
                
                /*valida rg*/
                if(rgfuncionario==""){
                    alert("o campo RG esta vazio");
                    alterarfuncionario.RGFuncionario.focus();
                    return false;
                }
                if(rgfuncionario.length>9){
                    alert("voce digitou um RG maior que 9 digitos");
                    alterarfuncionario.RGFuncionario.focus();
                    return false;
                }
                if(rgfuncionario.length<9){
                    alert("voce digitou um RG menor que 9 digitos");
                    alterarfuncionario.RGFuncionario.focus();
                    return false;
                }
                
                /*valida idade*/
                if(idadefunc==""){
                    alert("o campo Idade esta vazio");
                    alterarfuncionario.IdadeFunc.focus();
                    return false;
                }
                if(idadefunc.length>2){
                    alert("voce digitou Idade maior que 2 digitos");
                    alterarfuncionario.IdadeFunc.focus();
                    return false;
                }
                if(idadefunc.length<2){
                    alert("voce digitou Idade menor que 2 digitos");
                    alterarfuncionario.IdadeFunc.focus();
                    return false;
                }
                
                /*valida login*/
                 if(loginfunc==""){
                    alert("o campo Login esta vazio");
                    alterarfuncionario.LoginFunc.focus();
                    return false;
                }
                if(loginfunc.length>30){
                    alert("voce digitou Login maior que 30 caracteres");
                    alterarfuncionario.LoginFunc.focus();
                    return false;
                }
                
                /*valida senha*/
                if(senhafunc==""){
                    alert("o campo Senha esta vazio");
                    alterarfuncionario.SenhaFunc.focus();
                    return false;
                }
                if(senhafunc.length>30){
                    alert("voce digitou Senha maior que 30 caracteres");
                    alterarfuncionario.SenhaFunc.focus();
                    return false;
                }
                
                /*valida perfil*/
                if(perfilfunc=="--Selecione o Perfil--"){
                    alert("selecione um perfil");
                    alterarfuncionario.PerfilFunc.focus();
                    return false;
                }
                
                /*confirma alterar*/
                if(confirm('confirma alteracao do funcionario?')){
                    //document.alterarfuncionario.submit();
                }else{
                 alterarfuncionario.NomFunc.focus();
                return false;   
                }
            }  
        </script>
    </head>
    <body>
        <div id="all">
            <div id="menu_alterarfuncionario">
                <%@include file="include/menu.jsp" %>
            </div>
            <!--testeee-->
            <div id="conteudo">
                <div id="numerodofuncionario">
                    <form action="ConsultaAlterarFuncionario.do" method="POST" name="consultafuncionario" onsubmit="return validaconsultafuncionario(this)">
                        Número do Funcionário:<input type="text" name="CodFunc"/>
                        <input type="submit" value="buscar"/><br/><br/>
                    </form>
                </div>
                <%
                Funcionario func;
                func=(Funcionario)request.getAttribute("funcionario");
                if(func!=null){
                %>
                <div id="alterarfuncionario">
                    <form action="AlterarFuncionario.do" method="POST" name="alterarfuncionario" onsubmit="return validaalterarfuncionario(this)">
                        Número do Funcionário:<%=func.getCodFunc()%><br/><br/>
                        <input type="hidden" name="CodFunc" value="<%=func.getCodFunc()%>"/>
                        Nome:<input type="text" name="NomFunc" value="<%=func.getNomFunc()%>"/>CPF:<input type="text" name="CPFFuncionario" value="<%=func.getCPFFuncionario()%>"/><br/><br/> 
                        Telefone:<input type="text" name="TelFuncionario" value="<%=func.getTelFuncionario()%>"/>RG:<input type="text" name="RGFuncionario" value="<%=func.getRGFuncionario()%>"/><br/><br/>
                        Idade:<input type="text" name="IdadeFunc" value="<%=func.getIdadeFunc()%>"/>Login:<input type="text" name="LoginFunc" value="<%=func.getLoginFunc()%>"/><br/><br/>
                        Senha:<input type="password" name="SenhaFunc"/> 
                        Perfil:<select name="PerfilFunc">
                        <option>--Selecione o Perfil--</option>
                        <option value="1"<%
                                          if(func.getPerfilFunc()==1){
                                          %>
                                          selected
                                          <%
                                          }
                                         %>>Gerente</option>
                        <option value="2"<%
                                         if(func.getPerfilFunc()==2){
                                         %>
                                         selected
                                         <%
                                         }
                                         %>>Vendedor</option>
                        </select><br/><br/>
                        <input type="submit" value="Alterar"/>
                    </form>
                </div>
                <%
                }
                %>
            </div>
        </div>
    </body>
</html>
