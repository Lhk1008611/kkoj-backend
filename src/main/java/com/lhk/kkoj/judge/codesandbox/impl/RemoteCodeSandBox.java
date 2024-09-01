package com.lhk.kkoj.judge.codesandbox.impl;

import com.lhk.kkoj.judge.codesandbox.CodeSandBox;
import com.lhk.kkoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.lhk.kkoj.judge.codesandbox.model.ExecuteCodeResponse;

/**
 * 远端 docker 代码沙箱
 */
public class RemoteCodeSandBox implements CodeSandBox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("远程代码沙箱");
        return null;
    }
}
