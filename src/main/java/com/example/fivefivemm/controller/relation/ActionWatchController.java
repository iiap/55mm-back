package com.example.fivefivemm.controller.relation;

import com.example.fivefivemm.entity.relation.ActionWatch;
import com.example.fivefivemm.service.ActionWatchService;
import com.example.fivefivemm.utility.Result;
import com.example.fivefivemm.utility.Utility;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 约拍记录控制器
 *
 * @author tiga
 * @version 1.0
 * @since 2019年5月20日18:34:16
 */
//生产环境
//@CrossOrigin(origins = "http://www.hylovecode.cn")
//本地测试
@CrossOrigin(origins = "http://localhost:8080")
@Controller
public class ActionWatchController {

    @Resource
    private ActionWatchService actionWatchService;

    /**
     * 生成约拍记录
     *
     * @param actionWatch 约拍记录对象
     * @return failed message
     * 101
     * 1.actionWatch对象为空
     * 2.用户Id或动态Id为空
     */
    @PostMapping("/actionWatch")
    @ResponseBody
    public String CreateActionWatch(@RequestBody ActionWatch actionWatch) {
        Result createActionWatchResult = actionWatchService.CreateActionWatch(actionWatch);
        if (createActionWatchResult.getStatus().equals(Result.success)) {
            return Utility.ResultBody(200, null, null);
        } else {
            return Utility.ResultBody(101, createActionWatchResult.getMessage(), null);
        }
    }

    /**
     * 删除约拍记录
     *
     * @param actionWatch 约拍记录对象
     * @return failed message
     * 102
     * 1.actionWatch对象为空
     * 2.用户Id或动态Id为空
     * 3.该约拍记录不存在
     */
    @DeleteMapping("/actionWatch")
    @ResponseBody
    public String DeleteActionWatch(@RequestBody ActionWatch actionWatch) {
        Result deleteActionWatchResult = actionWatchService.DeleteActionWatch(actionWatch);
        if (deleteActionWatchResult.getStatus().equals(Result.success)) {
            return Utility.ResultBody(200, null, null);
        } else {
            return Utility.ResultBody(102, deleteActionWatchResult.getMessage(), null);
        }
    }
}
