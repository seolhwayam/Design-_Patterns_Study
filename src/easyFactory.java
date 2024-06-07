import java.util.ArrayList;
import java.util.List;

abstract class easyPizza {
    String name;
    String dough;
    String sauce;
    List<String> toppings = new ArrayList<String>();

    public void prepare() {
        System.out.println("준비중 : " + name);
        System.out.println("도우를 돌리는 중");
        System.out.println("소스를 뿌리는 중");
        System.out.println("토핑 올리는 중");
        for (String topping : toppings) {
            System.out.println(" " + topping);
        }
    }

    void bake() {
        System.out.println("175도에서 25분 간 굽기");
    }

    void cut() {
        System.out.println("피자 사선으로 샤샥");
    }

    void box() {
        System.out.println("상자에 담기");
    }

    String getName() {
        return name;
    }
}
class ChreesPizza extends  easyPizza{
    public ChreesPizza(){
        name = "치츠피자";
    }
}

class pepperoni extends  easyPizza{
    public pepperoni(){

    }
}

class SimplePizzaFactory{
    public easyPizza createPizza(String type){
        easyPizza pizza = null;
        if(type.equals("치즈")){
            pizza = new ChreesPizza();
        }else if(type.equals("페퍼로니")){
            pizza = new pepperoni();
        }
        return pizza;
    }
}

class PizzaStore2{
    SimplePizzaFactory factory;

    public PizzaStore2(SimplePizzaFactory factory){
        this.factory = factory;
    }

    public easyPizza orderPizza(String type){
        easyPizza pizza;
        pizza = factory.createPizza(type);

        pizza.prepare();

        return pizza;
    }
}

public class easyFactory {
    public static void main(String[] args) {
        PizzaStore2 p = new PizzaStore2(new SimplePizzaFactory());
        p.orderPizza("치즈");
    }
}
