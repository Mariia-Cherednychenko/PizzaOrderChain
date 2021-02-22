package pizza_order;

import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
public class PizzaOrder {
    Map<PizzaType, Integer> pizzaOrder;


    public PizzaOrder(String customerOrder, Integer quantity) {
        pizzaOrder = new HashMap<PizzaType,Integer>();
        addPizzaOrder(customerOrder,quantity);
    }

    public Map<PizzaType, Integer> getPizzaOrder() {
        return pizzaOrder;
    }

    public void addPizzaOrder(String customerOrder, Integer quantity) {
        this.pizzaOrder.put(PizzaType.valueOf(customerOrder.toUpperCase()),quantity);
    }

}
