package guda.red.biz;

import guda.red.dao.domain.MsgOutDO;
import guda.tools.web.page.BaseQuery;
import guda.tools.web.page.BizResult;

public interface MsgOutBiz {

        BizResult detail(long id);

        BizResult list(BaseQuery baseQuery);

        BizResult delete(long id);

        BizResult create(MsgOutDO msgOutDO);

        BizResult update(MsgOutDO msgOutDO);

}
