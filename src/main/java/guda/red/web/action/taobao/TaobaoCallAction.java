package guda.red.web.action.taobao;

import com.alibaba.fastjson.JSON;
import com.taobao.api.internal.util.WebUtils;
import guda.red.biz.taobao.TaobaoAPIConfig;
import guda.red.biz.taobao.TaobaoTokenResponse;
import guda.red.common.security.AppContexHolder;
import guda.red.common.security.AppContext;
import guda.red.common.security.UserProfile;
import guda.red.dao.AccountDOMapper;
import guda.red.dao.TaobaoSellerDOMapper;
import guda.red.dao.TaobaoTokenDOMapper;
import guda.red.dao.domain.*;
import guda.red.web.common.constans.SessionConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TaobaoCallAction {

    private Logger logger = LoggerFactory.getLogger(TaobaoCallAction.class);

    @Autowired
    private TaobaoTokenDOMapper taobaoTokenDOMapper;
    @Autowired
    private TaobaoAPIConfig taobaoAPIConfig;
    @Autowired
    private TaobaoSellerDOMapper taobaoSellerDOMapper;
    @Autowired
    private AccountDOMapper accountDOMapper;

    @RequestMapping(value = "/taobao/back.htm", method = RequestMethod.GET)
    public String doGet(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
        Object _sessionKey = request.getSession().getAttribute(SessionConstants.TAOBAO_ACCESS_TOKEN);
        if(_sessionKey!=null){
            //TODO 校验token是否有效
            try {
                response.sendRedirect(getBasePath(request));
                return null;
            }catch (Exception e){
                logger.error("",e);
            }
        }
        String code = request.getParameter("code");
        if (code == null && _sessionKey == null) {
            try {
                StringBuilder buf = new StringBuilder();
                buf.append(taobaoAPIConfig.getTaobaoOauthUrl());
                buf.append("?client_id=").append(taobaoAPIConfig.getAppKey())
                        .append("&response_type=code&redirect_uri=").append(getBasePath(request)).append("/taobao/back.htm");
                response.sendRedirect(buf.toString());
                return null;
            } catch (IOException e) {
                logger.error("", e);
            }
        }
        if (code != null) {

            Map<String, String> param = new HashMap<String, String>();
            param.put("grant_type", "authorization_code");
            param.put("code", code);
            param.put("client_id", taobaoAPIConfig.getAppKey());
            param.put("client_secret", taobaoAPIConfig.getAppSecret());
            param.put("redirect_uri", taobaoAPIConfig.getRedirectUri());
            param.put("view", "web");
            //param.put("state", state);
            try {
                String responseJson = WebUtils.doPost(taobaoAPIConfig.getTaokenUri(), param, 3000, 3000);
                if (logger.isInfoEnabled()) {
                    logger.info("response:" + responseJson);
                }
                TaobaoTokenResponse tbResponse = JSON.parseObject(responseJson,
                        TaobaoTokenResponse.class);

                if (tbResponse.getAccess_token() != null) {
                    request.getSession().setAttribute(SessionConstants.TAOBAO_ACCESS_TOKEN,
                            tbResponse.getAccess_token());
                    TaobaoTokenDOCriteria taobaoTokenDOCriteria = new TaobaoTokenDOCriteria();
                    taobaoTokenDOCriteria.createCriteria().andTaobaoUserIdEqualTo(tbResponse.getTaobao_user_id());
                    List<TaobaoTokenDO> taobaoTokenDOs = taobaoTokenDOMapper.selectByExample(taobaoTokenDOCriteria);
                    TaobaoTokenDO taobaoTokenDO = new TaobaoTokenDO();
                    if (taobaoTokenDOs.size() == 0) {
                        taobaoTokenDO.setTaobaoUserId(tbResponse.getTaobao_user_id());
                        taobaoTokenDO.setAccessToken(tbResponse.getAccess_token());
                        taobaoTokenDO.setExpiresIn((tbResponse.getExpires_in()));
                        taobaoTokenDO.setR1ExpiresIn((tbResponse.getR1_expires_in()));
                        taobaoTokenDO.setR2ExpiresIn(tbResponse.getR2_expires_in());
                        taobaoTokenDO.setTaobaoUserNick(tbResponse.getTaobao_user_nick());
                        taobaoTokenDO.setTokenType(tbResponse.getToken_type());
                        taobaoTokenDO.setW1ExpiresIn(tbResponse.getW1_expires_in());
                        taobaoTokenDO.setW2ExpiresIn(tbResponse.getW2_expires_in());
                        taobaoTokenDOMapper.insert(taobaoTokenDO);
                    } else {
                        taobaoTokenDO = taobaoTokenDOs.get(0);
                        taobaoTokenDO.setAccessToken(tbResponse.getAccess_token());
                        taobaoTokenDO.setExpiresIn((tbResponse.getExpires_in()));
                        taobaoTokenDO.setR1ExpiresIn((tbResponse.getR1_expires_in()));
                        taobaoTokenDO.setR2ExpiresIn(tbResponse.getR2_expires_in());
                        taobaoTokenDO.setTaobaoUserNick(tbResponse.getTaobao_user_nick());
                        taobaoTokenDO.setTokenType(tbResponse.getToken_type());
                        taobaoTokenDO.setW1ExpiresIn(tbResponse.getW1_expires_in());
                        taobaoTokenDO.setW2ExpiresIn(tbResponse.getW2_expires_in());
                        taobaoTokenDO.setTaobaoUserId(tbResponse.getTaobao_user_id());
                        taobaoTokenDOMapper.updateByPrimaryKeySelective(taobaoTokenDO);
                    }

                    UserProfile userProfile = new UserProfile();
                    userProfile.setTaobaoUserId(taobaoTokenDO.getTaobaoUserId());
                    AppContext appContext = new AppContext();
                    appContext.setUserProfile(userProfile);
                    AppContexHolder.setContext(appContext);
                    TaobaoSellerDOCriteria taobaoSellerDOCriteria = new TaobaoSellerDOCriteria();
                    taobaoSellerDOCriteria.createCriteria().andTaobaoUserIdEqualTo(taobaoTokenDO.getTaobaoUserId());
                    List<TaobaoSellerDO> taobaoSellerDOs = taobaoSellerDOMapper.selectByExample(taobaoSellerDOCriteria);
                    if (taobaoSellerDOs.size() == 0) {
                        TaobaoSellerDO taobaoSellerDO = new TaobaoSellerDO();
                        taobaoSellerDO.setGmtCreated(new Date());
                        taobaoSellerDO.setNick(taobaoTokenDO.getTaobaoUserNick());
                        taobaoSellerDO.setTaobaoUserId(taobaoTokenDO.getTaobaoUserId());
                        taobaoSellerDOMapper.insert(taobaoSellerDO);
                        AccountDO accountDO = new AccountDO();
                        accountDO.setAmount(0L);
                        accountDO.setFreeze(0L);
                        accountDO.setGmtModified(new Date());
                        accountDO.setTaobaoSellerId(taobaoSellerDO.getId());
                        accountDOMapper.insert(accountDO);
                        userProfile.setTaobaoSellerDO(taobaoSellerDO);
                    }else{
                        userProfile.setTaobaoSellerDO(taobaoSellerDOs.get(0));
                    }

                    request.getSession().setAttribute(SessionConstants.APP_CONTEXT, appContext);
                    response.sendRedirect(getBasePath(request));
                    return null;

                } else {
                    if (logger.isInfoEnabled()) {
                        logger.info("返回access token为空:" + tbResponse);
                    }
                    modelMap.addAttribute("errorMsg", "请求淘宝返回错误,请联系管理员");
                    return "taobao/error.vm";
                }
            } catch (Exception e) {
                modelMap.addAttribute("errorMsg",e.getMessage());
                logger.error("", e);
            }

        }
        return "taobao/error.vm";

    }

    private String getBasePath(HttpServletRequest request){
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort()
                + path;
        return basePath;
    }


}
