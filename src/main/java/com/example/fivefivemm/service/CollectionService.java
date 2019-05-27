package com.example.fivefivemm.service;


import com.example.fivefivemm.utility.Result;

/**
 * 收藏业务类
 *
 * @author tiga
 * @version 1.0
 * @since 2019年5月27日11:18:49
 */
public interface CollectionService {

    /**
     * 收藏动态
     *
     * @param userId   用户Id
     * @param actionId 动态Id
     * @return Result
     * message
     * 1.不存在的用户或动态
     */
    Result addActionCollection(Integer userId, Integer actionId);

    /**
     * 取消收藏动态
     *
     * @param userId   用户Id
     * @param actionId 动态Id
     * @return Result
     * message
     * data
     */
    Result removeActionCollection(Integer userId, Integer actionId);

    /**
     * 查询动态收藏关系
     *
     * @param userId   用户Id
     * @param actionId 动态Id
     * @return
     */
    boolean findActionCollection(Integer userId, Integer actionId);

    /**
     * 关注用户
     *
     * @param focusId 关注的用户Id
     * @param fansId  粉丝用户Id
     * @return Result
     * message
     * data
     */
    Result addUserCollection(Integer focusId, Integer fansId);

    /**
     * 取消关注用户
     *
     * @param focusId 关注的用户Id
     * @param fansId  粉丝用户Id
     * @return Result
     * message
     * data
     */
    Result removeUserCollection(Integer focusId, Integer fansId);

    /**
     * 查询用户关注关系
     *
     * @param focusId 关注的用户Id
     * @param fansId  粉丝用户Id
     * @return
     */
    boolean findUserCollection(Integer focusId, Integer fansId);
}
