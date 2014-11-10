package br.com.rentamultimedia.view.produto;

import br.com.rentamultimedia.dao.ProdutofornecedorJpaController;
import br.com.rentamultimedia.dao.emf.Factory;
import br.com.rentamultimedia.entidade.Produtofornecedor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListarProduto", urlPatterns = {"/ListarProduto.do"})
public class ListarProduto extends HttpServlet {
    private Factory factory;
    private ProdutofornecedorJpaController pfjc;
    private List<Produtofornecedor> listapf;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Listar Produto</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet ListarProduto at " + request.getContextPath() + "</h1>");
            factory=new Factory();
            pfjc=new ProdutofornecedorJpaController(factory.getFactory());
            listapf=pfjc.findProdutofornecedorEntities();
            if(listapf.isEmpty()){
                out.println("<script>");
                out.println("alert('nao ha produto cadastrado')");
                out.println("window.location.href = \"listarproduto.jsp\";");
                out.println("</script>");
            }else{
                request.setAttribute("listapf", listapf);
                request.getRequestDispatcher("listarproduto.jsp").forward(request, response);
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
