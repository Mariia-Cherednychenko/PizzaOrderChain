import order_handler.*;
import pizza_order.PizzaOrder;
import serializer.OrderSerializer;
import serializer.PerfoundOrderSerializer;

public class Main {
    public static void main(String[] args) {
        OrderSerializer orderSerializer = new PerfoundOrderSerializer();
        String FILEORDER = "fileOrder.txt";
        PizzaOrder pizzaOrder = new PizzaOrder("vegitarian", 1);


        OrderHandlerProject orderHandlerProject= new OrderHandlerProject(
                OrderHandlerProject.Steps.VALIDATE,
                OrderHandlerProject.Steps.SAVE,
                OrderHandlerProject.Steps.MESSAGE
        );

        OrderHandler validatorStep = new ValidatorOrderHandler
                (orderSerializer);
        OrderHandler saveStep = new SaveOrderHandler
                (FILEORDER, orderSerializer);
        OrderHandler messageStep = new MessageOrderHandler
                (orderSerializer);

        OrderHandler result = validatorStep
                .setOrderHandlerNext(saveStep)
                .setOrderHandlerNext(messageStep);

        validatorStep.placeOrder(orderHandlerProject, pizzaOrder);

    }

}