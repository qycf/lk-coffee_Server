import com.lkcoffee.mapper.UserOrderMapper;
import com.lkcoffee.pojo.OrderGoodsVO;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

public class OrderTest {

    @Resource
    private UserOrderMapper userOrderMapper;


    @Test
    public void test() {
        List<OrderGoodsVO> orderGoodsListByOrderId = userOrderMapper.getOrderGoodsListByOrderId("5272");
        System.out.println(orderGoodsListByOrderId);
    }

}
