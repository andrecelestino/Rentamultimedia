package br.com.rentamultimedia.seguranca;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.rentamultimedia.entidade.Funcionario;
import br.com.rentamultimedia.dao.FuncionarioJpaController;
import br.com.rentamultimedia.dao.emf.Factory;

@WebServlet(name = "LoginFuncionario", urlPatterns = {"/LoginFuncionario.do"})
public class LoginFuncionario extends HttpServlet {
    private Funcionario f;
    private Factory factory;
    private Funcionario funcionario;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Login Funcionario</title>");
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet LoginFuncionario at " + request.getContextPath() + "</h1>");
            f = new Funcionario();
            f.setLoginFunc(request.getParameter("LoginFunc"));
            f.setSenhaFunc(request.getParameter("SenhaFunc"));
            factory = new Factory();
            FuncionarioJpaController fjc = new FuncionarioJpaController(factory.getFactory());
            funcionario = fjc.funcionarioExiste(f);
            if (funcionario!=null){
                request.getSession().setAttribute("funcionario", funcionario);
                request.getSession().setAttribute("logado", "SIM");
                out.println("<script>");
                out.println("window.location.href = \"home.jsp\";");
                out.println("</script>");
                }else{
                    out.println("<script>");
                    out.println("alert(\"Usuario e/ou Senha incorreto tente novamente\");");
                    out.println("window.location.href = \"login.html\";");
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
