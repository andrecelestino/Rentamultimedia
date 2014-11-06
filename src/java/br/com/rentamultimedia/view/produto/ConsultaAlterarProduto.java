package br.com.rentamultimedia.view.produto;

import br.com.rentamultimedia.dao.ProdutofornecedorJpaController;
import br.com.rentamultimedia.dao.emf.Factory;
import br.com.rentamultimedia.entidade.Produtofornecedor;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ConsultaAlterarProduto", urlPatterns = {"/ConsultaAlterarProduto.do"})
public class ConsultaAlterarProduto extends HttpServlet {
    private Factory factory;
    private ProdutofornecedorJpaController pfjc;
    private Produtofornecedor pf;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Consulta Alterar Produto</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet ConsultaAlterarProduto at " + request.getContextPath() + "</h1>");
            factory=new Factory();
            pfjc=new ProdutofornecedorJpaController(factory.getFactory());
            pf=pfjc.findProdutofornecedor(Integer.parseInt(request.getParameter("CodProduto")));
            if(pf!=null){
                request.setAttribute("pf", pf);
                request.getRequestDispatcher("alterarproduto.jsp").forward(request, response);
            }else{
                out.println("<script>");
                out.println("alert(\"Produto nao encontrado\");");
                out.println("window.location.href = \"alterarproduto.jsp\";");
                out.println("</script>");
            }
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
