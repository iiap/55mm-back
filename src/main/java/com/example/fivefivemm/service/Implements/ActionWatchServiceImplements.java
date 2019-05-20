package com.example.fivefivemm.service.Implements;

import com.example.fivefivemm.entity.relation.ActionWatch;
import com.example.fivefivemm.repository.ActionWatchRepository;
import com.example.fivefivemm.service.ActionWatchService;
import com.example.fivefivemm.utility.Result;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * 约拍信息业务类
 *
 * @author tiga
 * @version 1.0
 * @since 2019年5月20日18:28:16
 */
@Service
public class ActionWatchServiceImplements implements ActionWatchService {

    @Resource
    private ActionWatchRepository actionWatchRepository;

    private Logger logger = LogManager.getLogger(this.getClass());

    @Override
    @Transactional
    public Result CreateActionWatch(ActionWatch actionWatch) {
        if (actionWatch == null) {
            return new Result(Result.failed, "actionWatch对象为空");
        }
        if (actionWatch.getAction() == null || actionWatch.getWatcher() == null) {
            return new Result(Result.failed, "用户Id或动态Id为空");
        }

        //验证action和user是否有效

        ActionWatch existActionWatch = actionWatchRepository.findByActionAndWatcher(actionWatch.getAction(), actionWatch.getWatcher());
        if (existActionWatch != null) {
            return new Result(Result.failed, "约拍记录已存在");
        }
        actionWatchRepository.save(actionWatch);
        logger.info("生成新的约拍记录:" + actionWatch);
        return new Result(Result.success);
    }

    @Override
    public boolean RetrieveActionWatch(ActionWatch actionWatch) {
        if (actionWatch == null) {
            return false;
        }
        if (actionWatch.getAction() == null || actionWatch.getWatcher() == null) {
            return false;
        }
        ActionWatch existActionWatch = actionWatchRepository.findByActionAndWatcher(actionWatch.getAction(), actionWatch.getWatcher());
        if (existActionWatch == null) {
            return false;
        }
        logger.info("查询约拍记录:" + existActionWatch);
        return true;
    }

    @Override
    @Transactional
    public Result DeleteActionWatch(ActionWatch actionWatch) {
        if (actionWatch == null) {
            return new Result(Result.failed, "actionWatch对象为空");
        }
        if (actionWatch.getAction() == null || actionWatch.getWatcher() == null) {
            return new Result(Result.failed, "用户Id或动态Id为空");
        }
        ActionWatch existActionWatch = actionWatchRepository.findByActionAndWatcher(actionWatch.getAction(), actionWatch.getWatcher());
        if (existActionWatch == null) {
            return new Result(Result.failed, "该约拍记录不存在");
        }
        actionWatchRepository.deleteById(existActionWatch.getActionWatchId());
        logger.info("删除约拍记录:" + existActionWatch);
        return new Result(Result.success);
    }
}
