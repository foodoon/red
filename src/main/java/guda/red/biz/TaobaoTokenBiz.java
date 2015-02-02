package guda.red.biz;

import guda.red.dao.domain.TaobaoTokenDO;
import guda.tools.web.page.BaseQuery;
import guda.tools.web.page.BizResult;

public interface TaobaoTokenBiz {

        BizResult detail(long id);

        BizResult list(BaseQuery baseQuery);

        BizResult delete(long id);

        BizResult create(TaobaoTokenDO taobaoTokenDO);

        BizResult update(TaobaoTokenDO taobaoTokenDO);

}
