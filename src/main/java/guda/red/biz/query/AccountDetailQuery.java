package guda.red.biz.query;

import guda.tools.web.page.BaseQuery;

/**
 * Created by foodoon on 2015/2/6.
 */
public class AccountDetailQuery extends BaseQuery {

    private long accountId;

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }
}
