package service;

import model.Order;
import repository.OrderRepositoryImpl;
import repository.OrderRepositoryInterface;
import dto.OrderDto;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PizzaOrderImplementation implements PizzaOrderInterface {
    private OrderRepositoryInterface repositoryInterface = new OrderRepositoryImpl();
    public List<Order> readInputFile(File inputFile) {
       List<Order> unorderedList = new ArrayList<Order>();
       try {
           FileReader fileReader = new FileReader(inputFile);
           BufferedReader bufferedReader = new BufferedReader(fileReader);
           String inputLine;
           bufferedReader.readLine();
           while ((inputLine = bufferedReader.readLine()) != null) {
               String[] orderItems = inputLine.split("\t\t");
               if(orderItems != null && orderItems[0] != null && orderItems[1] != null) {
                   Order o = new Order();
                   o.setItem(orderItems[0]);
                   o.setTime(Integer.parseInt(orderItems[1]));
                   unorderedList.add(o);
               }
           }
           fileReader.close();

       }catch (IOException e) {
           e.printStackTrace();
       }
        return unorderedList;
    }

    public List<OrderDto> arrangeInOrder(List<Order> unorderedItems) {
        List<Order> unorderedItemsCopy = new ArrayList<>(unorderedItems);
        unorderedItemsCopy.sort(Order::compareByTimeThenItem);
        return repositoryInterface.save(unorderedItemsCopy);
       }

    public void writeOutputFile(File outputFile, List<OrderDto> orderedItems) {
        try {
            FileWriter fileWriter = new FileWriter(outputFile);
            PrintWriter out = new PrintWriter(fileWriter);
            for (OrderDto outputLine : orderedItems) {
                out.println(outputLine.getItem() + " " + outputLine.getTime());
            }
            out.flush();
            out.close();
            fileWriter.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
