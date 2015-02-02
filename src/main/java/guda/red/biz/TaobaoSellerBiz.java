package guda.red.biz;

import guda.red.dao.domain.TaobaoSellerDO;
import guda.tools.web.page.BaseQuery;
import guda.tools.web.page.BizResult;

public interface TaobaoSellerBiz {

        BizResult detail(long id);

        BizResult list(BaseQuery baseQuery);

        BizResult delete(long id);

        BizResult create(TaobaoSellerDO taobaoSellerDO);

        BizResult update(TaobaoSellerDO taobaoSellerDO);

}
