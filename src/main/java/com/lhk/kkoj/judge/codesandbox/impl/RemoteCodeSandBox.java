package com.lhk.kkoj.judge.codesandbox.impl;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.lhk.kkoj.common.ErrorCode;
import com.lhk.kkoj.exception.BusinessException;
import com.lhk.kkoj.judge.codesandbox.CodeSandBox;
import com.lhk.kkoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.lhk.kkoj.judge.codesandbox.model.ExecuteCodeResponse;
import org.apache.commons.lang3.StringUtils;

/**
 * 远端 docker 代码沙箱
 */
public class RemoteCodeSandBox implements CodeSandBox {

    private static final String AUTH_REQUEST_HEADER = "apiAuth";
    private static final String AUTH_REQUEST_SECRET = "secret";

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("远程代码沙箱");
        String url = "http://192.168.136.131:8102/executeJavaCode";
        String body = JSONUtil.toJsonStr(executeCodeRequest);
        String responseStr = HttpUtil.createPost(url)
                .header(AUTH_REQUEST_HEADER, AUTH_REQUEST_SECRET)
                .body(body)
                .execute()
                .body();
        if (StringUtils.isBlank(responseStr)){
            throw new BusinessException(ErrorCode.API_REQUEST_ERROR, "远程代码沙箱运行失败");
        }
        return JSONUtil.toBean(responseStr, ExecuteCodeResponse.class);
    }
}
