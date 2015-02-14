package guda.red.web.filter;



import guda.red.common.security.AppContext;
import guda.red.common.security.UserProfile;
import guda.red.dao.domain.TaobaoSellerDO;
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
//            if(app == null){
//                app = new AppContext();
//                UserProfile userProfile = new UserProfile();
//                userProfile.setTaobaoUserId("test");
//                TaobaoSellerDO taobaoSellerDO = new TaobaoSellerDO();
//                taobaoSellerDO.setTaobaoUserId("test");
//                taobaoSellerDO.setNick("test");
//                taobaoSellerDO.setId(1L);
//                userProfile.setTaobaoSellerDO(taobaoSellerDO);
//                app.setUserProfile(userProfile);
//                request.getSession().setAttribute(
//                        SessionConstants.APP_CONTEXT,app);
//            }
            if (app == null && needAuth(request)) {
                response.sendRedirect(getBasePath(request) + "/taobao/back.htm");
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

        if (requestURI.endsWith(".htm") || requestURI.endsWith(".json")||"/".equals(requestURI)) {
            return true;
        }

        return false;
    }

    @Override
    public void destroy() {

    }
}
