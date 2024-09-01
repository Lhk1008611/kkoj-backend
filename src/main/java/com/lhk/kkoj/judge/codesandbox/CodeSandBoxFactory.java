package com.lhk.kkoj.judge.codesandbox;

import com.lhk.kkoj.judge.codesandbox.impl.ExampleCodeSandBox;
import com.lhk.kkoj.judge.codesandbox.impl.RemoteCodeSandBox;
import com.lhk.kkoj.judge.codesandbox.impl.ThirdPartyCodeSandBox;

/**
 * 静态代码沙箱工厂类
 */
public class CodeSandBoxFactory {

    /**
     * 获取对应的沙箱实例
     *
     * @param type 沙箱类型
     * @return
     */
    public static CodeSandBox newInstance(String type) {
        switch (type){
            case "remote":
                return new RemoteCodeSandBox();
            case "thirdParty":
                return new ThirdPartyCodeSandBox();
            default:
                return new ExampleCodeSandBox();
        }
    }
}
