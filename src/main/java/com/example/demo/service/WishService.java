package com.example.demo.service;

import com.example.demo.entity.SpotWishTime;
import com.example.demo.entity.Wish;

import java.sql.Date;
import java.util.List;

public interface WishService {
    List<Wish> listAllWishes();
    List<Wish> listUserWishes(int userId);
    List<SpotWishTime> listSpotWishTime(int spotId);
    int insertWish(Wish wish);
    boolean cancelWish(int wishId);
}
