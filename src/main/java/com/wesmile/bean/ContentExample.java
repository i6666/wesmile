package com.wesmile.bean;

import com.wesmile.plugins.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContentExample {
    /**
     * tb_content
     */
    protected String orderByClause;

    /**
     * tb_content
     */
    protected boolean distinct;

    /**
     * tb_content
     */
    protected List<Criteria> oredCriteria;

    /**
     * tb_content
     */
    protected Page page;

    /**
     * auto generate
     * @return null
     * @date 2019-06-12 14:35:09
     *
     * @author generator
     */
    public ContentExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * auto generate
     * @param orderByClause
     * @return null
     * @date 2019-06-12 14:35:09
     *
     * @author generator
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * auto generate
     * @return java.lang.String
     * @date 2019-06-12 14:35:09
     *
     * @author generator
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * auto generate
     * @param distinct
     * @return null
     * @date 2019-06-12 14:35:09
     *
     * @author generator
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * auto generate
     * @return boolean
     * @date 2019-06-12 14:35:09
     *
     * @author generator
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * auto generate
     * @return java.util.List<Criteria>
     * @date 2019-06-12 14:35:09
     *
     * @author generator
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * auto generate
     * @param criteria
     * @return null
     * @date 2019-06-12 14:35:09
     *
     * @author generator
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * auto generate
     * @return Criteria
     * @date 2019-06-12 14:35:09
     *
     * @author generator
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * auto generate
     * @return Criteria
     * @date 2019-06-12 14:35:09
     *
     * @author generator
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * auto generate
     * @return Criteria
     * @date 2019-06-12 14:35:09
     *
     * @author generator
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * auto generate
     * @return null
     * @date 2019-06-12 14:35:09
     *
     * @author generator
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * auto generate
     * @param page
     * @return null
     * @date 2019-06-12 14:35:09
     *
     * @author generator
     */
    public void setPage(Page page) {
        this.page=page;
    }

    /**
     * auto generate
     * @return com.wesmile.plugins.Page
     * @date 2019-06-12 14:35:09
     *
     * @author generator
     */
    public Page getPage() {
        return page;
    }

    /**
     * @author generator
     * 2019-06-12 14:35:09
     */
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andFetchTimeIsNull() {
            addCriterion("fetchTime is null");
            return (Criteria) this;
        }

        public Criteria andFetchTimeIsNotNull() {
            addCriterion("fetchTime is not null");
            return (Criteria) this;
        }

        public Criteria andFetchTimeEqualTo(Date value) {
            addCriterion("fetchTime =", value, "fetchTime");
            return (Criteria) this;
        }

        public Criteria andFetchTimeNotEqualTo(Date value) {
            addCriterion("fetchTime <>", value, "fetchTime");
            return (Criteria) this;
        }

        public Criteria andFetchTimeGreaterThan(Date value) {
            addCriterion("fetchTime >", value, "fetchTime");
            return (Criteria) this;
        }

        public Criteria andFetchTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("fetchTime >=", value, "fetchTime");
            return (Criteria) this;
        }

        public Criteria andFetchTimeLessThan(Date value) {
            addCriterion("fetchTime <", value, "fetchTime");
            return (Criteria) this;
        }

        public Criteria andFetchTimeLessThanOrEqualTo(Date value) {
            addCriterion("fetchTime <=", value, "fetchTime");
            return (Criteria) this;
        }

        public Criteria andFetchTimeIn(List<Date> values) {
            addCriterion("fetchTime in", values, "fetchTime");
            return (Criteria) this;
        }

        public Criteria andFetchTimeNotIn(List<Date> values) {
            addCriterion("fetchTime not in", values, "fetchTime");
            return (Criteria) this;
        }

        public Criteria andFetchTimeBetween(Date value1, Date value2) {
            addCriterion("fetchTime between", value1, value2, "fetchTime");
            return (Criteria) this;
        }

        public Criteria andFetchTimeNotBetween(Date value1, Date value2) {
            addCriterion("fetchTime not between", value1, value2, "fetchTime");
            return (Criteria) this;
        }

        public Criteria andFileIdIsNull() {
            addCriterion("file_id is null");
            return (Criteria) this;
        }

        public Criteria andFileIdIsNotNull() {
            addCriterion("file_id is not null");
            return (Criteria) this;
        }

        public Criteria andFileIdEqualTo(Integer value) {
            addCriterion("file_id =", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotEqualTo(Integer value) {
            addCriterion("file_id <>", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdGreaterThan(Integer value) {
            addCriterion("file_id >", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("file_id >=", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdLessThan(Integer value) {
            addCriterion("file_id <", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdLessThanOrEqualTo(Integer value) {
            addCriterion("file_id <=", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdIn(List<Integer> values) {
            addCriterion("file_id in", values, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotIn(List<Integer> values) {
            addCriterion("file_id not in", values, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdBetween(Integer value1, Integer value2) {
            addCriterion("file_id between", value1, value2, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotBetween(Integer value1, Integer value2) {
            addCriterion("file_id not between", value1, value2, "fileId");
            return (Criteria) this;
        }

        public Criteria andTagIsNull() {
            addCriterion("tag is null");
            return (Criteria) this;
        }

        public Criteria andTagIsNotNull() {
            addCriterion("tag is not null");
            return (Criteria) this;
        }

        public Criteria andTagEqualTo(String value) {
            addCriterion("tag =", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotEqualTo(String value) {
            addCriterion("tag <>", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagGreaterThan(String value) {
            addCriterion("tag >", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagGreaterThanOrEqualTo(String value) {
            addCriterion("tag >=", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLessThan(String value) {
            addCriterion("tag <", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLessThanOrEqualTo(String value) {
            addCriterion("tag <=", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLike(String value) {
            addCriterion("tag like", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotLike(String value) {
            addCriterion("tag not like", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagIn(List<String> values) {
            addCriterion("tag in", values, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotIn(List<String> values) {
            addCriterion("tag not in", values, "tag");
            return (Criteria) this;
        }

        public Criteria andTagBetween(String value1, String value2) {
            addCriterion("tag between", value1, value2, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotBetween(String value1, String value2) {
            addCriterion("tag not between", value1, value2, "tag");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(String value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(String value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(String value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(String value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(String value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(String value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLike(String value) {
            addCriterion("sort like", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotLike(String value) {
            addCriterion("sort not like", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<String> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<String> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(String value1, String value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(String value1, String value2) {
            addCriterion("sort not between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(String value) {
            addCriterion("source =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(String value) {
            addCriterion("source <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(String value) {
            addCriterion("source >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(String value) {
            addCriterion("source >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(String value) {
            addCriterion("source <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(String value) {
            addCriterion("source <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLike(String value) {
            addCriterion("source like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotLike(String value) {
            addCriterion("source not like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<String> values) {
            addCriterion("source in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<String> values) {
            addCriterion("source not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(String value1, String value2) {
            addCriterion("source between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(String value1, String value2) {
            addCriterion("source not between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("createTime <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimesIsNull() {
            addCriterion("updateTimes is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimesIsNotNull() {
            addCriterion("updateTimes is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimesEqualTo(Date value) {
            addCriterion("updateTimes =", value, "updateTimes");
            return (Criteria) this;
        }

        public Criteria andUpdateTimesNotEqualTo(Date value) {
            addCriterion("updateTimes <>", value, "updateTimes");
            return (Criteria) this;
        }

        public Criteria andUpdateTimesGreaterThan(Date value) {
            addCriterion("updateTimes >", value, "updateTimes");
            return (Criteria) this;
        }

        public Criteria andUpdateTimesGreaterThanOrEqualTo(Date value) {
            addCriterion("updateTimes >=", value, "updateTimes");
            return (Criteria) this;
        }

        public Criteria andUpdateTimesLessThan(Date value) {
            addCriterion("updateTimes <", value, "updateTimes");
            return (Criteria) this;
        }

        public Criteria andUpdateTimesLessThanOrEqualTo(Date value) {
            addCriterion("updateTimes <=", value, "updateTimes");
            return (Criteria) this;
        }

        public Criteria andUpdateTimesIn(List<Date> values) {
            addCriterion("updateTimes in", values, "updateTimes");
            return (Criteria) this;
        }

        public Criteria andUpdateTimesNotIn(List<Date> values) {
            addCriterion("updateTimes not in", values, "updateTimes");
            return (Criteria) this;
        }

        public Criteria andUpdateTimesBetween(Date value1, Date value2) {
            addCriterion("updateTimes between", value1, value2, "updateTimes");
            return (Criteria) this;
        }

        public Criteria andUpdateTimesNotBetween(Date value1, Date value2) {
            addCriterion("updateTimes not between", value1, value2, "updateTimes");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andVersionsIsNull() {
            addCriterion("versions is null");
            return (Criteria) this;
        }

        public Criteria andVersionsIsNotNull() {
            addCriterion("versions is not null");
            return (Criteria) this;
        }

        public Criteria andVersionsEqualTo(Long value) {
            addCriterion("versions =", value, "versions");
            return (Criteria) this;
        }

        public Criteria andVersionsNotEqualTo(Long value) {
            addCriterion("versions <>", value, "versions");
            return (Criteria) this;
        }

        public Criteria andVersionsGreaterThan(Long value) {
            addCriterion("versions >", value, "versions");
            return (Criteria) this;
        }

        public Criteria andVersionsGreaterThanOrEqualTo(Long value) {
            addCriterion("versions >=", value, "versions");
            return (Criteria) this;
        }

        public Criteria andVersionsLessThan(Long value) {
            addCriterion("versions <", value, "versions");
            return (Criteria) this;
        }

        public Criteria andVersionsLessThanOrEqualTo(Long value) {
            addCriterion("versions <=", value, "versions");
            return (Criteria) this;
        }

        public Criteria andVersionsIn(List<Long> values) {
            addCriterion("versions in", values, "versions");
            return (Criteria) this;
        }

        public Criteria andVersionsNotIn(List<Long> values) {
            addCriterion("versions not in", values, "versions");
            return (Criteria) this;
        }

        public Criteria andVersionsBetween(Long value1, Long value2) {
            addCriterion("versions between", value1, value2, "versions");
            return (Criteria) this;
        }

        public Criteria andVersionsNotBetween(Long value1, Long value2) {
            addCriterion("versions not between", value1, value2, "versions");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }
    }

    /** * auto generator * @date 2019-06-12 14:35:09 * @author generator */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * @author generator
     * 2019-06-12 14:35:09
     */
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