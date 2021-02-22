package order_handler;

import pizza_order.PizzaOrder;
import serializer.OrderSerializer;

public class MessageOrderHandler extends OrderHandler {
    private final OrderSerializer ORDERSERIALIZER;

    public MessageOrderHandler(OrderSerializer ORDERSERIALIZER) {
        super(OrderHandlerProject.Steps.MESSAGE);
        this.ORDERSERIALIZER = ORDERSERIALIZER;
    }

    @Override
    public void orderHandlerImpl(PizzaOrder pizzaOrder) {
        System.out.printf("Заказ %s принят в работу",
                ORDERSERIALIZER.serialize(pizzaOrder));
    }
}
