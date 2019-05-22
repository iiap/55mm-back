package com.example.fivefivemm.service;

import com.example.fivefivemm.entity.action.Action;
import com.example.fivefivemm.utility.Result;

import java.util.List;

public interface ActionService {

    /**
     * 发表动态
     *
     * @param action 动态对象
     * @return success data:保存的动态
     * failed message
     * 1.action对象为空
     * 2.作者Id为空
     */
    Result CreateAction(Action action);

    /**
     * 查询动态
     *
     * @param actionId 动态Id
     * @return success data:Action对象
     * failed message
     * 1.action对象为空
     * 2.该动态不存在
     */
    Result RetrieveAction(Integer actionId);

    /**
     * 获取所有动态
     *
     * @return 存在返回动态集合，不存在返回nullo
     */
    List<Action> RetrieveAllAction();

    /**
     * 修改动态
     *
     * @param action 动态对象
     * @return success
     * failed message
     * 1.action对象为空
     * 2.该动态不存在
     * 3.没有权限修改，您不是该动态的作者
     */
    Result UpdateAction(Action action);

    /**
     * 删除动态
     *
     * @param action 动态对象
     * @return success
     * faild message
     * 1.action对象为空
     * 2.该动态不存在
     * 3.没有权限删除，您不是该动态的作者
     */
    Result DeleteAction(Action action);
}
