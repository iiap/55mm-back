package com.example.fivefivemm.repository;


import com.example.fivefivemm.entity.relation.UserCollection;
import com.example.fivefivemm.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.annotation.Resource;

@Resource
public interface UserCollectionRepository extends JpaRepository<UserCollection, Integer> {

    /**
     * 通过关注者和粉丝查找关注信息
     *
     * @param focus 关注者
     * @param fans  粉丝
     * @return 关注信息对象或null
     */
    UserCollection findByFocusAndFans(User focus, User fans);
}
