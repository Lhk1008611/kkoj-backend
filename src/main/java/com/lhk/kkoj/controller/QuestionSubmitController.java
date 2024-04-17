package com.lhk.kkoj.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhk.kkoj.common.BaseResponse;
import com.lhk.kkoj.common.ErrorCode;
import com.lhk.kkoj.common.ResultUtils;
import com.lhk.kkoj.exception.BusinessException;
import com.lhk.kkoj.exception.ThrowUtils;
import com.lhk.kkoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.lhk.kkoj.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.lhk.kkoj.model.entity.QuestionSubmit;
import com.lhk.kkoj.model.entity.User;
import com.lhk.kkoj.model.vo.QuestionSubmitVO;
import com.lhk.kkoj.service.QuestionSubmitService;
import com.lhk.kkoj.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 题目提交接口
 *
 */
@RestController
@RequestMapping("/question_submit")
@Slf4j
public class QuestionSubmitController {

    @Resource
    private QuestionSubmitService questionSubmitService;

    @Resource
    private UserService userService;

    /**
     * 题目提交/ 取消题目提交
     *
     * @param questionSubmitAddRequest
     * @param request
     * @return resultNum 本次题目提交变化数
     */
    @PostMapping("/")
    public BaseResponse<Long> doQuestionSubmit(@RequestBody QuestionSubmitAddRequest questionSubmitAddRequest,
                                       HttpServletRequest request) {
        if (questionSubmitAddRequest == null || questionSubmitAddRequest.getQuestionId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 登录才能题目提交
        final User loginUser = userService.getLoginUser(request);
        long questionSubmitId = questionSubmitService.doQuestionSubmit(questionSubmitAddRequest, loginUser);
        return ResultUtils.success(questionSubmitId);
    }

    /**
     * 分页获取题目提交信息列表（管理员查询题目提交信息）
     *
     * @param questionSubmitQueryRequest
     * @return Page<QuestionSubmit>
     */
    @PostMapping("/list/page")
    public BaseResponse<Page<QuestionSubmit>> listQuestionSubmitByPage(@RequestBody QuestionSubmitQueryRequest questionSubmitQueryRequest) {
        long current = questionSubmitQueryRequest.getCurrent();
        long size = questionSubmitQueryRequest.getPageSize();
        Page<QuestionSubmit> questionSubmitPage = questionSubmitService.page(new Page<>(current, size),
                questionSubmitService.getQueryWrapper(questionSubmitQueryRequest));
        return ResultUtils.success(questionSubmitPage);
    }

    /**
     * 分页获取脱敏的题目提交信息列表
     *
     * @param questionSubmitQueryRequest
     * @param request Page<QuestionSubmitVO>
     * @return
     */
    @PostMapping("/list/page/vo")
    public BaseResponse<Page<QuestionSubmitVO>> listQuestionSubmitVOByPage(@RequestBody QuestionSubmitQueryRequest questionSubmitQueryRequest,
                                                                     HttpServletRequest request) {
        long current = questionSubmitQueryRequest.getCurrent();
        long size = questionSubmitQueryRequest.getPageSize();
        // 限制爬虫
        ThrowUtils.throwIf(size > 20, ErrorCode.PARAMS_ERROR);
        Page<QuestionSubmit> questionSubmitPage = questionSubmitService.page(new Page<>(current, size),
                questionSubmitService.getQueryWrapper(questionSubmitQueryRequest));
        //获取登录用户
        final User loginUser = userService.getLoginUser(request);
        return ResultUtils.success(questionSubmitService.getQuestionSubmitVOPage(questionSubmitPage, loginUser));
    }

}
