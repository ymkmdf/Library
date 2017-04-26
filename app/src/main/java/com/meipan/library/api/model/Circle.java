package com.meipan.library.api.model;

import java.util.List;

/**
 * Created by gaoyan on 17/2/10.
 */

public class Circle {
    public String circleId;     //圈子id
    public String name;         //圈子名字
    public String summary;      //圈子描述
    public String cover;        //所有者
    public int articlesCount;   //圈子文章数
    public int membersCount;    //圈子人数
//    public List<Article> articles; //帖子类别
    public List<Banner> banners; //帖子类别
    public List<Circle> hotCircles; //帖子类别
    public Circle circle;
//    public List<Labels> labels;
    public boolean isJoined;    //是否已经加入
//    public Owner owner;        //发帖者
    public boolean isHaveLabel;  //是否有话题

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    public boolean isHaveLabel() {
        return isHaveLabel;
    }

    public void setHaveLabel(boolean haveLabel) {
        isHaveLabel = haveLabel;
    }

    public List<Circle> getHotCircles() {
        return hotCircles;
    }

    public void setHotCircles(List<Circle> hotCircles) {
        this.hotCircles = hotCircles;
    }

    public List<Banner> getBanners() {
        return banners;
    }

    public void setBanners(List<Banner> banners) {
        this.banners = banners;
    }

    public String getCircleId() {
        return circleId;
    }

    public void setCircleId(String circleId) {
        this.circleId = circleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public int getArticlesCount() {
        return articlesCount;
    }

    public void setArticlesCount(int articlesCount) {
        this.articlesCount = articlesCount;
    }

    public int getMembersCount() {
        return membersCount;
    }

    public void setMembersCount(int membersCount) {
        this.membersCount = membersCount;
    }

    public boolean isJoined() {
        return isJoined;
    }

    public void setJoined(boolean joined) {
        isJoined = joined;
    }
}
