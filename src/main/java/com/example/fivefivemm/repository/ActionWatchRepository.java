package com.example.fivefivemm.repository;

import com.example.fivefivemm.entity.action.Action;
import com.example.fivefivemm.entity.relation.ActionWatch;
import com.example.fivefivemm.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 约拍记录仓库
 *
 * @author tiga
 * @version 1.0
 * @since 2019年5月20日18:23:41
 */
@Repository
public interface ActionWatchRepository extends JpaRepository<ActionWatch, Integer> {

    /**
     * 通过动态和用户查找约拍记录
     *
     * @param action  动态
     * @param watcher 约拍用户
     * @return 存在约拍记录返回ActionWatch, 不存在返回null
     */
    ActionWatch findByActionAndWatcher(Action action, User watcher);
}
