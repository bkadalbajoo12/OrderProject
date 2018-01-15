import model.Order;
import service.PizzaOrderImplementation;
import dto.OrderDto;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class PizzaOrderImplTest {

    private PizzaOrderImplementation pizzaOrderImplementation = new PizzaOrderImplementation();

    @Test
    public void whenUnorderedList_thenArrange() {
        Order o1 = new Order();
        o1.setItem("Pizza");
        o1.setTime(21);

        Order o2 = new Order();
        o2.setItem("pizza");
        o2.setTime(18);

        Order o3 = new Order();
        o3.setItem("bread");
        o3.setTime(21);

        Order o4 = new Order();
        o4.setItem("b2ead");
        o4.setTime(10);

        List<Order> orderList = new ArrayList<Order>();
        orderList.add(o1);
        orderList.add(o2);
        orderList.add(o3);
        orderList.add(o4);

        List<OrderDto> result = pizzaOrderImplementation.arrangeInOrder(orderList);
        Assert.assertEquals("First item is not correct","b2ead",result.get(0).getItem());
        Assert.assertEquals("Second item is not correct","pizza",result.get(1).getItem());
        Assert.assertEquals("Third item is not correct","Pizza",result.get(2).getItem());
        Assert.assertEquals("Fourth item is not correct","bread",result.get(3).getItem());
    }
}
