<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>cadastrar funcionario</title>
        <%@include file="include/media.jsp"%>
        <style>
            #cadastrarfuncionario{
                border-style: solid;/*estilo da borda*/
                border-width: 1px;/*espessura da borda*/
                border-radius: 10px;/*arredondar borda*/
                width: 500px;/*largura*/
                height: 200px;/*altura*/
                padding: 40px 10px 10px 90px;/*espaço interno ate a borda*/
                margin: 10px 10px 10px 440px;/*margens*/
            }
        </style>
        <script>
            function validacadastrarfuncionario(cadastrarfuncionario){
                
                /*coleta em variaveis todos dados do formulario*/
                var nomfunc=cadastrarfuncionario.NomFunc.value;
                var cpffuncionario=cadastrarfuncionario.CPFFuncionario.value;
                var telfuncionario=cadastrarfuncionario.TelFuncionario.value;
                var rgfuncionario=cadastrarfuncionario.RGFuncionario.value;
                var idadefunc=cadastrarfuncionario.IdadeFunc.value;
                var loginfunc=cadastrarfuncionario.LoginFunc.value;
                var senhafunc=cadastrarfuncionario.SenhaFunc.value;
                var perfilfunc=cadastrarfuncionario.PerfilFunc.value;
                
                /*valida nome*/
                if(nomfunc==""){
                    alert("o campo Nome esta vazio");
                    cadastrarfuncionario.NomFunc.focus();
                    return false;
                }
                if(nomfunc.length>50){
                    alert("voce digitou um Nome maior que 50 caracteres");
                    cadastrarfuncionario.NomFunc.focus();
                    return false;
                }
                
                /*valida CPF*/
                if(cpffuncionario==""){
                    alert("o campo CPF esta vazio");
                    cadastrarfuncionario.CPFFuncionario.focus();
                    return false;
                }
                      
                if(cpffuncionario.length>11){
                    alert("voce digitou um CPF maior que 11 digitos");
                    cadastrarfuncionario.CPFFuncionario.focus();
                    return false;
                }
                if(cpffuncionario.length<11){
                    alert("voce digitou um CPF menor que 11 digitos");
                    cadastrarfuncionario.CPFFuncionario.focus();
                    return false;
                }
                
                /*valida Telefone*/
                if(telfuncionario==""){
                    alert("o campo Telefone esta vazio");
                    cadastrarfuncionario.TelFuncionario.focus();
                    return false;
                }
                if(telfuncionario.length>12){
                    alert("voce digitou um Telefone maior que 12 digitos");
                    cadastrarfuncionario.TelFuncionario.focus();
                    return false;
                }
                if(telfuncionario.length<12){
                    alert("voce digitou um Telefone menor que 12 digitos");
                    cadastrarfuncionario.TelFuncionario.focus();
                    return false;
                }
                
                /*valida rg*/
                if(rgfuncionario==""){
                    alert("o campo RG esta vazio");
                    cadastrarfuncionario.RGFuncionario.focus();
                    return false;
                }
                if(rgfuncionario.length>9){
                    alert("voce digitou um RG maior que 9 digitos");
                    cadastrarfuncionario.RGFuncionario.focus();
                    return false;
                }
                if(rgfuncionario.length<9){
                    alert("voce digitou um RG menor que 9 digitos");
                    cadastrarfuncionario.RGFuncionario.focus();
                    return false;
                }
                
                /*valida idade*/
                if(idadefunc==""){
                    alert("o campo Idade esta vazio");
                    cadastrarfuncionario.IdadeFunc.focus();
                    return false;
                }
                if(idadefunc.length>2){
                    alert("voce digitou Idade maior que 2 digitos");
                    cadastrarfuncionario.IdadeFunc.focus();
                    return false;
                }
                if(idadefunc.length<2){
                    alert("voce digitou Idade menor que 2 digitos");
                    cadastrarfuncionario.IdadeFunc.focus();
                    return false;
                }
                
                /*valida login*/
                 if(loginfunc==""){
                    alert("o campo Login esta vazio");
                    cadastrarfuncionario.LoginFunc.focus();
                    return false;
                }
                if(loginfunc.length>30){
                    alert("voce digitou Login maior que 30 caracteres");
                    cadastrarfuncionario.LoginFunc.focus();
                    return false;
                }
                
                /*valida senha*/
                if(senhafunc==""){
                    alert("o campo Senha esta vazio");
                    cadastrarfuncionario.SenhaFunc.focus();
                    return false;
                }
                if(senhafunc.length>30){
                    alert("voce digitou Senha maior que 30 caracteres");
                    cadastrarfuncionario.SenhaFunc.focus();
                    return false;
                }
                
                /*valida perfil*/
                if(perfilfunc=="--Selecione o Perfil--"){
                    alert("selecione um perfil");
                    cadastrarfuncionario.PerfilFunc.focus();
                    return false;
                }
                
                /*confirma cadastro*/
                 if(confirm('confirma o cadastro do funcionario?')){
                    //document.cadastrarfuncionario.submit();
                }else{
                cadastrarfuncionario.NomFunc.focus();
                return false;
            
                }
            }
        </script>
    </head>
    <body>
        <div id="all">
            <div id="menu_cadastrarfuncionario">
                <%@include file="include/menu.jsp"%>
            </div>
            <div id="conteudo">
                <div id="cadastrarfuncionario">
                    <form action="CadastrarFuncionario.do" method="POST" name="cadastrarfuncionario" onsubmit="return validacadastrarfuncionario(this)">
                        Nome:<input type="text" name="NomFunc"/>CPF:<input type="text" name="CPFFuncionario"/><br/><br/> 
                        Telefone:<input type="text" name="TelFuncionario"/>RG:<input type="text" name="RGFuncionario"/><br/><br/>
                        Idade:<input type="text" name="IdadeFunc"/>Login:<input type="text" name="LoginFunc"/><br/><br/>
                        Senha:<input type="password" name="SenhaFunc"/> 
                        Perfil:<select name="PerfilFunc">
                        <option>--Selecione o Perfil--</option>    
                        <option value="1">Gerente</option>
                        <option value="2">Vendedor</option>
                        </select><br/><br/>
                        <input type="submit" value="Cadastrar"/>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
