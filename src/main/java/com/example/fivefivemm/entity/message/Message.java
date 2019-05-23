package com.example.fivefivemm.entity.message;

import com.example.fivefivemm.entity.action.Action;
import com.example.fivefivemm.entity.user.User;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 消息表
 *
 * @author tiga
 * @version 1.0
 * @since 2019年5月11日19:12:22
 */
@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer messageId;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createTime;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = User.class)
    @JoinColumn(name = "watcherId", referencedColumnName = "userId")
    private User watcher;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Action.class)
    @JoinColumn(name = "actionId", referencedColumnName = "actionId")
    private Action action;

    private Integer actionAuthorId;

    private boolean isRead;

    private String isAccept;

    public Message() {
    }

    public Message(Action action, User watcher) {
        this.watcher = watcher;
        this.action = action;
        this.isAccept = "未读";
        this.isRead = false;
    }

    public Message(Action action, User watcher, Integer actionAuthorId) {
        this.watcher = watcher;
        this.action = action;
        this.actionAuthorId = actionAuthorId;
        this.isAccept = "未读";
        this.isRead = false;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public User getUser() {
        return watcher;
    }

    public void setUser(User watcher) {
        this.watcher = watcher;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public Integer getActionAuthorId() {
        return actionAuthorId;
    }

    public void setActionAuthorId(Integer actionAuthorId) {
        this.actionAuthorId = actionAuthorId;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public String isAccept() {
        return isAccept;
    }

    public void setAccept(String accept) {
        isAccept = accept;
    }

    @Override
    public String toString() {
        return "[消息:消息Id:" + messageId + ",约拍者Id:" + watcher.getUserId() + ",动态Id:" + action.getActionId() + "]";
    }
}
