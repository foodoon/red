//package guda.red.biz.taobao;
//
//import com.alibaba.fastjson.JSON;
//import com.taobao.api.internal.util.WebUtils;
//
//import guda.red.web.common.constans.SessionConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//@Controller
//public class TaobaoCallAction {
//
//    private Logger             logger         = LoggerFactory.getLogger(TaobaoCallAction.class);
//
//    @Autowired
//    private TaobaoUserBiz taobaoUserBiz;
//    @Autowired
//   private TaobaoAPIConfig taobaoAPIConfig;
//
//
//
//    @RequestMapping(value = "/taobaoCall.htm", method = RequestMethod.GET)
//    public String doGet(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
//        Object _sessionKey = request.getSession().getAttribute(SessionConstants.TAOBAO_ACCESS_TOKEN);
//        String code = request.getParameter("code");
//        if (code == null && _sessionKey == null) {
//            try {
//                response.sendRedirect(taobaoAPIConfig.getDefaultUrl());
//                return null;
//            } catch (IOException e) {
//                logger.error("", e);
//            }
//        }
//        if (code != null) {
//
//            Map<String, String> param = new HashMap<String, String>();
//            param.put("grant_type", "authorization_code");
//            param.put("code", code);
//            param.put("client_id", taobaoAPIConfig.getAppKey());
//            param.put("client_secret", taobaoAPIConfig.getAppSecret());
//            param.put("redirect_uri", taobaoAPIConfig.getRedirectUri());
//            param.put("view", "web");
//            //param.put("state", state);
//            try {
//                String responseJson = WebUtils.doPost(taobaoAPIConfig.getTaobaoOauthUrl(), param, 3000, 3000);
//
//                TaobaoTokenResponse tbResponse = JSON.parseObject(responseJson,
//                        TaobaoTokenResponse.class);
//                if (logger.isInfoEnabled()) {
//                    logger.info("response:" + tbResponse);
//                }
//                if (tbResponse.getAccess_token() != null) {
//                    request.getSession().setAttribute(SessionConstants.TAOBAO_ACCESS_TOKEN,
//                        tbResponse.getAccess_token());
//                    TaobaoUserDO taobaoUserDO = taobaoUserBiz.queryByUserId(tbResponse.getTaobao_user_id());
//                    if (taobaoUserDO == null) {
//
//                        taobaoUserDO = new TaobaoUserDO();
//                        taobaoUserDO.setTaobaoUserId(tbResponse.getTaobao_user_id());
//                        taobaoUserDO.setAccessToken(tbResponse.getAccess_token());
//                        taobaoUserDO.setExpiresIn((tbResponse.getExpires_in()));
//                        taobaoUserDO.setR1ExpiresIn((tbResponse.getR1_expires_in()));
//                        taobaoUserDO.setR2ExpiresIn(tbResponse.getR2_expires_in());
//                        taobaoUserDO.setTaobaoUserNick(tbResponse.getTaobao_user_nick());
//                        taobaoUserDO.setTokenType(tbResponse.getToken_type());
//                        taobaoUserDO.setW1ExpiresIn(tbResponse.getW1_expires_in());
//                        taobaoUserDO.setW2ExpiresIn(tbResponse.getW2_expires_in());
//
//
//                        taobaoUserBiz.create(taobaoUserDO);
//
//                    } else {
//                        taobaoUserDO.setAccessToken(tbResponse.getAccess_token());
//                        taobaoUserDO.setExpiresIn((tbResponse.getExpires_in()));
//                        taobaoUserDO.setR1ExpiresIn((tbResponse.getR1_expires_in()));
//                        taobaoUserDO.setR2ExpiresIn(tbResponse.getR2_expires_in());
//                        taobaoUserDO.setTaobaoUserNick(tbResponse.getTaobao_user_nick());
//                        taobaoUserDO.setTokenType(tbResponse.getToken_type());
//                        taobaoUserDO.setW1ExpiresIn(tbResponse.getW1_expires_in());
//                        taobaoUserDO.setW2ExpiresIn(tbResponse.getW2_expires_in());
//                        taobaoUserBiz.update(taobaoUserDO);
//                    }
//
//                    UserDO userDO = new UserDO();
//                    userDO.setUserType(UserTypeEnum.SELLER.getValue());
//                    userDO.setLoginName(taobaoUserDO.getTaobaoUserId());
//                    AppContext appContext = new AppContext();
//                    appContext.setUserDO(userDO);
//                    AppContexHolder.setContext(appContext);
//                    request.getSession().setAttribute(SessionConstants.APP_CONTEXT, appContext);
//
//                } else {
//                    if (logger.isInfoEnabled()) {
//                        logger.info("返回access token为空:" + tbResponse);
//                    }
//                    modelMap.addAttribute("tips", "请求淘宝返回错误,请联系管理员");
//                    return "taobao/callError.vm";
//                }
//            } catch (IOException e) {
//                logger.error("", e);
//            }
//
//        }
//        return "tb/taobaoCall.vm";
//
//    }
//
//
//
//}
