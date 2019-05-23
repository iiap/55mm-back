package com.example.fivefivemm.service.Implements;

import com.example.fivefivemm.entity.message.Message;
import com.example.fivefivemm.entity.user.User;
import com.example.fivefivemm.repository.MessageRepository;
import com.example.fivefivemm.service.MessageService;
import com.example.fivefivemm.utility.Result;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * 消息业务类
 *
 * @author tiga
 * @version 1.0
 * @since 2019年5月22日19:01:31
 */
@Service
public class MessageServiceImplements implements MessageService {

    @Resource
    private MessageRepository messageRepository;

    private Logger logger = LogManager.getLogger(this.getClass());

    @Override
    @Transactional
    public Result CreateMessage(Message message) {
        if (!isValidMessage(message)) {
            return new Result(Result.failed, "参数不合法");
        }

        //验证action和user是否有效

        Message existMessage = messageRepository.findByActionAndWatcher(message.getAction(), message.getUser());
        if (existMessage != null) {
            return new Result(Result.failed, "消息已存在");
        }

        message.setActionAuthorId(message.getAction().getAuthor().getUserId());
        messageRepository.save(message);
        logger.info("生成新的消息:" + message);
        return new Result(Result.success);
    }

    @Override
    public Result RetrieveForWatcher(Integer watcherId) {
        if (watcherId == null) {
            return new Result(Result.failed, "watcherId为空");
        }
        List<Message> messageList = messageRepository.findByWatcher(new User(watcherId));
        return new Result(Result.success, messageList);
    }

    @Override
    public Result RetrieveForActionAuthorId(Integer actionAuthorId) {
        if (actionAuthorId == null) {
            return new Result(Result.failed, "actionAuthorId为空");
        }
        List<Message> messageList = messageRepository.findByActionAuthorId(actionAuthorId);
        return new Result(Result.success, messageList);
    }

    @Override
    @Transactional
    public Result UpdateIsAccept(Integer messageId, String accept) {
        Message existMessage = messageRepository.findByMessageId(messageId);
        if (existMessage == null) {
            return new Result(Result.failed, "消息不存在");
        }
        existMessage.setAccept(accept);
        logger.info("已回复约拍请求:" + existMessage);
        return new Result(Result.success);
    }

    @Override
    @Transactional
    public Result UpdateIsRead(Integer messageId) {
        Message existMessage = messageRepository.findByMessageId(messageId);
        if (existMessage == null) {
            return new Result(Result.failed, "消息不存在");
        }
        existMessage.setRead(true);
        logger.info("修改消息为已读:" + existMessage);
        return new Result(Result.success);
    }

    @Override
    @Transactional
    public Result DeleteMessage(Message message) {
        if (!isValidMessage(message)) {
            return new Result(Result.failed, "参数不合法");
        }
        Message existMessage = messageRepository.findByActionAndWatcher(message.getAction(), message.getUser());
        if (existMessage == null) {
            return new Result(Result.failed, "消息不存在");
        }
        messageRepository.deleteById(existMessage.getMessageId());
        logger.info("删除消息:" + existMessage);
        return new Result(Result.success);
    }

    private boolean isValidMessage(Message message) {
        if (message == null || message.getAction() == null || message.getUser() == null) {
            return false;
        }
        return true;
    }
}
