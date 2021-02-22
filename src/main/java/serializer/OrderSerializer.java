package serializer;

import exception.ParseOrderException;
import pizza_order.PizzaOrder;

public interface OrderSerializer {
    String serialize (PizzaOrder order);
    PizzaOrder deserialize  (String s) throws ParseOrderException;
}
