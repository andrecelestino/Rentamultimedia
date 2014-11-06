<%@page import="br.com.rentamultimedia.entidade.Funcionario"%>
<script type="text/javascript">
        $(function() {
          if ($.browser.msie && $.browser.version.substr(0,1)<7)
          {
			$('li').has('ul').mouseover(function(){
				$(this).children('ul').show();
				}).mouseout(function(){
				$(this).children('ul').hide();
				}); 
          }
        });        
    </script>
<style>

/* Menu Principal */
#menu
{
	width: 900px;/**/
        height: 30px;/**/
	margin: 30px 5px 200px 280px;/**/
	padding: 10px 0 0 0;/**/
	list-style: none;/**/
	background: linear-gradient(#444, #111);/**/
	border-radius: 15px;/**/
        box-shadow: 0 2px 1px #9c9c9c;/**/
}

#menu li
{
	float: left;/**/
	padding: 0 0 10px 0;/**/
	position: relative;/**/
	line-height: 0;/**/
}

#menu a 
{
	float: left;/**/
	height: 25px;/**/
	padding: 0 25px;/**/
	color: #999;/**/
	text-transform: uppercase;/**/
	font: bold 12px/25px Arial, Helvetica;/**/
	text-decoration: none;/**/
	text-shadow: 0 1px 0 #000;/**/
}

#menu li:hover > a
{
	color: #fafafa;/**/
}

#menu li:hover > ul
{
	display: block;/**/
}

/* Sub-menu */

#menu ul
{
    list-style: none;/**/
    margin: 0;/**/
    padding: 0;/**/   
    display: none;/**/
    position: absolute;/**/
    top: 35px;/**/
    left: 0;/**/
    z-index: 99999;/**/    	
    background: linear-gradient(#444, #111);/**/
    box-shadow: 0 0 2px rgba(255,255,255,.5);/**/
    border-radius: 5px;/**/
}

#menu ul ul
{
  top: 0;/**/
  left: 150px;/**/
}

#menu ul li
{
    float: none;/**/
    margin: 0;/**/
    padding: 0;/**/
    display: block;/**/  
    box-shadow: 0 1px 0 #111111, 0 2px 0 #777777;/**/
}

#menu ul li:last-child
{   
    box-shadow: none;/**/ 
}

#menu ul a
{    
    padding: 10px;/**/
    height: 10px;/**/
    width: 130px;/**/
    height: auto;/**/
    line-height: 1;/**/
    display: block;/**/
    white-space: nowrap;/**/
    float: none;/**/
    text-transform: none;/**/
}

#menu ul a:hover
{
        background: #09e8d5;/**/
	background: linear-gradient(#04acec,  #0186ba);/**/
}

#menu ul li:first-child > a
{
    border-radius: 5px 5px 0 0;/**/
}

#menu ul li:first-child > a:after
{
    content: '';/**/
    position: absolute;/**/
    left: 30px;/**/
    top: -8px;/**/
    width: 0;/**/
    height: 0;/**/
    border-left: 5px solid transparent;/**/
    border-right: 5px solid transparent;/**/
    border-bottom: 8px solid #444;/**/
}

#menu ul ul li:first-child a:after
{
    left: -8px;/**/
    top: 12px;/**/
    width: 0;/**/
    height: 0;/**/
    border-left: 0;/**/	
    border-bottom: 5px solid transparent;/**/
    border-top: 5px solid transparent;/**/
    border-right: 8px solid #444;/**/
}

#menu ul li:first-child a:hover:after
{
    border-bottom-color: #04acec; /**/
}

#menu ul ul li:first-child a:hover:after
{
    border-right-color: #04acec; /**/
    border-bottom-color: transparent; /**/	
}


#menu ul li:last-child > a
{
    border-radius: 0 0 5px 5px;
}

/* Clear floated elements */
#menu:after 
{
	visibility: hidden;/**/
	display: block;/**/
	font-size: 0;/**/
	content: " ";/**/
	clear: both;/**/
	height: 0;/**/
}

#boasvindas{
    margin: 10px 10px 10px 620px;/*margens*/
}

</style>
    </head>
    <body>
        <%
            Funcionario f;
            f=(Funcionario)request.getSession().getAttribute("funcionario");
        %>
        <div id="boasvindas">
            <%
            if(f!=null){
            %>
            Olá <%=f.getNomFunc()%> - Perfil: <% 
                                                if(f.getPerfilFunc()==1){
                                                out.println("Gerente");
                                                }else{
                                                out.println("Vendedor");
                                                }
                                               %>
            <%
            }
            %>
        </div>
    <ul id="menu">
	<li><a href="home.jsp">Home</a></li>
        <%
        if(f!=null){
        %>
        <%
        if(f.getPerfilFunc()==1){
        %>
	<li>
            <a href="#">Funcionario</a>
                <ul>
                    <li>
                        <a href="cadastrarfuncionario.jsp">Cadastrar</a>
                        <a href="alterarfuncionario.jsp">Alterar</a>
                        <a href="excluirfuncionario.jsp">Excluir</a>
                        <a href="consultarfuncionario.jsp">Consultar</a>
                        <a href="ListarFuncionario.do">Listar</a>   
                    </li>
                </ul>		
	</li>
        <%
        }
        %>
        <%
        }
        %>
        <li>
            <a href="#">Cliente</a>
                <ul>
                    <li>
                        <a href="cadastrarcliente.jsp">Cadastrar</a>
                        <a href="alterarcliente.jsp">Alterar</a>
                        <a href="excluircliente.jsp">Excluir</a>
                        <a href="consultarcliente.jsp">Consultar</a>
                        <a href="ListarCliente.do">Listar</a>
                    </li>
		</ul>
	</li>
	<li>
            <a href="#">Produto</a>
                <ul>
                    <li>
                        <a href="cadastrarproduto.jsp">Cadastrar</a>
                        <a href="alterarproduto.jsp">Alterar</a>
                        <a href="excluirproduto.jsp">Excluir</a>
                        <a href="consultarproduto.jsp">Consultar</a>
                        <a href="ListarProduto.do">Listar</a>
                    </li>
		</ul>
	</li>
        <li>
            <a href="#">Fornecedor</a>
                <ul>
                    <li>
                        <a href="cadastrarfornecedor.jsp">Cadastrar</a>
                        <a href="alterarfornecedor.jsp">Alterar</a>
                        <a href="excluirfornecedor.jsp">Excluir</a>
                        <a href="consultarfornecedor.jsp">Consultar</a>
                        <a href="ListarFornecedor.do">Listar</a>
                    </li>
		</ul>
	</li>
        <li>
            <a href="#">Locação</a>
                <ul>
                    <li>
                        <a href="cadastrarlocacao.jsp">Cadastrar</a>
                        <a href="consultarlocacao.jsp">Consultar</a>
                    </li>
		</ul>
	</li>
            <li>
                <a href="LogoutFuncionario.do" onclick="return confirm('Deseja realmente sair?')">Sair</a>	
            </li>
    </ul>