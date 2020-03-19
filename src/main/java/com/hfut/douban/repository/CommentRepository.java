package com.hfut.douban.repository;

import com.hfut.douban.bean.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Chenzh
 */
public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
