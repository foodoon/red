package guda.red.biz;

import guda.red.dao.domain.TaobaoOrderDO;
import guda.tools.web.page.BaseQuery;
import guda.tools.web.page.BizResult;

public interface TaobaoOrderBiz {

        BizResult detail(long id);

        BizResult list(BaseQuery baseQuery);

        BizResult delete(long id);

        BizResult create(TaobaoOrderDO taobaoOrderDO);

        BizResult update(TaobaoOrderDO taobaoOrderDO);

}
