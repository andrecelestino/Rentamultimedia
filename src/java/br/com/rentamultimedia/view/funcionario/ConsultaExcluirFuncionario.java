package br.com.rentamultimedia.view.funcionario;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.rentamultimedia.dao.FuncionarioJpaController;
import br.com.rentamultimedia.dao.emf.Factory;
import br.com.rentamultimedia.entidade.Funcionario;

@WebServlet(name = "ConsultaExcluirFuncionario", urlPatterns = {"/ConsultaExcluirFuncionario.do"})
public class ConsultaExcluirFuncionario extends HttpServlet {
    private FuncionarioJpaController fjc;
    private Factory factory;
    private Funcionario f;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Consulta Excluir Funcionario</title>");
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet ConsultaExcluirFuncionario at " + request.getContextPath() + "</h1>");
            factory = new Factory();
            fjc = new FuncionarioJpaController(factory.getFactory());
            f = fjc.findFuncionario(Integer.parseInt(request.getParameter("CodFunc")));
            if(f!=null){
            request.setAttribute("funcionario", f);
            request.getRequestDispatcher("excluirfuncionario.jsp").forward(request, response);
            }else{
                System.out.println("[FUNCIONARIO NAO EXISTE]");
                out.println("<script>");
                out.println("alert(\"Funcionario nao encontrado\");");
                out.println("window.location.href = \"excluirfuncionario.jsp\";");
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
