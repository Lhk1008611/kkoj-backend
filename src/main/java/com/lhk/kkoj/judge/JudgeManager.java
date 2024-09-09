package com.lhk.kkoj.judge;

import com.lhk.kkoj.judge.strategy.DefaultJudgeStrategyImpl;
import com.lhk.kkoj.judge.strategy.JavaJudgeStrategyImpl;
import com.lhk.kkoj.judge.strategy.JudgeContext;
import com.lhk.kkoj.judge.strategy.JudgeStrategy;
import com.lhk.kkoj.judge.codesandbox.model.JudgeInfo;
import com.lhk.kkoj.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * 判题策略管理
 */
@Service
public class JudgeManager {
    /**
     * 区分不同的判题策略，执行判题
     * @param judgeContext
     * @return
     */
    public JudgeInfo judge(JudgeContext judgeContext){
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategyImpl();
        if (language.equals("java")){
            judgeStrategy = new JavaJudgeStrategyImpl();
        }
        return judgeStrategy.judge(judgeContext);
    }
}
