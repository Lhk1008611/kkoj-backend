package com.lhk.kkoj.judge.strategy;

import com.lhk.kkoj.model.dto.questionsubmit.JudgeInfo;

/**
 * 判题策略接口
 */
public interface JudgeStrategy {
    /**
     * 执行判题
     * @param judgeContext
     * @return
     */
    JudgeInfo judge(JudgeContext judgeContext);
}
