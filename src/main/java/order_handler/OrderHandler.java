package order_handler;

import pizza_order.PizzaOrder;

public abstract class OrderHandler {
    private OrderHandler next;
    private final  OrderHandlerProject.Steps step;


    public OrderHandler(OrderHandlerProject.Steps step) {
        this.step = step;
    }

    public  abstract void orderHandlerImpl(PizzaOrder pizzaOrder);

    public void placeOrder (OrderHandlerProject project, PizzaOrder pizzaOrder) {
        if (project.getSteps().contains(step)) {
            orderHandlerImpl(pizzaOrder);
        }
        if (next!= null) {
            next.placeOrder(project,pizzaOrder);
        }
    }

    public OrderHandler setOrderHandlerNext (OrderHandler next){
        this.next = next;
        return next;
    }


}
