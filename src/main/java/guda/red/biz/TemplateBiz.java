package guda.red.biz;

import guda.red.dao.domain.TemplateDO;
import guda.tools.web.page.BaseQuery;
import guda.tools.web.page.BizResult;

public interface TemplateBiz {

        BizResult detail(long id);

        BizResult list(BaseQuery baseQuery);

        BizResult delete(long id);

        BizResult create(TemplateDO templateDO);

        BizResult update(TemplateDO templateDO);

}
