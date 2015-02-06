package guda.red.biz;

import guda.red.dao.domain.MsgNoticeDO;
import guda.tools.web.page.BaseQuery;
import guda.tools.web.page.BizResult;

public interface MsgNoticeBiz {

        BizResult detail(long id);

        BizResult list(BaseQuery baseQuery);

        BizResult delete(long id);

        BizResult create(MsgNoticeDO msgNoticeDO);

        BizResult update(MsgNoticeDO msgNoticeDO);

}
