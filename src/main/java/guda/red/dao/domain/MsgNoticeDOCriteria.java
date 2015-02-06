package guda.red.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MsgNoticeDOCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int startRow = -1;

    protected int pageSize = -1;

    public MsgNoticeDOCriteria() {
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

        public Criteria andSendItemIsNull() {
            addCriterion("send_item is null");
            return (Criteria) this;
        }

        public Criteria andSendItemIsNotNull() {
            addCriterion("send_item is not null");
            return (Criteria) this;
        }

        public Criteria andSendItemEqualTo(Integer value) {
            addCriterion("send_item =", value, "sendItem");
            return (Criteria) this;
        }

        public Criteria andSendItemNotEqualTo(Integer value) {
            addCriterion("send_item <>", value, "sendItem");
            return (Criteria) this;
        }

        public Criteria andSendItemGreaterThan(Integer value) {
            addCriterion("send_item >", value, "sendItem");
            return (Criteria) this;
        }

        public Criteria andSendItemGreaterThanOrEqualTo(Integer value) {
            addCriterion("send_item >=", value, "sendItem");
            return (Criteria) this;
        }

        public Criteria andSendItemLessThan(Integer value) {
            addCriterion("send_item <", value, "sendItem");
            return (Criteria) this;
        }

        public Criteria andSendItemLessThanOrEqualTo(Integer value) {
            addCriterion("send_item <=", value, "sendItem");
            return (Criteria) this;
        }

        public Criteria andSendItemIn(List<Integer> values) {
            addCriterion("send_item in", values, "sendItem");
            return (Criteria) this;
        }

        public Criteria andSendItemNotIn(List<Integer> values) {
            addCriterion("send_item not in", values, "sendItem");
            return (Criteria) this;
        }

        public Criteria andSendItemBetween(Integer value1, Integer value2) {
            addCriterion("send_item between", value1, value2, "sendItem");
            return (Criteria) this;
        }

        public Criteria andSendItemNotBetween(Integer value1, Integer value2) {
            addCriterion("send_item not between", value1, value2, "sendItem");
            return (Criteria) this;
        }

        public Criteria andRecvItemIsNull() {
            addCriterion("recv_item is null");
            return (Criteria) this;
        }

        public Criteria andRecvItemIsNotNull() {
            addCriterion("recv_item is not null");
            return (Criteria) this;
        }

        public Criteria andRecvItemEqualTo(Integer value) {
            addCriterion("recv_item =", value, "recvItem");
            return (Criteria) this;
        }

        public Criteria andRecvItemNotEqualTo(Integer value) {
            addCriterion("recv_item <>", value, "recvItem");
            return (Criteria) this;
        }

        public Criteria andRecvItemGreaterThan(Integer value) {
            addCriterion("recv_item >", value, "recvItem");
            return (Criteria) this;
        }

        public Criteria andRecvItemGreaterThanOrEqualTo(Integer value) {
            addCriterion("recv_item >=", value, "recvItem");
            return (Criteria) this;
        }

        public Criteria andRecvItemLessThan(Integer value) {
            addCriterion("recv_item <", value, "recvItem");
            return (Criteria) this;
        }

        public Criteria andRecvItemLessThanOrEqualTo(Integer value) {
            addCriterion("recv_item <=", value, "recvItem");
            return (Criteria) this;
        }

        public Criteria andRecvItemIn(List<Integer> values) {
            addCriterion("recv_item in", values, "recvItem");
            return (Criteria) this;
        }

        public Criteria andRecvItemNotIn(List<Integer> values) {
            addCriterion("recv_item not in", values, "recvItem");
            return (Criteria) this;
        }

        public Criteria andRecvItemBetween(Integer value1, Integer value2) {
            addCriterion("recv_item between", value1, value2, "recvItem");
            return (Criteria) this;
        }

        public Criteria andRecvItemNotBetween(Integer value1, Integer value2) {
            addCriterion("recv_item not between", value1, value2, "recvItem");
            return (Criteria) this;
        }

        public Criteria andRefundIsNull() {
            addCriterion("refund is null");
            return (Criteria) this;
        }

        public Criteria andRefundIsNotNull() {
            addCriterion("refund is not null");
            return (Criteria) this;
        }

        public Criteria andRefundEqualTo(Integer value) {
            addCriterion("refund =", value, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundNotEqualTo(Integer value) {
            addCriterion("refund <>", value, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundGreaterThan(Integer value) {
            addCriterion("refund >", value, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundGreaterThanOrEqualTo(Integer value) {
            addCriterion("refund >=", value, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundLessThan(Integer value) {
            addCriterion("refund <", value, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundLessThanOrEqualTo(Integer value) {
            addCriterion("refund <=", value, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundIn(List<Integer> values) {
            addCriterion("refund in", values, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundNotIn(List<Integer> values) {
            addCriterion("refund not in", values, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundBetween(Integer value1, Integer value2) {
            addCriterion("refund between", value1, value2, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundNotBetween(Integer value1, Integer value2) {
            addCriterion("refund not between", value1, value2, "refund");
            return (Criteria) this;
        }

        public Criteria andWaitPayIsNull() {
            addCriterion("wait_pay is null");
            return (Criteria) this;
        }

        public Criteria andWaitPayIsNotNull() {
            addCriterion("wait_pay is not null");
            return (Criteria) this;
        }

        public Criteria andWaitPayEqualTo(Integer value) {
            addCriterion("wait_pay =", value, "waitPay");
            return (Criteria) this;
        }

        public Criteria andWaitPayNotEqualTo(Integer value) {
            addCriterion("wait_pay <>", value, "waitPay");
            return (Criteria) this;
        }

        public Criteria andWaitPayGreaterThan(Integer value) {
            addCriterion("wait_pay >", value, "waitPay");
            return (Criteria) this;
        }

        public Criteria andWaitPayGreaterThanOrEqualTo(Integer value) {
            addCriterion("wait_pay >=", value, "waitPay");
            return (Criteria) this;
        }

        public Criteria andWaitPayLessThan(Integer value) {
            addCriterion("wait_pay <", value, "waitPay");
            return (Criteria) this;
        }

        public Criteria andWaitPayLessThanOrEqualTo(Integer value) {
            addCriterion("wait_pay <=", value, "waitPay");
            return (Criteria) this;
        }

        public Criteria andWaitPayIn(List<Integer> values) {
            addCriterion("wait_pay in", values, "waitPay");
            return (Criteria) this;
        }

        public Criteria andWaitPayNotIn(List<Integer> values) {
            addCriterion("wait_pay not in", values, "waitPay");
            return (Criteria) this;
        }

        public Criteria andWaitPayBetween(Integer value1, Integer value2) {
            addCriterion("wait_pay between", value1, value2, "waitPay");
            return (Criteria) this;
        }

        public Criteria andWaitPayNotBetween(Integer value1, Integer value2) {
            addCriterion("wait_pay not between", value1, value2, "waitPay");
            return (Criteria) this;
        }

        public Criteria andPositiveCommentIsNull() {
            addCriterion("positive_comment is null");
            return (Criteria) this;
        }

        public Criteria andPositiveCommentIsNotNull() {
            addCriterion("positive_comment is not null");
            return (Criteria) this;
        }

        public Criteria andPositiveCommentEqualTo(Integer value) {
            addCriterion("positive_comment =", value, "positiveComment");
            return (Criteria) this;
        }

        public Criteria andPositiveCommentNotEqualTo(Integer value) {
            addCriterion("positive_comment <>", value, "positiveComment");
            return (Criteria) this;
        }

        public Criteria andPositiveCommentGreaterThan(Integer value) {
            addCriterion("positive_comment >", value, "positiveComment");
            return (Criteria) this;
        }

        public Criteria andPositiveCommentGreaterThanOrEqualTo(Integer value) {
            addCriterion("positive_comment >=", value, "positiveComment");
            return (Criteria) this;
        }

        public Criteria andPositiveCommentLessThan(Integer value) {
            addCriterion("positive_comment <", value, "positiveComment");
            return (Criteria) this;
        }

        public Criteria andPositiveCommentLessThanOrEqualTo(Integer value) {
            addCriterion("positive_comment <=", value, "positiveComment");
            return (Criteria) this;
        }

        public Criteria andPositiveCommentIn(List<Integer> values) {
            addCriterion("positive_comment in", values, "positiveComment");
            return (Criteria) this;
        }

        public Criteria andPositiveCommentNotIn(List<Integer> values) {
            addCriterion("positive_comment not in", values, "positiveComment");
            return (Criteria) this;
        }

        public Criteria andPositiveCommentBetween(Integer value1, Integer value2) {
            addCriterion("positive_comment between", value1, value2, "positiveComment");
            return (Criteria) this;
        }

        public Criteria andPositiveCommentNotBetween(Integer value1, Integer value2) {
            addCriterion("positive_comment not between", value1, value2, "positiveComment");
            return (Criteria) this;
        }

        public Criteria andSignIsNull() {
            addCriterion("sign is null");
            return (Criteria) this;
        }

        public Criteria andSignIsNotNull() {
            addCriterion("sign is not null");
            return (Criteria) this;
        }

        public Criteria andSignEqualTo(Integer value) {
            addCriterion("sign =", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotEqualTo(Integer value) {
            addCriterion("sign <>", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignGreaterThan(Integer value) {
            addCriterion("sign >", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignGreaterThanOrEqualTo(Integer value) {
            addCriterion("sign >=", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLessThan(Integer value) {
            addCriterion("sign <", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLessThanOrEqualTo(Integer value) {
            addCriterion("sign <=", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignIn(List<Integer> values) {
            addCriterion("sign in", values, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotIn(List<Integer> values) {
            addCriterion("sign not in", values, "sign");
            return (Criteria) this;
        }

        public Criteria andSignBetween(Integer value1, Integer value2) {
            addCriterion("sign between", value1, value2, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotBetween(Integer value1, Integer value2) {
            addCriterion("sign not between", value1, value2, "sign");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedIsNull() {
            addCriterion("gmt_created is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedIsNotNull() {
            addCriterion("gmt_created is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedEqualTo(Date value) {
            addCriterion("gmt_created =", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedNotEqualTo(Date value) {
            addCriterion("gmt_created <>", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedGreaterThan(Date value) {
            addCriterion("gmt_created >", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_created >=", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedLessThan(Date value) {
            addCriterion("gmt_created <", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_created <=", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedIn(List<Date> values) {
            addCriterion("gmt_created in", values, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedNotIn(List<Date> values) {
            addCriterion("gmt_created not in", values, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedBetween(Date value1, Date value2) {
            addCriterion("gmt_created between", value1, value2, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_created not between", value1, value2, "gmtCreated");
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