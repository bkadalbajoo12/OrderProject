package repository;

import model.Order;
import dto.OrderDto;

import java.util.List;

public interface OrderRepositoryInterface {
    List<OrderDto> save(List<Order> orderList);
}
