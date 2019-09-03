package com.wulang.spring.model;

public class FanRankItem {
    private Integer userId;

    private Integer gender;

    private String nickname;

    private Integer richLevel;

    private Integer contribution;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getRichLevel() {
        return richLevel;
    }

    public void setRichLevel(Integer richLevel) {
        this.richLevel = richLevel;
    }

    public Integer getContribution() {
        return contribution;
    }

    public void setContribution(Integer contribution) {
        this.contribution = contribution;
    }

    @Override
    public String toString() {
        return "FanRankItem{" +
                "userId=" + userId +
                ", gender=" + gender +
                ", nickname='" + nickname + '\'' +
                ", richLevel=" + richLevel +
                ", contribution=" + contribution +
                '}';
    }
}
