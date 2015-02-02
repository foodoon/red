package guda.red.web.action;

import guda.tools.web.util.RequestUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by foodoon on 2014/12/20.
 */
@Controller
public class BlankAction {

    @RequestMapping(value = "**/*.htm", method = RequestMethod.GET)
    public String list(HttpServletRequest request, ModelMap modelMap) {
        return RequestUtil.resolveVM(request);
    }
}
