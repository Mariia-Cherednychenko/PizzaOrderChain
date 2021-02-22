package serializer;

import exception.ParseOrderException;
import pizza_order.PizzaOrder;
import pizza_order.PizzaType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class PerfoundOrderSerializer implements OrderSerializer {
    private final static String PATTERN = "((\\w+) (\\d+))";

    public String serialize(PizzaOrder order) {
        return ("пицца "+order.getPizzaOrder().toString());
    }

    public PizzaOrder deserialize(String s) throws ParseOrderException {
        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(s);

            if (matcher.matches()) {
                String order = matcher.group(1);
                Integer quantity = Integer.valueOf(matcher.group(2));
                PizzaOrder customerOrder = new PizzaOrder();
                try {
                    customerOrder.getPizzaOrder().put(PizzaType.valueOf(order.toUpperCase()), quantity);

                    return customerOrder;
                } catch (Exception e) {
                    throw new ParseOrderException();
                }
            }
        throw new ParseOrderException();
    }

}
