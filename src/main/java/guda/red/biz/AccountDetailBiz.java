package guda.red.biz;

import guda.red.dao.domain.AccountDetailDO;
import guda.tools.web.page.BaseQuery;
import guda.tools.web.page.BizResult;

public interface AccountDetailBiz {

        BizResult detail(long id);

        BizResult list(BaseQuery baseQuery);

        BizResult delete(long id);

        BizResult create(AccountDetailDO accountDetailDO);

        BizResult update(AccountDetailDO accountDetailDO);

}
