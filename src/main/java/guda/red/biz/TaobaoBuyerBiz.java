package guda.red.biz;

import guda.red.dao.domain.TaobaoBuyerDO;
import guda.tools.web.page.BaseQuery;
import guda.tools.web.page.BizResult;

public interface TaobaoBuyerBiz {

        BizResult detail(long id);

        BizResult list(BaseQuery baseQuery);

        BizResult delete(long id);

        BizResult create(TaobaoBuyerDO taobaoBuyerDO);

        BizResult update(TaobaoBuyerDO taobaoBuyerDO);

}
