package com.lhk.kkoj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lhk.kkoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.lhk.kkoj.model.entity.QuestionSubmit;
import com.lhk.kkoj.model.entity.User;


/**
* @author Lhk
* @description 针对表【question_submit(题目提交表)】的数据库操作Service
* @createDate 2024-03-27 20:31:08
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {
    /**
     * 点赞
     *
     * @param questionSubmitAddRequest
     * @param loginUser
     * @return 题目提交id
     */
    long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);

}
