abstract class CaffeineBeverage{
    final void prepareRecipe(){ //자식클래스가 오버라이드 못하도록 final설정
       boilWater();
       brew();
       pourInCup();
       addCondiments();
    }

    abstract void brew(); // 서브클래스에게 구현 의존
    abstract void addCondiments(); // 서브클래스에게 구현 의존

    void boilWater(){
        System.out.println("물 끓이는 중");
    }

    void pourInCup(){
        System.out.println("컵에 따르는 중");
    }



}

class Tea extends CaffeineBeverage {

    @Override
    void brew() {
        System.out.println("찻잎을 우려내는 중");
    }

    @Override
    void addCondiments() {
        System.out.println("레몬을 추가하는 중");
    }
}

class Coffee extends CaffeineBeverage{

    @Override
    void brew() {
        System.out.println("필터로 커피를 우려내는 중");
    }

    @Override
    void addCondiments() {
        System.out.println("설탕과 우유를 추가하는 중");
    }
}

public class Template {
    public static void main(String[] args) {
        Tea myTea = new Tea();
        myTea.prepareRecipe();

        Coffee myCoffee = new Coffee();
        myCoffee.prepareRecipe();
    }
}
