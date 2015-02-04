package guda.red.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MsgOutDOCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int startRow = -1;

    protected int pageSize = -1;

    public MsgOutDOCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setStartRow(int startRow) {
        this.startRow=startRow;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setPageSize(int pageSize) {
        this.pageSize=pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTaobaoSellerIdIsNull() {
            addCriterion("taobao_seller_id is null");
            return (Criteria) this;
        }

        public Criteria andTaobaoSellerIdIsNotNull() {
            addCriterion("taobao_seller_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaobaoSellerIdEqualTo(Long value) {
            addCriterion("taobao_seller_id =", value, "taobaoSellerId");
            return (Criteria) this;
        }

        public Criteria andTaobaoSellerIdNotEqualTo(Long value) {
            addCriterion("taobao_seller_id <>", value, "taobaoSellerId");
            return (Criteria) this;
        }

        public Criteria andTaobaoSellerIdGreaterThan(Long value) {
            addCriterion("taobao_seller_id >", value, "taobaoSellerId");
            return (Criteria) this;
        }

        public Criteria andTaobaoSellerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("taobao_seller_id >=", value, "taobaoSellerId");
            return (Criteria) this;
        }

        public Criteria andTaobaoSellerIdLessThan(Long value) {
            addCriterion("taobao_seller_id <", value, "taobaoSellerId");
            return (Criteria) this;
        }

        public Criteria andTaobaoSellerIdLessThanOrEqualTo(Long value) {
            addCriterion("taobao_seller_id <=", value, "taobaoSellerId");
            return (Criteria) this;
        }

        public Criteria andTaobaoSellerIdIn(List<Long> values) {
            addCriterion("taobao_seller_id in", values, "taobaoSellerId");
            return (Criteria) this;
        }

        public Criteria andTaobaoSellerIdNotIn(List<Long> values) {
            addCriterion("taobao_seller_id not in", values, "taobaoSellerId");
            return (Criteria) this;
        }

        public Criteria andTaobaoSellerIdBetween(Long value1, Long value2) {
            addCriterion("taobao_seller_id between", value1, value2, "taobaoSellerId");
            return (Criteria) this;
        }

        public Criteria andTaobaoSellerIdNotBetween(Long value1, Long value2) {
            addCriterion("taobao_seller_id not between", value1, value2, "taobaoSellerId");
            return (Criteria) this;
        }

        public Criteria andRecvIsNull() {
            addCriterion("recv is null");
            return (Criteria) this;
        }

        public Criteria andRecvIsNotNull() {
            addCriterion("recv is not null");
            return (Criteria) this;
        }

        public Criteria andRecvEqualTo(String value) {
            addCriterion("recv =", value, "recv");
            return (Criteria) this;
        }

        public Criteria andRecvNotEqualTo(String value) {
            addCriterion("recv <>", value, "recv");
            return (Criteria) this;
        }

        public Criteria andRecvGreaterThan(String value) {
            addCriterion("recv >", value, "recv");
            return (Criteria) this;
        }

        public Criteria andRecvGreaterThanOrEqualTo(String value) {
            addCriterion("recv >=", value, "recv");
            return (Criteria) this;
        }

        public Criteria andRecvLessThan(String value) {
            addCriterion("recv <", value, "recv");
            return (Criteria) this;
        }

        public Criteria andRecvLessThanOrEqualTo(String value) {
            addCriterion("recv <=", value, "recv");
            return (Criteria) this;
        }

        public Criteria andRecvLike(String value) {
            addCriterion("recv like", value, "recv");
            return (Criteria) this;
        }

        public Criteria andRecvNotLike(String value) {
            addCriterion("recv not like", value, "recv");
            return (Criteria) this;
        }

        public Criteria andRecvIn(List<String> values) {
            addCriterion("recv in", values, "recv");
            return (Criteria) this;
        }

        public Criteria andRecvNotIn(List<String> values) {
            addCriterion("recv not in", values, "recv");
            return (Criteria) this;
        }

        public Criteria andRecvBetween(String value1, String value2) {
            addCriterion("recv between", value1, value2, "recv");
            return (Criteria) this;
        }

        public Criteria andRecvNotBetween(String value1, String value2) {
            addCriterion("recv not between", value1, value2, "recv");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("gmt_create is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("gmt_create is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Date value) {
            addCriterion("gmt_create =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Date value) {
            addCriterion("gmt_create <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Date value) {
            addCriterion("gmt_create >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_create >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Date value) {
            addCriterion("gmt_create <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            addCriterion("gmt_create <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Date> values) {
            addCriterion("gmt_create in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Date> values) {
            addCriterion("gmt_create not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Date value1, Date value2) {
            addCriterion("gmt_create between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            addCriterion("gmt_create not between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}