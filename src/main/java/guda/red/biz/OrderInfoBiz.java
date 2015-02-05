package guda.red.biz;

import guda.red.dao.domain.OrderInfoDO;
import guda.tools.web.page.BaseQuery;
import guda.tools.web.page.BizResult;

public interface OrderInfoBiz {

        BizResult detail(long id);

        BizResult list(BaseQuery baseQuery);

        BizResult delete(long id);

        BizResult create(OrderInfoDO orderInfoDO);

        BizResult update(OrderInfoDO orderInfoDO);

}
