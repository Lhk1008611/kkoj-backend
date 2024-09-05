package com.lhk.kkoj.judge;

import com.lhk.kkoj.model.entity.QuestionSubmit;

/**
 * 判题服务
 */
public interface JudgeService {
    /**
     * 执行判题
     * @param questionSubmitId 题目提交 id
     * @return
     */
    QuestionSubmit JudgeQuestion(Long questionSubmitId);
}
