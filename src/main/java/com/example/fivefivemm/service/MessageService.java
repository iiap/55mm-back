package com.example.fivefivemm.service;

import com.example.fivefivemm.entity.message.Message;
import com.example.fivefivemm.utility.Result;

public interface MessageService {

    /**
     * 生成消息
     *
     * @param message 消息对象包含关注者用户Id，动态
     * @return failed message
     * 1.参数不合法
     * 2.消息已存在
     */
    Result CreateMessage(Message message);

    /**
     * 通过约拍者Id查找消息
     *
     * @param watcherId 约拍者用户Id
     * @return failed message
     * 1.watcherId为空
     */
    Result RetrieveForWatcher(Integer watcherId);

    /**
     * 通过动态的作者Id查找消息
     *
     * @param actionAuthorId 动态的作者Id
     * @return failed message
     * 1.actionAuthorId为空
     */
    Result RetrieveForActionAuthorId(Integer actionAuthorId);

    /**
     * 回复约拍请求
     *
     * @param messageId 消息Id
     * @return failed message
     * 1.参数不合法
     * 2.消息不存在
     */
    Result UpdateIsAccept(Integer messageId,String accept);

    /**
     * 浏览消息
     *
     * @param messageId 消息Id
     * @return failed message
     * 1.参数不合法
     * 2.消息不存在
     */
    Result UpdateIsRead(Integer messageId);

    /**
     * 删除消息
     *
     * @param message 消息对象包含messageId
     * @return failed message
     * 1.参数不合法
     * 2.消息不存在
     */
    Result DeleteMessage(Message message);
}
