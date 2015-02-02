package guda.red.biz;

import guda.red.dao.domain.AccountDO;
import guda.tools.web.page.BaseQuery;
import guda.tools.web.page.BizResult;

public interface AccountBiz {

        BizResult detail(long id);

        BizResult list(BaseQuery baseQuery);

        BizResult delete(long id);

        BizResult create(AccountDO accountDO);

        BizResult update(AccountDO accountDO);

}
