package com.hfut.douban.bean;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Chenzh
 */
@Data
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String dId;
    private String total;
    private String ratingMax;
    private String ratingValue;
    private String ratingMin;
    private String votes;
    private String authorName;
    private String authorIsBanned;
    private String authorIsSuicide;
    private String authorUrl;
    private String authorAvatar;
    private String authorUid;
    private String authorAlt;
    private String authorType;
    private String authorId;
    private String authorLargeAvatar;
    private String summary;
    private String published;
    private String alt;
    private String cId;
}
