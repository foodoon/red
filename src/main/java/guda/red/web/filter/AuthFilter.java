package guda.red.web.filter;



import guda.red.common.security.AppContext;
import guda.red.web.common.constans.SessionConstants;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by foodoon on 2014/12/20.
 */
public class AuthFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {
        if (servletRequest instanceof HttpServletRequest) {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            AppContext app = (AppContext) request.getSession().getAttribute(
                    SessionConstants.APP_CONTEXT);
            if (app == null && needAuth(request)) {
                response.sendRedirect(getBasePath(request) + "/login.htm");
                return;
            }
        }
        chain.doFilter(servletRequest, servletResponse);
    }



    private String getBasePath(HttpServletRequest request){
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort()
                + path;
        return basePath;
    }

    private boolean needAuth(HttpServletRequest request) {

        String requestURI = request.getRequestURI();

        if (!requestURI.endsWith(".htm") && !requestURI.endsWith(".json")) {
            return false;
        }

        return requestURI.lastIndexOf("/") > 0;
    }

    @Override
    public void destroy() {

    }
}
