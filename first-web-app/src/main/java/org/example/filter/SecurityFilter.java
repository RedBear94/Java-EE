package org.example.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/admin/*")
public class SecurityFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(SecurityFilter.class);

    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("Security filter");

        if (servletRequest.getParameter("username") != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            filterConfig.getServletContext().getRequestDispatcher("/access_denied").forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
