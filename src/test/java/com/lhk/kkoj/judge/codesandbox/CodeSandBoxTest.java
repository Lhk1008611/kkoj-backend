package com.lhk.kkoj.judge.codesandbox;

import com.lhk.kkoj.judge.codesandbox.impl.ExampleCodeSandBox;
import com.lhk.kkoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.lhk.kkoj.model.enums.QuestionLanguageEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class CodeSandBoxTest {

    @Value("${codesandbox.type:example}")
    private String type;

    @Test
    void executeCode() {
        CodeSandBox codeSandBox = new CodeSandBoxFactory().newInstance(type);
        CodeSandBoxProxy codeSandBoxProxy = new CodeSandBoxProxy(codeSandBox);
        String code = "public class Main {public static void main(String[] args) {System.out.println(\"Hello World\");}}";
        String language = QuestionLanguageEnum.JAVA.getValue();
        List<String> inputList = Arrays.asList("1 2", "3 4");

        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .inputList(inputList)
                .language(language)
                .code(code)
                .build();
        codeSandBoxProxy.executeCode(executeCodeRequest);
    }
}