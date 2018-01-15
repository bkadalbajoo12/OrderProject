package repository;

import model.Order;
import dto.OrderDto;

import java.util.List;
import java.util.stream.Collectors;

public class OrderRepositoryImpl implements OrderRepositoryInterface{
    public List<OrderDto> save(List<Order> orderList) {
        return orderList.stream().map(order -> {
                    OrderDto o = new OrderDto();
                    o.setItem(order.getItem());
                    o.setTime(Integer.toString(order.getTime()));
                    return o;
                }
        ).collect(Collectors.toList());
    }

}
