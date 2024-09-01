package com.lhk.kkoj.judge.codesandbox;

import com.lhk.kkoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.lhk.kkoj.judge.codesandbox.model.ExecuteCodeResponse;

/**
 * @description: 代码沙箱接口
 */
public interface CodeSandBox {
     /**
      * 执行代码
      * @param executeCodeRequest
      * @return ExecuteCodeResponse
      */
     ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
