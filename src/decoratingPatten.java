import java.sql.SQLOutput;

abstract class Beverage{
    String description = "제목 없음";

    public String getDescription(){
        return description;
    }

    public abstract double cost();
}


abstract class condiment extends Beverage{
    Beverage beverage;
    public abstract String getDescription();
}

class Espresso extends Beverage{
    public Espresso(){
        description = "에스프레소";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}

class Mocha extends condiment{
    public Mocha(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public double cost() {
       return beverage.cost()+.20;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription()+", 모카";
    }
}

public class decoratingPatten {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription());

        Beverage beverage1 = new Espresso();
        beverage1 = new Mocha(beverage1);
        System.out.println(beverage1.getDescription());
        System.out.println(beverage1.cost());

    }
}
