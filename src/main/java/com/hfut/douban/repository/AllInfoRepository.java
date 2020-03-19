package com.hfut.douban.repository;

import com.hfut.douban.bean.AllInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Chenzh
 */

public interface AllInfoRepository extends JpaRepository<AllInfo, Integer> {

    /**
     * 通过书籍在豆瓣中的id来查询书籍
     *
     * @param dId 在豆瓣中的id
     * @return 查询的结果
     */
    List<AllInfo> findAllInfoBydId(String dId);
}
