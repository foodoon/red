package guda.red.web.action;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by well on 2014/11/17.
 */
public class BaseAjaxAction {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    public String toJson(Object obj) {
        if (obj == null) {
            return "{}";
        } else {
            return JSON.toJSONString(obj);
        }
    }

    public void ajaxReturn(Object obj, HttpServletResponse response) {
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

    public void ajaxReturnObj(Object obj, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            response.setContentType("text/json;charset=UTF-8");
            out = response.getWriter();
            out.print(obj);
            out.flush();
        } catch (IOException e) {

        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    public void ajaxReturnObjText(Object obj, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            response.setContentType("text/plain;charset=UTF-8");
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

    public void jsonReturn(Object obj, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            response.setContentType("text/json;charset=UTF-8");
            out = response.getWriter();
            out.print(obj);
            out.flush();
        } catch (IOException e) {

        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    public void addMsg(ModelMap modelMap, String msg) {
        modelMap.addAttribute("msg", msg);
    }

    public void addErrorMsg(ModelMap modelMap, String msg) {
        modelMap.addAttribute("errorMsg", msg);
    }

    public void addSuccessMsg(ModelMap modelMap, String msg) {
        modelMap.addAttribute("successMsg", msg);
    }
}
