package com.example.fivefivemm.entity.relation;

import com.example.fivefivemm.entity.action.Action;
import com.example.fivefivemm.entity.user.User;

import javax.persistence.*;

@Entity
@Table(name = "message_watch")
public class MessageWatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer messageWatchId;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Action.class)
    @JoinColumn(name = "actionId", referencedColumnName = "actionId")
    private Action action;

    public Integer getMessageWatchId() {
        return messageWatchId;
    }

    public void setMessageWatchId(Integer messageWatchId) {
        this.messageWatchId = messageWatchId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
}
