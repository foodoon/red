package guda.red.web.form;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import guda.red.dao.domain.TaobaoBuyerDO;

import javax.validation.constraints.NotNull;

public class MemberForm {
    @NotEmpty(message = "{不能为空}")
    private String taobaoNick;

    @NotEmpty(message = "{不能为空}")
    private String phone;

    public String getTaobaoNick() {
        return taobaoNick;
    }

    public void setTaobaoNick(String taobaoNick) {
        this.taobaoNick = taobaoNick;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public TaobaoBuyerDO toDO() {
        TaobaoBuyerDO taobaoBuyerDO = new TaobaoBuyerDO();
        taobaoBuyerDO.setTaobaoNick(taobaoNick);
        taobaoBuyerDO.setPhone(phone);
        return taobaoBuyerDO;
    }

}
