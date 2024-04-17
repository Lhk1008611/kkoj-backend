package com.lhk.kkoj.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lhk.kkoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.lhk.kkoj.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.lhk.kkoj.model.entity.QuestionSubmit;
import com.lhk.kkoj.model.entity.User;
import com.lhk.kkoj.model.vo.QuestionSubmitVO;

import javax.servlet.http.HttpServletRequest;


/**
* @author Lhk
* @description 针对表【question_submit(题目提交表)】的数据库操作Service
* @createDate 2024-03-27 20:31:08
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {
    /**
     * 题目提交（新增一笔题目提交记录）
     *
     * @param questionSubmitAddRequest
     * @param loginUser
     * @return 题目提交id
     */
    long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);

    /**
     * 获取查询条件
     *
     * @param questionSubmitQueryRequest
     * @return
     */
    QueryWrapper<QuestionSubmit> getQueryWrapper(QuestionSubmitQueryRequest questionSubmitQueryRequest);

    /**
     * 获取题目提交封装
     *
     * @param questionSubmit
     * @param loginUser
     * @return
     */
    QuestionSubmitVO getQuestionSubmitVO(QuestionSubmit questionSubmit, User loginUser);

    /**
     * 分页获取题目封装
     *
     * @param questionSubmitPage
     * @param loginUser
     * @return
     */
    Page<QuestionSubmitVO> getQuestionSubmitVOPage(Page<QuestionSubmit> questionSubmitPage, User loginUser);

}
