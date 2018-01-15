package service;

import model.Order;
import dto.OrderDto;

import java.util.List;
import java.io.File;

public interface PizzaOrderInterface {

    List<Order> readInputFile(File inputFile);
    List<OrderDto> arrangeInOrder(List<Order> unorderedItems);
    void writeOutputFile(File outputFile, List<OrderDto> orderedItems);
}
