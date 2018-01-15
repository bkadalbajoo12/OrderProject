package controller;

import model.Order;
import service.PizzaOrderImplementation;
import dto.OrderDto;

import java.util.List;
import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {

        File inputFile = new File(args[0]);
        File outputFile = new File(args[1]);

        PizzaOrderImplementation pizzaOrderImplementation = new PizzaOrderImplementation();

        List<Order> unorderedList = pizzaOrderImplementation.readInputFile(inputFile);
        List<OrderDto> orderedItems = pizzaOrderImplementation.arrangeInOrder(unorderedList);
        pizzaOrderImplementation.writeOutputFile(outputFile, orderedItems);

    }
}
