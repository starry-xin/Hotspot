package com.example.demo.service.impl;

import com.example.demo.dao.WishDao;
import com.example.demo.entity.SpotOrderTime;
import com.example.demo.entity.SpotWishTime;
import com.example.demo.entity.Wish;
import com.example.demo.service.WishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

/**
 * 类名称: WishServiceImpl
 * 类描述: 想去 实现类
 *
 * @author: wqy
 * 创建时间: 2020/7/2 9:35 下午
 * Version 1.0
 */

@Service
public class WishServiceImpl implements WishService {
    @Autowired
    private WishDao wishDao;

    @Override
    public List<Wish> listAllWishes() {
        List<Wish> result = wishDao.listAllWishes();
        for (int i = 0; i < result.size(); ++i){
            result.get(i).formatTime();
        }
        return result;
    }

    @Override
    public List<Wish> listUserWishes(int userId) {
        List<Wish> result = wishDao.listUserWishes(userId);
        for (int i = 0; i < result.size(); ++i){
            result.get(i).formatTime();
        }
        return result;
    }

    @Override
    public List<SpotWishTime> listSpotWishTime(int spotId) {
        List<SpotWishTime> result = wishDao.listSpotWishTime(spotId);
        for (int i = 0; i < result.size(); ++i){
            result.get(i).formatTime();
        }
        return result;
    }

    @Transactional
    @Override
    public int insertWish(Wish wish) {
        try {
            int effectedNum = wishDao.insertWish(wish);
            if (effectedNum > 0)
                return wish.getWishId();
            else
                throw new RuntimeException("插入想去失败！");
        }catch (Exception e){
            throw new RuntimeException("插入想去失败：" + e.getMessage());
        }
    }

    @Transactional
    @Override
    public boolean cancelWish(int wishId) {
        try {
            int effectedNum = wishDao.cancelWish(wishId);
            if (effectedNum > 0)
                return true;
            else
                throw new RuntimeException("取消想去失败！");
        }catch (Exception e){
            throw new RuntimeException("取消想去失败："+e.getMessage());
        }
    }
}