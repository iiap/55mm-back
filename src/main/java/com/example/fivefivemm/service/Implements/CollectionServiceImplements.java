package com.example.fivefivemm.service.Implements;

import com.example.fivefivemm.entity.action.Action;
import com.example.fivefivemm.entity.relation.ActionCollection;
import com.example.fivefivemm.entity.relation.UserCollection;
import com.example.fivefivemm.entity.user.User;
import com.example.fivefivemm.repository.ActionCollectionRepository;
import com.example.fivefivemm.repository.UserCollectionRepository;
import com.example.fivefivemm.service.ActionService;
import com.example.fivefivemm.service.CollectionService;
import com.example.fivefivemm.service.UserService;
import com.example.fivefivemm.utility.Result;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * 收藏业务类
 *
 * @author tiga
 * @version 1.0
 * @since 2019年5月27日12:35:00
 */
@Service
public class CollectionServiceImplements implements CollectionService {

    @Resource
    private UserService userService;

    @Resource
    private ActionService actionService;

    @Resource
    private ActionCollectionRepository actionCollectionRepository;

    @Resource
    private UserCollectionRepository userCollectionRepository;

    private Logger logger = LogManager.getLogger(this.getClass());

    @Override
    @Transactional
    public Result addActionCollection(Integer userId, Integer actionId) {
        if (userId == null || actionId == null) {
            return new Result(Result.failed, "参数不合法");
        }
        Result getUserResult = userService.retrieveInformation(userId);
        Result getActionResult = actionService.RetrieveAction(actionId);
        if (!getUserResult.getStatus().equals(Result.success) || !getActionResult.getStatus().equals(Result.success)) {
            return new Result(Result.failed, "不存在的用户或动态");
        }

        User validUser = (User) getUserResult.getData();
        Action validAction = (Action) getActionResult.getData();

        ActionCollection actionCollection = actionCollectionRepository.findByCollectorAndCollectAction(validUser, validAction);
        if (actionCollection != null) {
            return new Result(Result.failed, "已存在的收藏关系");
        }
        int collect = validAction.getCollect();
        validAction.setCollect(collect + 1);
        actionCollectionRepository.save(new ActionCollection(validUser, validAction));
        logger.info("保存收藏:" + " 收藏用户Id:" + validUser.getUserId() + ", 收藏动态Id:" + validAction.getActionId());
        return new Result(Result.success);
    }

    @Override
    @Transactional
    public Result removeActionCollection(Integer userId, Integer actionId) {
        if (userId == null || actionId == null) {
            return new Result(Result.failed, "参数不合法");
        }
        Result getUserResult = userService.retrieveInformation(userId);
        Result getActionResult = actionService.RetrieveAction(actionId);
        if (!getUserResult.getStatus().equals(Result.success) || !getActionResult.getStatus().equals(Result.success)) {
            return new Result(Result.failed, "不存在的用户或动态");
        }
        User validUser = (User) getUserResult.getData();
        Action validAction = (Action) getActionResult.getData();
        ActionCollection actionCollection = actionCollectionRepository.findByCollectorAndCollectAction(validUser, validAction);
        if (actionCollection == null) {
            return new Result(Result.failed, "不存在的收藏关系");
        }
        int collect = validAction.getCollect();
        validAction.setCollect(collect - 1);
        actionCollectionRepository.deleteById(actionCollection.getActionCollectionId());
        logger.info("删除收藏:" + " 收藏用户Id:" + validUser.getUserId() + ", 收藏动态Id:" + validAction.getActionId());
        return new Result(Result.success);
    }

    @Override
    public boolean findActionCollection(Integer userId, Integer actionId) {
        Result getUserResult = userService.retrieveInformation(userId);
        Result getActionResult = actionService.RetrieveAction(actionId);
        if (getUserResult.getStatus().equals(Result.success) && getActionResult.getStatus().equals(Result.success)) {
            User validUser = (User) getUserResult.getData();
            Action validAction = (Action) getActionResult.getData();
            ActionCollection actionCollection = actionCollectionRepository.findByCollectorAndCollectAction(validUser, validAction);
            return (actionCollection != null);
        } else {
            return false;
        }
    }

    @Override
    @Transactional
    public Result addUserCollection(Integer focusId, Integer fansId) {
        if (focusId == null || fansId == null) {
            return new Result(Result.failed, "参数不合法");
        }
        Result getFocusResult = userService.retrieveInformation(focusId);
        Result getFansResult = userService.retrieveInformation(fansId);
        if (!getFocusResult.getStatus().equals(Result.success) || !getFansResult.getStatus().equals(Result.success)) {
            return new Result(Result.failed, "不存在的用户");
        }

        User focus = (User) getFocusResult.getData();
        User fans = (User) getFansResult.getData();

        UserCollection userCollection = userCollectionRepository.findByFocusAndFans(focus, fans);
        if (userCollection != null) {
            return new Result(Result.failed, "已存在的关注关系");
        }

        userCollectionRepository.save(new UserCollection(focus, fans));
        logger.info("保存关注:" + " 关注用户Id:" + focus.getUserId() + ", 粉丝Id:" + fans.getUserId());
        return new Result(Result.success, null);

    }

    @Override
    @Transactional
    public Result removeUserCollection(Integer focusId, Integer fansId) {
        if (focusId == null || fansId == null) {
            return new Result(Result.failed, "参数不合法");
        }
        Result getFocusResult = userService.retrieveInformation(focusId);
        Result getFansResult = userService.retrieveInformation(fansId);
        if (!getFocusResult.getStatus().equals(Result.success) || !getFansResult.getStatus().equals(Result.success)) {
            return new Result(Result.failed, "不存在的用户");
        }

        User focus = (User) getFocusResult.getData();
        User fans = (User) getFansResult.getData();
        UserCollection userCollection = userCollectionRepository.findByFocusAndFans(focus, fans);
        if (userCollection == null) {
            return new Result(Result.failed, "不存在的关注关系");
        }
        userCollectionRepository.deleteById(userCollection.getUserCollectionId());
        logger.info("删除关注:" + " 关注用户Id:" + focus.getUserId() + ", 粉丝Id:" + fans.getUserId());
        return new Result(Result.success);
    }

    @Override
    public boolean findUserCollection(Integer focusId, Integer fansId) {
        Result getFocusResult = userService.retrieveInformation(focusId);
        Result getFansResult = userService.retrieveInformation(fansId);
        if (getFocusResult.getStatus().equals(Result.success) && getFansResult.getStatus().equals(Result.success)) {
            User focus = (User) getFocusResult.getData();
            User fans = (User) getFansResult.getData();
            UserCollection userCollection = userCollectionRepository.findByFocusAndFans(focus, fans);
            return (userCollection != null);
        } else {
            return false;
        }
    }
}
