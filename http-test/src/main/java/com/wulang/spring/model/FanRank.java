package com.wulang.spring.model;

import java.util.List;

public class FanRank {
    private Integer totalCount;

    private String TagCode;

    private List<FanRankItem> fansList;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public String getTagCode() {
        return TagCode;
    }

    public void setTagCode(String tagCode) {
        TagCode = tagCode;
    }

    public List<FanRankItem> getFansList() {
        return fansList;
    }

    public void setFansList(List<FanRankItem> fansList) {
        this.fansList = fansList;
    }

    @Override
    public String toString() {
        return "FanRank{" +
                "totalCount=" + totalCount +
                ", TagCode='" + TagCode + '\'' +
                ", fansList=" + fansList +
                '}';
    }
}
