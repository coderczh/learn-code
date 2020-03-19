package com.hfut.douban.service;

import com.hfut.douban.bean.Comment;
import com.hfut.douban.repository.CommentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Chenzh
 */
@Service
public class CommentService {

    @Resource
    CommentRepository commentRepository;

    private int number = 1;

    @Transactional(rollbackFor = Exception.class)
    public void preserve(String dId, String total, String ratingMax, String ratingValue, String ratingMin,
                         String votes, String authorName, String authorIsBanned, String authorIsSuicide,
                         String authorUrl, String authorAvatar, String authorUid, String authorAlt,
                         String authorType, String authorId, String authorLargeAvatar, String summary,
                         String published, String alt, String cId) {
        Comment comment = new Comment();
        comment.setDId("".equals(dId) ? null : dId);
        comment.setTotal("".equals(total) ? null : total);
        comment.setRatingMax("".equals(ratingMax) ? null : ratingMax);
        comment.setRatingValue("".equals(ratingValue) ? null : ratingValue);
        comment.setRatingMin("".equals(ratingMin) ? null : ratingMin);
        comment.setVotes("".equals(votes) ? null : votes);
        comment.setAuthorName("".equals(authorName) ? null : authorName);
        comment.setAuthorIsBanned("".equals(authorIsBanned) ? null : authorIsBanned);
        comment.setAuthorIsSuicide("".equals(authorIsSuicide) ? null : authorIsSuicide);
        comment.setAuthorUrl("".equals(authorUrl) ? null : authorUrl);
        comment.setAuthorAvatar("".equals(authorAvatar) ? null : authorAvatar);
        comment.setAuthorUid("".equals(authorUid) ? null : authorUid);
        comment.setAuthorAlt("".equals(authorAlt) ? null : authorAlt);
        comment.setAuthorType("".equals(authorType) ? null : authorType);
        comment.setAuthorId("".equals(authorId) ? null : authorId);
        comment.setAuthorLargeAvatar("".equals(authorLargeAvatar) ? null : authorLargeAvatar);
        comment.setSummary("".equals(summary) ? null : summary);
        comment.setPublished("".equals(published) ? null : published);
        comment.setAlt("".equals(alt) ? null : alt);
        comment.setCId("".equals(cId) ? null : cId);
        commentRepository.save(comment);
        System.out.println("**************************** " + number + " save success ****************************");
        number++;
    }
}
