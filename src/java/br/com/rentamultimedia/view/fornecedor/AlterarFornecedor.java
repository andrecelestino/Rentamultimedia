package br.com.rentamultimedia.view.fornecedor;

import br.com.rentamultimedia.dao.FornecedorJpaController;
import br.com.rentamultimedia.dao.emf.Factory;
import br.com.rentamultimedia.dao.exception.RollbackFailureException;
import br.com.rentamultimedia.entidade.Fornecedor;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AlterarFornecedor", urlPatterns = {"/AlterarFornecedor.do"})
public class AlterarFornecedor extends HttpServlet {
    private Fornecedor f;
    private Factory factory;
    private FornecedorJpaController fjc;
    private BigInteger inscriestadforn = BigInteger.valueOf(0);
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Alterar Fornecedor</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet AlterarFornecedor at " + request.getContextPath() + "</h1>");
            f=new Fornecedor();
            f.setCodForn(Integer.parseInt(request.getParameter("CodForn")));
            f.setRazaoForn(request.getParameter("RazaoForn"));
            f.setCNPJForn(request.getParameter("CNPJForn"));
            f.setTelForn(Long.parseLong(request.getParameter("TelForn")));
            f.setEndForn(request.getParameter("EndForn"));
            inscriestadforn = inscriestadforn.add(new BigInteger(request.getParameter("InscriEstadForn")));
            f.setInscriEstadForn(inscriestadforn);
            factory=new Factory();
            fjc=new FornecedorJpaController(factory.getFactory());
            try {
                fjc.edit(f);
            } catch (RollbackFailureException ex) {
                Logger.getLogger(AlterarFornecedor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(AlterarFornecedor.class.getName()).log(Level.SEVERE, null, ex);
            }
            out.println("<script>");
            out.println("alert(\"Fornecedor "+f.getCodForn()+" Alterado\");");
            out.println("window.location.href = \"alterarfornecedor.jsp\";");
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
