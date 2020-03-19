package com.hfut.douban.service;

import com.hfut.douban.bean.AllInfo;
import com.hfut.douban.repository.AllInfoRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Chenzh
 */
@Service
public class AllInfoService {

    @Resource
    AllInfoRepository allInfoRepository;

    public List<AllInfo> queryAllInfos() {
        return allInfoRepository.findAll();
    }
}
