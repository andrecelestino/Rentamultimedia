package br.com.rentamultimedia.seguranca;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Filtrosessao implements Filter{
    HttpServletRequest httpRequest;
    HttpServletResponse httpResponse;
    String logado="logado";
    String paginadelogin="login.html";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        httpRequest=(HttpServletRequest) request;
        httpResponse=(HttpServletResponse) response;
        if(httpRequest.getSession().getAttribute(logado)=="SIM"){
            chain.doFilter(request, response);
        }else{
            httpResponse.sendRedirect(paginadelogin);
        }
    }

    @Override
    public void destroy() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
