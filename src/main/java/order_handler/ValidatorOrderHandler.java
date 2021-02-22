package order_handler;

import pizza_order.PizzaOrder;
import serializer.OrderSerializer;

public class ValidatorOrderHandler extends OrderHandler {
    private final OrderSerializer ORDERSERIALIZER;

     public ValidatorOrderHandler(OrderSerializer ORDERSERIALIZER) {
        super(OrderHandlerProject.Steps.VALIDATE);
        this.ORDERSERIALIZER = ORDERSERIALIZER;
    }


    @Override
    public void orderHandlerImpl(PizzaOrder order) {
            System.out.println("Ваш заказ - " + ORDERSERIALIZER.serialize((PizzaOrder)order));

    }
}
