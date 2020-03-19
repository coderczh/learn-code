package com.hfut.douban.bean;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Chenzh
 */
@Data
@Entity
@Table(name = "douban_info")
public class AllInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String type;
    private String total;
    private String dId;
    private String isbn10;
    private String isbn13;
    private String title;
    private String originTitle;
    private String altTitle;
    private String subtitle;
    private String url;
    private String alt;
    private String image;
    private String imageSmall;
    private String imageLarge;
    private String imageMedium;
    private String author;
    private String translator;
    private String publisher;
    private String pubdate;
    private String ratingMax;
    private String ratingNumRaters;
    private String ratingAverage;
    private String ratingMin;
    private String tags;
    private String binding;
    private String price;
    private String seriesId;
    private String seriesTitle;
    private String pages;
    private String authorIntro;
    private String summary;
    private String catalog;
    private String ebookUrl;
    private String ebookPrice;
}
