<%@page import="br.com.rentamultimedia.entidade.Fornecedor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>alterar fornecedor</title>
        <%@include file="include/media.jsp" %>
        <style>
            #alterarfornecedor{
                border-style: solid;/*estilo da borda*/
                border-width: 1px;/*espessura da borda*/
                border-radius: 10px;/*arredondar borda*/
                width: 500px;/*largura*/
                height: 280px;/*altura*/
                padding: 40px 10px 10px 90px;/*espaço interno ate a borda*/
                margin: 10px 10px 10px 440px;/*margens*/
            }
            #numerodofornecedor{
                margin: 10px 10px 10px 440px;/*margens*/
            }
        </style>
        <script>
            function validaconsultafornecedor(consultafornecedor){
                /*coleta dados da busca*/
                var codforn=consultafornecedor.CodForn.value;
                
                /*valida consulta*/
                if(codforn==""){
                    alert("informe o Número do Cliente");
                    consultafornecedor.CodForn.focus();
                    return false;
                }
            }
            
            function validaalterarfornecedor(alterarfornecedor){
                 /*coleta em variaveis todos dados do formulario*/
                var razaoforn=alterarfornecedor.RazaoForn.value;
                var cnpjforn=alterarfornecedor.CNPJForn.value;
                var telforn=alterarfornecedor.TelForn.value;
                var endforn=alterarfornecedor.EndForn.value;
                var inscriestadforn=alterarfornecedor.InscriEstadForn.value;
                
                /*valida razao social*/
                if(razaoforn==""){
                    alert("o campo Razão Social esta vazio");
                    alterarfornecedor.RazaoForn.focus();
                    return false;
                }
                if(razaoforn.length>50){
                    alert('voce digitou uma Razão Social maior que 50 caracteres');
                    alterarfornecedor.RazaoForn.focus();
                    return false;
                }
                
                /*valida cnpj*/
                if(cnpjforn==""){
                    alert('o campo CNPJ esta vazio');
                    alterarfornecedor.CNPJForn.focus();
                    return false;
                }
                if(cnpjforn.length>14){
                    alert('voce digitou um CNPJ maior que 14 digitos');
                    alterarfornecedor.CNPJForn.focus();
                    return false;
                }
                if(cnpjforn.length<14){
                    alert('voce digitou um CNPJ menor que 14 digitos');
                    alterarfornecedor.CNPJForn.focus();
                    return false;
                }
                
                 /*valida telefone*/
                if(telforn==""){
                    alert('o campo Telefone esta vazio');
                    alterarfornecedor.TelForn.focus();
                    return false;
                }
                if(telforn.length>12){
                    alert('voce digitou um Telefone maior que 12 digitos');
                    alterarfornecedor.TelForn.focus();
                    return false;
                }
                if(telforn.length<12){
                    alert('voce digitou um Telefone menor que 12 digitos');
                    alterarfornecedor.TelForn.focus();
                    return false;
                }
                
                /*valida endereco*/
                if(endforn==""){
                    alert('o campo Endereço esta vazio');
                    alterarfornecedor.EndForn.focus();
                    return false;
                }
                if(endforn.length>50){
                    alert('voce digitou um Endereço maior que 50 caracteres');
                    alterarfornecedor.EndForn.focus();
                    return false;
                }
                
                /*valida inscricao estadual*/
                if(inscriestadforn==""){
                    alert('o campo Inscrição Estadual esta vazio');
                    alterarfornecedor.InscriEstadForn.focus();
                    return false;
                }
                 if(inscriestadforn.length>20){
                    alert('voce digitou uma Inscrição Estadual maior que 20 caracteres');
                    alterarfornecedor.InscriEstadForn.focus();
                    return false;
                 }
                 
                  /*confirma cadastro*/
                if(confirm('confirma alteracao do fornecedor?')){
                    //document.alterarfornecedor.submit();
                }else{
                    alterarfornecedor.RazaoForn.focus();
                    return false;
                }   
            }  
        </script>
    </head>
    <body>
        <div id="all">
            <div id="menu_alterarproduto">
                <%@include file="include/menu.jsp" %>
            </div>
            <div id="conteudo">
                <div id="numerodofornecedor">
                    <form action="ConsultaAlterarFornecedor.do" method="POST" name="consultafornecedor" onsubmit="return validaconsultafornecedor(this)">
                        Número do Fornecedor:<input type="text" name="CodForn"/>
                        <input type="submit" value="buscar"/>
                    </form>
                </div>
                <%
                    Fornecedor forn;
                    forn=(Fornecedor)request.getAttribute("fornecedor");
                    if(forn!=null){
                %>
                <div id="alterarfornecedor">
                    <form action="AlterarFornecedor.do" method="POST" name="alterarfornecedor" onsubmit="return validaalterarfornecedor(this)">
                        Número do Fornecedor:<%=forn.getCodForn()%><br/><br/>
                        <input type="hidden" value="<%=forn.getCodForn()%>" name="CodForn"/>
                        Razão Social:<input type="text" value="<%=forn.getRazaoForn()%>" name="RazaoForn"/><br/><br/>
                        CNPJ: <input type="text" value="<%=forn.getCNPJForn()%>" name="CNPJForn"/><br/><br/>
                        Telefone: <input type="text" value="<%=forn.getTelForn()%>" name="TelForn"/><br/><br/>
                        Endereço: <input type="text" value="<%=forn.getEndForn()%>" name="EndForn"/><br/><br/>
                        Inscrição Estadual: <input type="text" value="<%=forn.getInscriEstadForn()%>" name="InscriEstadForn"/><br/><br/>
                        <input type="submit" value="alterar"/> 
                    </form>
                </div> 
                <%
                    }
                %>
            </div>
        </div>
    </body>
</html>
