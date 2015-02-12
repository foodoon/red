package guda.red.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by foodoon on 2015/2/11.
 */
public class WelcomeFilter implements Filter
{
    private String welcome;

    public void init(FilterConfig filterConfig)
    {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if(request instanceof HttpServletRequest){
            HttpServletRequest req = (HttpServletRequest)request;
            HttpServletResponse resp = (HttpServletResponse)response;
            String requestURI = req.getRequestURI();
            if("/".equals(requestURI)){
                resp.sendRedirect(getBasePath(req) + "/index.htm");
                return;
            }
        }
        chain.doFilter(request,response);
    }

    private String getBasePath(HttpServletRequest request) {
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort()
                + path;
        return basePath;
    }

    public void destroy() {}
}
