package order_handler;

import exception.ParseOrderException;
import pizza_order.PizzaOrder;
import serializer.OrderSerializer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveOrderHandler extends OrderHandler {
    private final String FILEORDER;
    private final OrderSerializer ORDERSERIALIZER;

    public SaveOrderHandler(String FILEORDER, OrderSerializer ORDERSERIALIZER) {
        super(OrderHandlerProject.Steps.SAVE);
        this.FILEORDER = FILEORDER;
        this.ORDERSERIALIZER = ORDERSERIALIZER;
    }

   @Override
    public void orderHandlerImpl(PizzaOrder pizzaOrder) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILEORDER, true))) {
            writer.write(ORDERSERIALIZER.serialize(pizzaOrder) + "\r\n");
            System.out.println("Заказ записан в файл");
            writer.flush();
        } catch (IOException e) {
            new ParseOrderException().getMessage();
        }
    }
}
