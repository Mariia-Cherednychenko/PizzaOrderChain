package order_handler;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class OrderHandlerProject {
    private final Set steps = new HashSet<>();
    public enum Steps{
        VALIDATE,
        SAVE,
        MESSAGE
    }

    public OrderHandlerProject(Steps ... steps){
        this.steps.addAll(Arrays.asList(steps));
    }

    public  Set getSteps(){
        return steps;
    }
}
