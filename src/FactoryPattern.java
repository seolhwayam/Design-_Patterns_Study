import java.util.ArrayList;
import java.util.List;

//피자 만들기
abstract class Pizza{
    String name;
    String dough;
    String sauce;
    List<String> toppings = new ArrayList<String>();
    public void prepare(){
        System.out.println("준비중 : " +  name);
        System.out.println("도우를 돌리는 중");
        System.out.println("소스를 뿌리는 중");
        System.out.println("토핑 올리는 중");
        for( String topping :  toppings){
            System.out.println(" "+topping);
        }
    }
     void bake(){
        System.out.println("175도에서 25분 간 굽기");
    }
    void cut(){
        System.out.println("피자 사선으로 샤샥");
    }
    void box(){
        System.out.println("상자에 담기");
    }
    String getName(){
        return name;
    }

}
// 다양한 피자
class MyCheesPizza extends Pizza{
    public MyCheesPizza(){ //생성자
        name = "뉴욕 치즈 피자";
        dough = "아주 두꺼운 크러스트 도우";
        sauce = "플럼토마토 소스";

        toppings.add("잘게 조각낸 시험지 조각");
    }

    void cut(){ //메소드 오버라이딩
        System.out.println("네모난 모양으로 자륵;");
    }
}
class MyHamPizza extends Pizza{
    public MyHamPizza(){ //생성자
        name = "뉴욕 햄 피자";
        dough = "아주 얇은 도우";
        sauce = "몰라몰라 소스";

        toppings.add("햄햄햄햄 조각");
    }

    void cut(){ //메소드 오버라이딩
        System.out.println("햄 모양으로 자륵;");
    }
}
class ChicagoCheesPizza extends Pizza{
    public ChicagoCheesPizza(){ //생성자
        name = "시카고 치즈 피자";
        dough = "시카고 치즈 도우";
        sauce = "시카고 치즈 소스";

        toppings.add("시카고 치즈 조각");
    }

    void bake(){ //메소드 오버라이딩
        System.out.println("시카고 치즈로 굽기");
    }
}

class ChicagoHamPizza extends Pizza{
    public ChicagoHamPizza(){ //생성자
        name = "시카고 햄 피자";
        dough = "시카고 햄 도우";
        sauce = "시카고 햄 소스";

        toppings.add("시카고 치즈 조각");
    }

    void box(){ //메소드 오버라이딩
        System.out.println("시카고 햄으로 상자에 담기");
    }
}
abstract class PizzaStore {
    public Pizza orderPizza(String type) {
        Pizza pizza;
        pizza = createdPizza(type);

        if (pizza != null) {
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        } else {
            System.out.println("지원하지 않는 피자 타입입니다.");
        }

        return pizza;
    }

    abstract Pizza createdPizza(String type);
}

class NyPizzaStore extends PizzaStore {
    @Override
    Pizza createdPizza(String type) {
        if (type.equals("치즈")) {
            return new MyCheesPizza();
        } else if (type.equals("페퍼로니")) {
            return new MyHamPizza();
        } else {
            return null;
        }
    }
}

class ChicagoPizzaStore extends PizzaStore {
    @Override
    Pizza createdPizza(String type) {
        if (type.equals("치츠")) {
            return new ChicagoCheesPizza();
        } else if (type.equals("페퍼로니")) {
            return new ChicagoHamPizza();
        } else {
            return null;
        }
    }
}

public class FactoryPattern {
    public static void main(String[] args) {
        PizzaStore nyStore = new NyPizzaStore();
        Pizza p = nyStore.orderPizza("치즈");
    }
}
