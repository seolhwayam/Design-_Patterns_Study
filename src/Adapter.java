import java.sql.SQLOutput;

interface DuckInterface{
    public void quack();
    public void fly();
}

class MallardDuck implements DuckInterface{

    @Override
    public void quack() {
        System.out.println("꽥!");
    }

    @Override
    public void fly() {
        System.out.println("날고 있어요!");
    }
}

interface TurkeyInterface{
    public void gobble();
    public void fly();
}

class WildTurkey implements TurkeyInterface{

    @Override
    public void gobble() {
        System.out.println("골골");
    }

    @Override
    public void fly() {
        System.out.println("짧은 거리를 날고 있어요!");
    }
}

class TurkeyAdapter implements DuckInterface{
    TurkeyInterface turkey;

    public TurkeyAdapter(TurkeyInterface turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        turkey.fly();
    }
}

class DuckAdapter implements TurkeyInterface{
    DuckInterface duck;

    public DuckAdapter(DuckInterface duck) {
        this.duck = duck;
    }

    @Override
    public void gobble() {
        duck.quack();
    }

    @Override
    public void fly() {
        duck.fly();
    }
}

public class Adapter {
    static void testDuck(DuckInterface duck){
        duck.quack();
        duck.fly();
    }

    static void testTurkey(TurkeyInterface turkey){
        turkey.gobble();
        turkey.fly();
    }

    public static void main(String[] args) {
        DuckInterface duck = new MallardDuck(); // 진짜 오리
        TurkeyInterface duckAdapter = new DuckAdapter(duck);

        TurkeyInterface turkey = new WildTurkey(); //진짜 칠면조
        DuckInterface turkeyAdapter = new TurkeyAdapter(turkey); //칠면조가 오리가 되기

        System.out.println("칠면조가 말하길");
        testTurkey(turkey);

        System.out.println("오리가 말하길");
        testDuck(duck);

        System.out.println("칠면조 어탭터가 말하길");
        testDuck(turkeyAdapter);

        System.out.println("오리 어탭터가 말하길");
        testTurkey(duckAdapter);

    }
}
