<%@page import="br.com.rentamultimedia.entidade.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>alterar cliente</title>
        <%@include file="include/media.jsp" %>
        <style>
            #alterarcliente{
                border-style: solid;/*estilo da borda*/
                border-width: 1px;/*espessura da borda*/
                border-radius: 10px;/*arredondar borda*/
                width: 350px;/*largura*/
                height: 280px;/*altura*/
                padding: 40px 10px 10px 90px;/*espaço interno ate a borda*/
                margin: 10px 10px 10px 440px;/*margens*/
            }
            
            #numerodocliente{
                margin: 10px 10px 10px 440px;/*margens*/
            }
        </style>
        <script>
            function validaconsultacliente(consultacliente){
                /*coleta dados da busca*/
                var codcliente=consultacliente.CodCliente.value;
                
                /*valida consulta*/
                if(codcliente==""){
                    alert("informe o Número do Cliente");
                    consultacliente.CodCliente.focus();
                    return false;
                }
            }
                
            function validaalterarcliente(alterarcliente){
                    
                /*coleta em variaveis todos dados do formulario*/
                var tipocliente=alterarcliente.TipoCliente.value;
                var nomecliente=alterarcliente.NomeCliente.value;
                var telcliente=alterarcliente.TelCliente.value;
                var endcliente=alterarcliente.EndCliente.value;
                    
                /*valida nome*/
                if(nomecliente==""){
                    alert("o campo Nome esta vazio");
                    alterarcliente.NomeCliente.focus();
                    return false;
                }
                if(nomecliente.length>50){
                    alert('voce digitou um Nome maior que 50 caracteres');
                    alterarcliente.NomeCliente.focus();
                    return false;
                }
                
                /*valida telefone*/
                if(telcliente==""){
                    alert('o campo Telefone esta vazio');
                    alterarcliente.TelCliente.focus();
                    return false;
                }
                if(telcliente.length>12){
                    alert('voce digitou um Telefone maior que 12 digitos');
                    alterarcliente.TelCliente.focus();
                    return false;
                }
                if(telcliente.length<12){
                    alert('voce digitou um Telefone menor que 12 digitos');
                    alterarcliente.TelCliente.focus();
                    return false;
                }
                
                /*valida endereco*/
                if(endcliente==""){
                    alert('o campo Endereco esta vazio');
                    alterarcliente.EndCliente.focus();
                    return false;
                }
                if(endcliente.length>50){
                    alert('voce digitou um Endereco maior que 50 caracteres');
                    alterarcliente.EndCliente.focus();
                    return false;
                }
                
                if(tipocliente=="fisica"){
                    
                    var cpfcliente=alterarcliente.CPFCliente.value;
                    var rgcliente=alterarcliente.RGCliente.value;
                    
                    /*valida cpf*/
                    if(cpfcliente==""){
                        alert('o campo CPF esta vazio');
                        alterarcliente.CPFCliente.focus();
                        return false;
                    }
                    if(cpfcliente.length>11){
                        alert('voce digitou um CPF maior que 11 digitos');
                        alterarcliente.CPFCliente.focus();
                        return false;
                    }
                    if(cpfcliente.length<11){
                        alert('voce digitou um CPF menor que 11 digitos');
                        alterarcliente.CPFCliente.focus();
                        return false;
                    }
                    
                    /*valida rg*/
                    if(rgcliente==""){
                        alert('o campo RG esta vazio');
                        alterarcliente.RGCliente.focus();
                        return false;
                    }
                    if(rgcliente.length>9){
                        alert('voce digitou um RG maior que 9 digitos');
                        alterarcliente.RGCliente.focus();
                        return false;
                    }
                    if(rgcliente.length<9){
                        alert('voce digitou um RG menor que 9 digitos');
                        alterarcliente.RGCliente.focus();
                        return false;
                    }
                }
                
                if(tipocliente=="juridica"){
                    
                    var cnpjcliente=alterarcliente.CNPJCliente.value;
                     
                    /*valida cnpj*/
                    if(cnpjcliente==""){
                        alert('o campo CNPJ esta vazio');
                        alterarcliente.CNPJCliente.focus();
                        return false;
                    }
                    if(cnpjcliente.length>14){
                        alert('voce digitou um CNPJ maior que 14 digitos');
                        alterarcliente.CNPJCliente.focus();
                        return false;
                    }
                    if(cnpjcliente.length<14){
                        alert('voce digitou um CNPJ menor que 14 digitos');
                        alterarcliente.CNPJCliente.focus();
                        return false;
                    }
                }       

                /*confirma cadastro*/
                if(confirm('confirma alteracao do cliente?')){
                    //document.cadastrarcliente.submit();
                }else{
                    alterarcliente.NomeCliente.focus();
                    return false;
                }        
            }
        </script>
    </head>
    <body>
        <!--Yuri teste-->
        <div id="all">
            <div id="menu_alterarcliente">
                <%@include file="include/menu.jsp" %>
            </div>
            <div id="conteudo">
                <div id="numerodocliente">
                    <form action="ConsultaAlterarCliente.do" method="POST" name="consultacliente" onsubmit="return validaconsultacliente(this)">
                        Número do Cliente:<input type="text" name="CodCliente"/>
                        <input type="submit" value="buscar"/>
                    </form>
                </div>
                <%
                Cliente c;
                c=(Cliente)request.getAttribute("cliente");
                if(c!=null){
                %>
                <div id="alterarcliente">
                    <form action="AlterarCliente.do" method="POST" name="alterarcliente" onsubmit="return validaalterarcliente(this)">
                        <input type="hidden" name="CodCliente" value="<%=c.getCodCliente()%>"/>
                        Número do Cliente:<%=c.getCodCliente()%><br/><br/>
                        Nome: <input type="text" value="<%=c.getNomeCliente()%>" name="NomeCliente"/><br/><br/>
                        Tel: <input type="text" value="<%=c.getTelCliente()%>" name="TelCliente"/><br/><br/>
                        Endereco: <input type="text" value="<%=c.getEndCliente()%>" name="EndCliente"/><br/><br/>
                        <input type="hidden" value="<%=c.getTipocliente().getTipoCliente()%>" name="TipoCliente"/>
                        <%
                        if(c.getTipocliente().getTipoCliente().contentEquals("juridica")){
                        %> 
                        CNPJ <input type="text" value="<%=c.getTipocliente().getCNPJCliente()%>" name="CNPJCliente"/><br/><br/>
                        <%
                        }else{
                        %>
                        CPF: <input type="text" value="<%=c.getCPFCliente()%>" name="CPFCliente"/><br/><br/>
                        RG: <input type="text" value="<%=c.getRGCliente()%>" name="RGCliente"/><br/><br/>
                        <%
                        }
                        %>
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
