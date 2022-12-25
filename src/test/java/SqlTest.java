import com.lkcoffee.mapper.UserMapper;
import org.junit.Test;

import javax.annotation.Resource;

public class SqlTest {

    @Resource
    private UserMapper userMapper;


    @Test
    public void getUserByPhoneNumber() {
        String phoneNumber = "15177386668";
    }
}
