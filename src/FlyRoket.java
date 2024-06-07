interface Fly {
    public void fly();
}
class FlyBacis implements Fly {

    @Override
    public void fly() {
        System.out.println("날개짓 훨훨");
    }
}

public class FlyRoket implements Fly {

    @Override
    public void fly() {
        System.out.println("로켓달고 훨훨~~");
    }
}
class FlyRoketPowered implements Fly{

    @Override
    public void fly() {
        System.out.println("변경해서 로켓달고 훨훨");
    }
}
