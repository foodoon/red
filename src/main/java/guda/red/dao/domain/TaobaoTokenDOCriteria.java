package guda.red.dao.domain;

import java.util.ArrayList;
import java.util.List;

public class TaobaoTokenDOCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int startRow = -1;

    protected int pageSize = -1;

    public TaobaoTokenDOCriteria() {
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

        public Criteria andTaobaoUserIdIsNull() {
            addCriterion("taobao_user_id is null");
            return (Criteria) this;
        }

        public Criteria andTaobaoUserIdIsNotNull() {
            addCriterion("taobao_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaobaoUserIdEqualTo(String value) {
            addCriterion("taobao_user_id =", value, "taobaoUserId");
            return (Criteria) this;
        }

        public Criteria andTaobaoUserIdNotEqualTo(String value) {
            addCriterion("taobao_user_id <>", value, "taobaoUserId");
            return (Criteria) this;
        }

        public Criteria andTaobaoUserIdGreaterThan(String value) {
            addCriterion("taobao_user_id >", value, "taobaoUserId");
            return (Criteria) this;
        }

        public Criteria andTaobaoUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("taobao_user_id >=", value, "taobaoUserId");
            return (Criteria) this;
        }

        public Criteria andTaobaoUserIdLessThan(String value) {
            addCriterion("taobao_user_id <", value, "taobaoUserId");
            return (Criteria) this;
        }

        public Criteria andTaobaoUserIdLessThanOrEqualTo(String value) {
            addCriterion("taobao_user_id <=", value, "taobaoUserId");
            return (Criteria) this;
        }

        public Criteria andTaobaoUserIdLike(String value) {
            addCriterion("taobao_user_id like", value, "taobaoUserId");
            return (Criteria) this;
        }

        public Criteria andTaobaoUserIdNotLike(String value) {
            addCriterion("taobao_user_id not like", value, "taobaoUserId");
            return (Criteria) this;
        }

        public Criteria andTaobaoUserIdIn(List<String> values) {
            addCriterion("taobao_user_id in", values, "taobaoUserId");
            return (Criteria) this;
        }

        public Criteria andTaobaoUserIdNotIn(List<String> values) {
            addCriterion("taobao_user_id not in", values, "taobaoUserId");
            return (Criteria) this;
        }

        public Criteria andTaobaoUserIdBetween(String value1, String value2) {
            addCriterion("taobao_user_id between", value1, value2, "taobaoUserId");
            return (Criteria) this;
        }

        public Criteria andTaobaoUserIdNotBetween(String value1, String value2) {
            addCriterion("taobao_user_id not between", value1, value2, "taobaoUserId");
            return (Criteria) this;
        }

        public Criteria andTaobaoUserNickIsNull() {
            addCriterion("taobao_user_nick is null");
            return (Criteria) this;
        }

        public Criteria andTaobaoUserNickIsNotNull() {
            addCriterion("taobao_user_nick is not null");
            return (Criteria) this;
        }

        public Criteria andTaobaoUserNickEqualTo(String value) {
            addCriterion("taobao_user_nick =", value, "taobaoUserNick");
            return (Criteria) this;
        }

        public Criteria andTaobaoUserNickNotEqualTo(String value) {
            addCriterion("taobao_user_nick <>", value, "taobaoUserNick");
            return (Criteria) this;
        }

        public Criteria andTaobaoUserNickGreaterThan(String value) {
            addCriterion("taobao_user_nick >", value, "taobaoUserNick");
            return (Criteria) this;
        }

        public Criteria andTaobaoUserNickGreaterThanOrEqualTo(String value) {
            addCriterion("taobao_user_nick >=", value, "taobaoUserNick");
            return (Criteria) this;
        }

        public Criteria andTaobaoUserNickLessThan(String value) {
            addCriterion("taobao_user_nick <", value, "taobaoUserNick");
            return (Criteria) this;
        }

        public Criteria andTaobaoUserNickLessThanOrEqualTo(String value) {
            addCriterion("taobao_user_nick <=", value, "taobaoUserNick");
            return (Criteria) this;
        }

        public Criteria andTaobaoUserNickLike(String value) {
            addCriterion("taobao_user_nick like", value, "taobaoUserNick");
            return (Criteria) this;
        }

        public Criteria andTaobaoUserNickNotLike(String value) {
            addCriterion("taobao_user_nick not like", value, "taobaoUserNick");
            return (Criteria) this;
        }

        public Criteria andTaobaoUserNickIn(List<String> values) {
            addCriterion("taobao_user_nick in", values, "taobaoUserNick");
            return (Criteria) this;
        }

        public Criteria andTaobaoUserNickNotIn(List<String> values) {
            addCriterion("taobao_user_nick not in", values, "taobaoUserNick");
            return (Criteria) this;
        }

        public Criteria andTaobaoUserNickBetween(String value1, String value2) {
            addCriterion("taobao_user_nick between", value1, value2, "taobaoUserNick");
            return (Criteria) this;
        }

        public Criteria andTaobaoUserNickNotBetween(String value1, String value2) {
            addCriterion("taobao_user_nick not between", value1, value2, "taobaoUserNick");
            return (Criteria) this;
        }

        public Criteria andTokenTypeIsNull() {
            addCriterion("token_type is null");
            return (Criteria) this;
        }

        public Criteria andTokenTypeIsNotNull() {
            addCriterion("token_type is not null");
            return (Criteria) this;
        }

        public Criteria andTokenTypeEqualTo(String value) {
            addCriterion("token_type =", value, "tokenType");
            return (Criteria) this;
        }

        public Criteria andTokenTypeNotEqualTo(String value) {
            addCriterion("token_type <>", value, "tokenType");
            return (Criteria) this;
        }

        public Criteria andTokenTypeGreaterThan(String value) {
            addCriterion("token_type >", value, "tokenType");
            return (Criteria) this;
        }

        public Criteria andTokenTypeGreaterThanOrEqualTo(String value) {
            addCriterion("token_type >=", value, "tokenType");
            return (Criteria) this;
        }

        public Criteria andTokenTypeLessThan(String value) {
            addCriterion("token_type <", value, "tokenType");
            return (Criteria) this;
        }

        public Criteria andTokenTypeLessThanOrEqualTo(String value) {
            addCriterion("token_type <=", value, "tokenType");
            return (Criteria) this;
        }

        public Criteria andTokenTypeLike(String value) {
            addCriterion("token_type like", value, "tokenType");
            return (Criteria) this;
        }

        public Criteria andTokenTypeNotLike(String value) {
            addCriterion("token_type not like", value, "tokenType");
            return (Criteria) this;
        }

        public Criteria andTokenTypeIn(List<String> values) {
            addCriterion("token_type in", values, "tokenType");
            return (Criteria) this;
        }

        public Criteria andTokenTypeNotIn(List<String> values) {
            addCriterion("token_type not in", values, "tokenType");
            return (Criteria) this;
        }

        public Criteria andTokenTypeBetween(String value1, String value2) {
            addCriterion("token_type between", value1, value2, "tokenType");
            return (Criteria) this;
        }

        public Criteria andTokenTypeNotBetween(String value1, String value2) {
            addCriterion("token_type not between", value1, value2, "tokenType");
            return (Criteria) this;
        }

        public Criteria andAccessTokenIsNull() {
            addCriterion("access_token is null");
            return (Criteria) this;
        }

        public Criteria andAccessTokenIsNotNull() {
            addCriterion("access_token is not null");
            return (Criteria) this;
        }

        public Criteria andAccessTokenEqualTo(String value) {
            addCriterion("access_token =", value, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenNotEqualTo(String value) {
            addCriterion("access_token <>", value, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenGreaterThan(String value) {
            addCriterion("access_token >", value, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenGreaterThanOrEqualTo(String value) {
            addCriterion("access_token >=", value, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenLessThan(String value) {
            addCriterion("access_token <", value, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenLessThanOrEqualTo(String value) {
            addCriterion("access_token <=", value, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenLike(String value) {
            addCriterion("access_token like", value, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenNotLike(String value) {
            addCriterion("access_token not like", value, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenIn(List<String> values) {
            addCriterion("access_token in", values, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenNotIn(List<String> values) {
            addCriterion("access_token not in", values, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenBetween(String value1, String value2) {
            addCriterion("access_token between", value1, value2, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenNotBetween(String value1, String value2) {
            addCriterion("access_token not between", value1, value2, "accessToken");
            return (Criteria) this;
        }

        public Criteria andExpiresInIsNull() {
            addCriterion("expires_in is null");
            return (Criteria) this;
        }

        public Criteria andExpiresInIsNotNull() {
            addCriterion("expires_in is not null");
            return (Criteria) this;
        }

        public Criteria andExpiresInEqualTo(Long value) {
            addCriterion("expires_in =", value, "expiresIn");
            return (Criteria) this;
        }

        public Criteria andExpiresInNotEqualTo(Long value) {
            addCriterion("expires_in <>", value, "expiresIn");
            return (Criteria) this;
        }

        public Criteria andExpiresInGreaterThan(Long value) {
            addCriterion("expires_in >", value, "expiresIn");
            return (Criteria) this;
        }

        public Criteria andExpiresInGreaterThanOrEqualTo(Long value) {
            addCriterion("expires_in >=", value, "expiresIn");
            return (Criteria) this;
        }

        public Criteria andExpiresInLessThan(Long value) {
            addCriterion("expires_in <", value, "expiresIn");
            return (Criteria) this;
        }

        public Criteria andExpiresInLessThanOrEqualTo(Long value) {
            addCriterion("expires_in <=", value, "expiresIn");
            return (Criteria) this;
        }

        public Criteria andExpiresInIn(List<Long> values) {
            addCriterion("expires_in in", values, "expiresIn");
            return (Criteria) this;
        }

        public Criteria andExpiresInNotIn(List<Long> values) {
            addCriterion("expires_in not in", values, "expiresIn");
            return (Criteria) this;
        }

        public Criteria andExpiresInBetween(Long value1, Long value2) {
            addCriterion("expires_in between", value1, value2, "expiresIn");
            return (Criteria) this;
        }

        public Criteria andExpiresInNotBetween(Long value1, Long value2) {
            addCriterion("expires_in not between", value1, value2, "expiresIn");
            return (Criteria) this;
        }

        public Criteria andR1ExpiresInIsNull() {
            addCriterion("r1_expires_in is null");
            return (Criteria) this;
        }

        public Criteria andR1ExpiresInIsNotNull() {
            addCriterion("r1_expires_in is not null");
            return (Criteria) this;
        }

        public Criteria andR1ExpiresInEqualTo(Long value) {
            addCriterion("r1_expires_in =", value, "r1ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andR1ExpiresInNotEqualTo(Long value) {
            addCriterion("r1_expires_in <>", value, "r1ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andR1ExpiresInGreaterThan(Long value) {
            addCriterion("r1_expires_in >", value, "r1ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andR1ExpiresInGreaterThanOrEqualTo(Long value) {
            addCriterion("r1_expires_in >=", value, "r1ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andR1ExpiresInLessThan(Long value) {
            addCriterion("r1_expires_in <", value, "r1ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andR1ExpiresInLessThanOrEqualTo(Long value) {
            addCriterion("r1_expires_in <=", value, "r1ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andR1ExpiresInIn(List<Long> values) {
            addCriterion("r1_expires_in in", values, "r1ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andR1ExpiresInNotIn(List<Long> values) {
            addCriterion("r1_expires_in not in", values, "r1ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andR1ExpiresInBetween(Long value1, Long value2) {
            addCriterion("r1_expires_in between", value1, value2, "r1ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andR1ExpiresInNotBetween(Long value1, Long value2) {
            addCriterion("r1_expires_in not between", value1, value2, "r1ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andR2ExpiresInIsNull() {
            addCriterion("r2_expires_in is null");
            return (Criteria) this;
        }

        public Criteria andR2ExpiresInIsNotNull() {
            addCriterion("r2_expires_in is not null");
            return (Criteria) this;
        }

        public Criteria andR2ExpiresInEqualTo(Long value) {
            addCriterion("r2_expires_in =", value, "r2ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andR2ExpiresInNotEqualTo(Long value) {
            addCriterion("r2_expires_in <>", value, "r2ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andR2ExpiresInGreaterThan(Long value) {
            addCriterion("r2_expires_in >", value, "r2ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andR2ExpiresInGreaterThanOrEqualTo(Long value) {
            addCriterion("r2_expires_in >=", value, "r2ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andR2ExpiresInLessThan(Long value) {
            addCriterion("r2_expires_in <", value, "r2ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andR2ExpiresInLessThanOrEqualTo(Long value) {
            addCriterion("r2_expires_in <=", value, "r2ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andR2ExpiresInIn(List<Long> values) {
            addCriterion("r2_expires_in in", values, "r2ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andR2ExpiresInNotIn(List<Long> values) {
            addCriterion("r2_expires_in not in", values, "r2ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andR2ExpiresInBetween(Long value1, Long value2) {
            addCriterion("r2_expires_in between", value1, value2, "r2ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andR2ExpiresInNotBetween(Long value1, Long value2) {
            addCriterion("r2_expires_in not between", value1, value2, "r2ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andW1ExpiresInIsNull() {
            addCriterion("w1_expires_in is null");
            return (Criteria) this;
        }

        public Criteria andW1ExpiresInIsNotNull() {
            addCriterion("w1_expires_in is not null");
            return (Criteria) this;
        }

        public Criteria andW1ExpiresInEqualTo(Long value) {
            addCriterion("w1_expires_in =", value, "w1ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andW1ExpiresInNotEqualTo(Long value) {
            addCriterion("w1_expires_in <>", value, "w1ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andW1ExpiresInGreaterThan(Long value) {
            addCriterion("w1_expires_in >", value, "w1ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andW1ExpiresInGreaterThanOrEqualTo(Long value) {
            addCriterion("w1_expires_in >=", value, "w1ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andW1ExpiresInLessThan(Long value) {
            addCriterion("w1_expires_in <", value, "w1ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andW1ExpiresInLessThanOrEqualTo(Long value) {
            addCriterion("w1_expires_in <=", value, "w1ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andW1ExpiresInIn(List<Long> values) {
            addCriterion("w1_expires_in in", values, "w1ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andW1ExpiresInNotIn(List<Long> values) {
            addCriterion("w1_expires_in not in", values, "w1ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andW1ExpiresInBetween(Long value1, Long value2) {
            addCriterion("w1_expires_in between", value1, value2, "w1ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andW1ExpiresInNotBetween(Long value1, Long value2) {
            addCriterion("w1_expires_in not between", value1, value2, "w1ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andW2ExpiresInIsNull() {
            addCriterion("w2_expires_in is null");
            return (Criteria) this;
        }

        public Criteria andW2ExpiresInIsNotNull() {
            addCriterion("w2_expires_in is not null");
            return (Criteria) this;
        }

        public Criteria andW2ExpiresInEqualTo(Long value) {
            addCriterion("w2_expires_in =", value, "w2ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andW2ExpiresInNotEqualTo(Long value) {
            addCriterion("w2_expires_in <>", value, "w2ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andW2ExpiresInGreaterThan(Long value) {
            addCriterion("w2_expires_in >", value, "w2ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andW2ExpiresInGreaterThanOrEqualTo(Long value) {
            addCriterion("w2_expires_in >=", value, "w2ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andW2ExpiresInLessThan(Long value) {
            addCriterion("w2_expires_in <", value, "w2ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andW2ExpiresInLessThanOrEqualTo(Long value) {
            addCriterion("w2_expires_in <=", value, "w2ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andW2ExpiresInIn(List<Long> values) {
            addCriterion("w2_expires_in in", values, "w2ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andW2ExpiresInNotIn(List<Long> values) {
            addCriterion("w2_expires_in not in", values, "w2ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andW2ExpiresInBetween(Long value1, Long value2) {
            addCriterion("w2_expires_in between", value1, value2, "w2ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andW2ExpiresInNotBetween(Long value1, Long value2) {
            addCriterion("w2_expires_in not between", value1, value2, "w2ExpiresIn");
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