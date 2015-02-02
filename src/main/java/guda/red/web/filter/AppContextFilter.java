package guda.red.web.filter;



import guda.red.common.security.AppContexHolder;
import guda.red.common.security.AppContext;
import guda.red.web.common.constans.SessionConstants;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by foodoon on 2014/12/21.
 */
public class AppContextFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (request instanceof HttpServletRequest) {
            HttpServletRequest req = (HttpServletRequest) request;
            AppContext appContex = (AppContext) req.getSession().getAttribute(SessionConstants.APP_CONTEXT);
            AppContexHolder.setContext(appContex);
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
