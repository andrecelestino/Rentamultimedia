package br.com.rentamultimedia.view.funcionario;

import br.com.rentamultimedia.dao.FuncionarioJpaController;
import br.com.rentamultimedia.dao.emf.Factory;
import br.com.rentamultimedia.entidade.Funcionario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListarFuncionario", urlPatterns = {"/ListarFuncionario.do"})
public class ListarFuncionario extends HttpServlet {
    private Factory factory;
    private FuncionarioJpaController fjc;
    private List<Funcionario> listaf;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Listar Funcionario</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet ListarFuncionario at " + request.getContextPath() + "</h1>");
            factory=new Factory();
            fjc=new FuncionarioJpaController(factory.getFactory());
            listaf=fjc.findFuncionarioEntities();
            if(listaf.isEmpty()){
                out.println("<script>");
                out.println("alert(\"nao ha funcionario cadastrado\");");
                out.println("window.location.href = \"listarfuncionario.jsp\";");
                out.println("</script>");
            }else{
                request.setAttribute("listaf", listaf);
                request.getRequestDispatcher("listarfuncionario.jsp").forward(request, response);
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
