import cn.hutool.crypto.digest.DigestUtil;
import com.lkcoffee.utils.AliyunSendSmsService;
import org.junit.Test;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SmsTest {


    @Test
    public void sendSms() {
        String phone = "15177386668";
        String templateCode = "SMS_262475457";
        // 验证码存入codeMap
        Map<String, Object> codeMap = new HashMap<>();
        String code = String.valueOf((int) (Math.random() * 9000 + 1000));
        codeMap.put("code", code);
        Boolean bool = AliyunSendSmsService.sendMessage(phone, templateCode, codeMap);
        System.out.println(codeMap.get("code"));
        System.out.println(bool);
    }


    @Test
    public void test111() {
        String qiuyue = DigestUtil.md5Hex("qiuyue");
        System.out.println(qiuyue);
    }

}
