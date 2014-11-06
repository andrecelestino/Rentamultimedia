<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>cadastrar cliente</title>
        <%@include file="include/media.jsp" %>
        <style>
            #cadastrarcliente{
                border-style: solid;/*estilo da borda*/
                border-width: 1px;/*espessura da borda*/
                border-radius: 10px;/*arredondar borda*/
                width: 350px;/*largura*/
                height: 280px;/*altura*/
                padding: 40px 10px 10px 90px;/*espaço interno ate a borda*/
                margin: 10px 10px 10px 440px;/*margens*/
            }
            
            #tipodecliente{
                margin: 10px 10px 10px 530px;/*margens*/
            }
        </style>
        <script>
            
            /*renderiza formulario conforme tipo de cliente*/
            function tipodecliente(){
                if(document.getElementById('juridica').checked){
                   document.getElementById('formcadastrarcliente').style.display = "";
                   document.getElementById('camposjuridica').style.display = "";
                   document.getElementById('camposfisica').style.display = "none";
                   document.getElementById('TipoCliente').value = "juridica";
                   document.getElementById('NomeCliente').focus();
                }
                 if(document.getElementById('fisica').checked){
                   document.getElementById('formcadastrarcliente').style.display = "";
                   document.getElementById('camposfisica').style.display = "";
                   document.getElementById('camposjuridica').style.display = "none";
                   document.getElementById('TipoCliente').value = "fisica";
                   document.getElementById('NomeCliente').focus();
                }
            }
            
            /*valida campos*/
            function validacadastrarcliente(cadastrarcliente){
                
                /*coleta em variaveis todos dados do formulario*/
                var tipocliente=cadastrarcliente.TipoCliente.value;
                var nomecliente=cadastrarcliente.NomeCliente.value;
                var cpfcliente=cadastrarcliente.CPFCliente.value;
                var rgcliente=cadastrarcliente.RGCliente.value;
                var telcliente=cadastrarcliente.TelCliente.value;
                var endcliente=cadastrarcliente.EndCliente.value;
                var cnpjcliente=cadastrarcliente.CNPJCliente.value;
                
                /*valida nome*/
                if(nomecliente==""){
                    alert("o campo Nome esta vazio");
                    cadastrarcliente.NomeCliente.focus();
                    return false;
                }
                if(nomecliente.length>50){
                    alert('voce digitou um Nome maior que 50 caracteres');
                    cadastrarcliente.NomeCliente.focus();
                    return false;
                }
                
                /*valida telefone*/
                if(telcliente==""){
                    alert('o campo Telefone esta vazio');
                    cadastrarcliente.TelCliente.focus();
                    return false;
                }
                if(telcliente.length>12){
                    alert('voce digitou um Telefone maior que 12 digitos');
                    cadastrarcliente.TelCliente.focus();
                    return false;
                }
                if(telcliente.length<12){
                    alert('voce digitou um Telefone menor que 12 digitos');
                    cadastrarcliente.TelCliente.focus();
                    return false;
                }
                
                /*valida endereco*/
                if(endcliente==""){
                    alert('o campo Endereco esta vazio');
                    cadastrarcliente.EndCliente.focus();
                    return false;
                }
                if(endcliente.length>50){
                    alert('voce digitou um Endereco maior que 50 caracteres');
                    cadastrarcliente.EndCliente.focus();
                    return false;
                }
                
                /*valida cpf*/
                if(tipocliente=="fisica" && cpfcliente==""){
                    alert('o campo CPF esta vazio');
                    cadastrarcliente.CPFCliente.focus();
                    return false;
                }
                if(tipocliente=="fisica" && cpfcliente.length>11){
                    alert('voce digitou um CPF maior que 11 digitos');
                    cadastrarcliente.CPFCliente.focus();
                    return false;
                }
                if(tipocliente=="fisica" && cpfcliente.length<11){
                    alert('voce digitou um CPF menor que 11 digitos');
                    cadastrarcliente.CPFCliente.focus();
                    return false;
                }
                
                /*valida rg*/
                if(tipocliente=="fisica" && rgcliente==""){
                    alert('o campo RG esta vazio');
                    cadastrarcliente.RGCliente.focus();
                    return false;
                }
                if(tipocliente=="fisica" && rgcliente.length>9){
                    alert('voce digitou um RG maior que 9 digitos');
                    cadastrarcliente.RGCliente.focus();
                    return false;
                }
                if(tipocliente=="fisica" && rgcliente.length<9){
                    alert('voce digitou um RG menor que 9 digitos');
                    cadastrarcliente.RGCliente.focus();
                    return false;
                }
                
                /*valida cnpj*/
                if(tipocliente=="juridica" && cnpjcliente==""){
                    alert('o campo CNPJ esta vazio');
                    cadastrarcliente.CNPJCliente.focus();
                    return false;
                }
                if(tipocliente=="juridica" && cnpjcliente.length>14){
                    alert('voce digitou um CNPJ maior que 14 digitos');
                    cadastrarcliente.CNPJCliente.focus();
                    return false;
                }
                if(tipocliente=="juridica" && cnpjcliente.length<14){
                    alert('voce digitou um CNPJ menor que 14 digitos');
                    cadastrarcliente.CNPJCliente.focus();
                    return false;
                }
                
                /*confirma cadastro*/
                if(confirm('confirma o cadastro do cliente?')){
                    //document.cadastrarcliente.submit();
                }else{
                    cadastrarcliente.NomeCliente.focus();
                    return false;
                }
                
            }
        </script>
    </head>
    <body>
         <div id="all">
            <div id="menu_cadastrarcliente">
                <%@include file="include/menu.jsp" %>
            </div>
            <div id="conteudo">
                <div id="tipodecliente">
                    Tipo de Cliente: <input name="tipodecliente" id="fisica" type="radio" value="fisica" onclick="tipodecliente()"/>Fisica
                                     <input name="tipodecliente" id="juridica" type="radio" value="juridica" onclick="tipodecliente()"/>Juridica
                </div>
                <div id="cadastrarcliente">
                    <form action="CadastrarCliente.do" method="POST" name="cadastrarcliente" id="formcadastrarcliente" style="display: none" onsubmit="return validacadastrarcliente(this)">
                        <input type="hidden" name="TipoCliente" id="TipoCliente"/>
                        Nome: <input type="text" name="NomeCliente" id="NomeCliente"/><br/><br/>
                        <label id="camposfisica" style="display: none">
                        CPF: <input type="text" name="CPFCliente"/><br/><br/>
                        RG: <input type="text" name="RGCliente"/><br/><br/>
                        </label>
                        Tel: <input type="text" name="TelCliente"/><br/><br/>
                        Endereco: <input type="text" name="EndCliente"/><br/><br/>
                        <label id="camposjuridica" style="display: none">
                        CNPJ:<input type="text" name="CNPJCliente"/><br/><br/>
                        </label>
                        <input type="submit" value="Cadastrar"/> 
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
