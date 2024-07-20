package com.ela.myLLM.qianFanAi;

import com.baidubce.qianfan.Qianfan;
import com.baidubce.qianfan.model.chat.ChatResponse;

import com.baidubce.qianfan.model.exception.ApiException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin("*")
public class qianFanAiController {
    @RequestMapping("/llm/qianfan")
    @ResponseBody
    public static String qianfan(String prompt) {
        String AK=System.getenv("baiduAK");
        String SK=System.getenv("baiduSK");
        // 使用安全认证AK/SK鉴权，替换下列示例中参数，安全认证Access Key替换your_iam_ak，Secret Key替换your_iam_sk
        Qianfan qianfan = new Qianfan(AK,SK);
        // 指定模型
        ChatResponse resp = qianfan.chatCompletion()
                .model("ERNIE-Tiny-8K")
                .addMessage("user", prompt)
                .execute();
        System.out.println(resp.getResult());
        return resp.getResult();
    }
}