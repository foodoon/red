package guda.red.common.security;

import guda.red.dao.domain.TaobaoSellerDO;

/**
 * Created by foodoon on 2015/2/3.
 */
public class UserProfile {

    private String taobaoUserId;
    private TaobaoSellerDO taobaoSellerDO;

    public TaobaoSellerDO getTaobaoSellerDO() {
        return taobaoSellerDO;
    }

    public void setTaobaoSellerDO(TaobaoSellerDO taobaoSellerDO) {
        this.taobaoSellerDO = taobaoSellerDO;
    }

    public String getTaobaoUserId() {
        return taobaoUserId;
    }

    public void setTaobaoUserId(String taobaoUserId) {
        this.taobaoUserId = taobaoUserId;
    }
}
