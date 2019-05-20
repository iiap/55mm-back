package com.example.fivefivemm.service;

import com.example.fivefivemm.entity.relation.ActionWatch;
import com.example.fivefivemm.utility.Result;

public interface ActionWatchService {

    /**
     * 生成约拍记录
     *
     * @param actionWatch 约拍记录对象
     * @return success
     * failed message
     * 1.actionWatch对象为空
     * 2.用户Id或动态Id为空
     * 3.约拍记录已存在
     */
    Result CreateActionWatch(ActionWatch actionWatch);

    /**
     * 查找约拍记录
     *
     * @param actionWatch 约拍记录对象
     * @return 存在记录返回true
     */
    boolean RetrieveActionWatch(ActionWatch actionWatch);

    /**
     * 删除约拍记录
     *
     * @param actionWatch 约拍记录对象
     * @return success
     * failed message
     * 1.actionWatch对象为空
     * 2.用户Id或动态Id为空
     * 3.该约拍记录不存在
     */
    Result DeleteActionWatch(ActionWatch actionWatch);
}
