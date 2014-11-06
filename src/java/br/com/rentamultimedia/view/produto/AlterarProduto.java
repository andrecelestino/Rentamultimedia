package br.com.rentamultimedia.view.produto;

import br.com.rentamultimedia.dao.ProdutofornecedorJpaController;
import br.com.rentamultimedia.dao.emf.Factory;
import br.com.rentamultimedia.entidade.Produto;
import br.com.rentamultimedia.entidade.Produtofornecedor;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AlterarProduto", urlPatterns = {"/AlterarProduto.do"})
public class AlterarProduto extends HttpServlet {
    private Factory factory;
    private Produtofornecedor pf;
    private ProdutofornecedorJpaController pfjc;
    private Produto p;
    private Date d;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Alterar Produto</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet AlterarProduto at " + request.getContextPath() + "</h1>");
            p=new Produto();
            p.setTipoProduto(request.getParameter("TipoProduto"));
            p.setMarcaProduto(request.getParameter("MarcaProduto"));
            p.setNomeProduto(request.getParameter("NomeProduto"));
            try {
                d=new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("DataCompra"));
                p.setDataCompra(d);
            } catch (ParseException ex) {
                Logger.getLogger(AlterarProduto.class.getName()).log(Level.SEVERE, null, ex);
            }
            BigInteger nfcompra = BigInteger.valueOf(0);
            nfcompra = nfcompra.add(new BigInteger(request.getParameter("NFCompra")));
            p.setNFCompra(nfcompra);
            pf=new Produtofornecedor();
            pf.setCodPrdForn(Integer.parseInt(request.getParameter("CodPrdForn")));
            pf.setCodFornFK(Integer.parseInt(request.getParameter("CodFornFK")));
            BigInteger qtd = BigInteger.valueOf(0);
            qtd = qtd.add(new BigInteger(request.getParameter("QuantidadePrd")));
            pf.setQuantidadePrd(qtd);
            pf.setProduto(p);
            factory=new Factory();
            pfjc=new ProdutofornecedorJpaController(factory.getFactory());
            pfjc.editar(pf);
            out.println("<script>");
            out.println("alert(\"Produto "+pf.getCodPrdForn()+" Alterado\");");
            out.println("window.location.href = \"alterarproduto.jsp\";");
            out.println("</script>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
