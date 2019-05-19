package com.example.fivefivemm.repository;

import com.example.fivefivemm.entity.action.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 动态仓库
 *
 * @author tiga
 * @version 1.0
 * @since 2019年5月19日12:55:48
 */
@Repository
public interface ActionRepository extends JpaRepository<Action, Integer> {

    /**
     * 通过动态Id查找Action
     *
     * @param actionId 动态Id
     * @return 存在动态返回该动态，不存在返回null
     */
    Action findByActionId(Integer actionId);

    /**
     * 通过动态Id删除Action
     *
     * @param actionId 动态Id
     */
    void deleteByActionId(Integer actionId);
}
