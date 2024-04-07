package com.lhk.kkoj.model.dto.question;

import lombok.Data;

/**
 * 判题用例
 */
@Data
public class JudgeCase {

    /**
     * 输入用例
     */
    public String input;

    /**
     * 输出用例
     */
    public String output;

}
