package guda.red.common.util;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by foodoon on 2015/2/5.
 */
public class RequestHelper {

    public static  String getBasePath(HttpServletRequest request) {
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort()
                + path;
        return basePath;
    }
}
