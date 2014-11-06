<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>cadastrar fornecedor</title>
        <%@include file="include/media.jsp"%>
        <style>
            #cadastrarfornecedor{
                border-style: solid;/*estilo da borda*/
                border-width: 1px;/*espessura da borda*/
                border-radius: 10px;/*arredondar borda*/
                width: 500px;/*largura*/
                height: 240px;/*altura*/
                padding: 40px 10px 10px 90px;/*espaço interno ate a borda*/
                margin: 10px 10px 10px 440px;/*margens*/
            }
        </style>
        <script>
            function validacadastrarfornecedor(cadastrarfornecedor){
                
                /*coleta em variaveis todos dados do formulario*/
                var razaoforn=cadastrarfornecedor.RazaoForn.value;
                var cnpjforn=cadastrarfornecedor.CNPJForn.value;
                var telforn=cadastrarfornecedor.TelForn.value;
                var endforn=cadastrarfornecedor.EndForn.value;
                var inscriestadforn=cadastrarfornecedor.InscriEstadForn.value;
            
                /*valida razao social*/
                if(razaoforn==""){
                    alert("o campo Razão Social esta vazio");
                    cadastrarfornecedor.RazaoForn.focus();
                    return false;
                }
                if(razaoforn.length>50){
                    alert('voce digitou uma Razão Social maior que 50 caracteres');
                    cadastrarfornecedor.RazaoForn.focus();
                    return false;
                }
                
                /*valida cnpj*/
                if(cnpjforn==""){
                    alert('o campo CNPJ esta vazio');
                    cadastrarfornecedor.CNPJForn.focus();
                    return false;
                }
                if(cnpjforn.length>14){
                    alert('voce digitou um CNPJ maior que 14 digitos');
                    cadastrarfornecedor.CNPJForn.focus();
                    return false;
                }
                if(cnpjforn.length<14){
                    alert('voce digitou um CNPJ menor que 14 digitos');
                    cadastrarfornecedor.CNPJForn.focus();
                    return false;
                }
                
                 /*valida telefone*/
                if(telforn==""){
                    alert('o campo Telefone esta vazio');
                    cadastrarfornecedor.TelForn.focus();
                    return false;
                }
                if(telforn.length>12){
                    alert('voce digitou um Telefone maior que 12 digitos');
                    cadastrarfornecedor.TelForn.focus();
                    return false;
                }
                if(telforn.length<12){
                    alert('voce digitou um Telefone menor que 12 digitos');
                    cadastrarfornecedor.TelForn.focus();
                    return false;
                }
                
                /*valida endereco*/
                if(endforn==""){
                    alert('o campo Endereço esta vazio');
                    cadastrarfornecedor.EndForn.focus();
                    return false;
                }
                if(endforn.length>50){
                    alert('voce digitou um Endereço maior que 50 caracteres');
                    cadastrarfornecedor.EndForn.focus();
                    return false;
                }
                
                /*valida inscricao estadual*/
                if(inscriestadforn==""){
                    alert('o campo Inscrição Estadual esta vazio');
                    cadastrarfornecedor.InscriEstadForn.focus();
                    return false;
                }
                 if(inscriestadforn.length>20){
                    alert('voce digitou uma Inscrição Estadual maior que 20 caracteres');
                    cadastrarfornecedor.InscriEstadForn.focus();
                    return false;
                 }
                 
                  /*confirma cadastro*/
                if(confirm('confirma o cadastro do fornecedor?')){
                    //document.cadastrarfornecedor.submit();
                }else{
                    cadastrarfornecedor.RazaoForn.focus();
                    return false;
                }
            }
        </script>
    </head>
    <body>
        <div id="all">
            <div id="menu_cadastrarfornecedor">
                <%@include file="include/menu.jsp"%>
            </div>
            <div id="conteudo">
                <div id="cadastrarfornecedor">
                    <form action="CadastrarFornecedor.do" method="POST" name="cadastrarfornecedor" onsubmit="return validacadastrarfornecedor(this)">
                        Razão Social:<input type="text" name="RazaoForn"/><br/><br/>
                        CNPJ: <input type="text" name="CNPJForn"/><br/><br/>
                        Telefone: <input type="text" name="TelForn"/><br/><br/>
                        Endereço: <input type="text" name="EndForn"/><br/><br/>
                        Inscrição Estadual: <input type="text" name="InscriEstadForn"/><br/><br/>
                        <input type="submit" value="Cadastrar"/>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
