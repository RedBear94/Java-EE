package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FirstServlet implements Servlet {
    private static final Logger logger = LoggerFactory.getLogger(FirstServlet.class);

    private ServletConfig config;

    private List<String> sharedList = new CopyOnWriteArrayList<>(); // потокобезопасная коллекция (т.к. service - может вызываться из разных потоков)

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        logger.info("Servlet initialized");
        this.config = config;
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        logger.info("New Request");

        sharedList.add("data");

        servletResponse.getWriter().println("<h1>Hello from Servlet!!!</h1>");
        servletResponse.getWriter().println("<h1>Привет!!!</h1>");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
