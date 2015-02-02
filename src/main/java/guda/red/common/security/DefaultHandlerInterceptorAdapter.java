package guda.red.common.security;

import com.alibaba.fastjson.JSON;
import guda.mvc.form.Form;

import guda.red.biz.vo.AjaxResponce;
import guda.red.common.util.CommonResultCode;
import guda.red.common.util.ErrorCode;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by well on 2014/12/26.
 */
public class DefaultHandlerInterceptorAdapter extends HandlerInterceptorAdapter {

    public static final String FORM_TOKEN_KEY = "_form_token";

    public static final String FORM_ERROR_VIEW = "/formError.htm";

    private String formErrorView = FORM_ERROR_VIEW;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            super.preHandle(request, response, handler);
            return true;
        }
        HandlerMethod m = (HandlerMethod) handler;
        if (m.getMethodAnnotation(Form.class) != null) {
            String token = request.getParameter(FORM_TOKEN_KEY);
            if (!StringUtils.hasText(token)) {
                returnMissError(request, response);
                return false;
            }
            Object sessionToken = request.getSession().getAttribute(
                    FORM_TOKEN_KEY);
            if (sessionToken == null || !token.equals(String.valueOf(sessionToken))) {
                returnError(request, response);
                return false;
            }
            request.getSession().removeAttribute(FORM_TOKEN_KEY);
        }
        super.preHandle(request, response, handler);
        return true;
    }



    private void returnError(HttpServletRequest request, HttpServletResponse response) {
        if (request.getRequestURI().endsWith(".json")) {
            ajaxReturn(new AjaxResponce(false, ErrorCode.getMessage(CommonResultCode.FORM_TOKEN_ERROR)), response);
            return;
        }
        try {
            response.sendRedirect(formErrorView);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void returnMissError(HttpServletRequest request, HttpServletResponse response) {
        if (request.getRequestURI().endsWith(".json")) {
            ajaxReturn(new AjaxResponce(false, ErrorCode.getMessage(CommonResultCode.FORM_TOKEN_MISS)), response);
            return;
        }
        try {
            response.sendRedirect(formErrorView);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void ajaxReturn(Object obj, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            response.setContentType("text/html;charset=UTF-8");
            out = response.getWriter();
            out.print(toJson(obj));
            out.flush();
        } catch (IOException e) {

        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    private String toJson(Object obj) {
        if (obj == null) {
            return "{}";
        } else {
            return JSON.toJSONString(obj);
        }
    }

}
