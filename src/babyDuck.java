abstract class Duck {
    Fly fly;

    public void siwm(){
        System.out.println("열심히 수영한다.");
    }

    public void setFly(){
        fly.fly();
    }
    public void setFlyBehavior(Fly f){
        fly = f;
    }
    public void iwantmove(Fly f){
        fly =f;
    }

}
class tang {
    FlyBacis tt;
    tang(){
       tt  = new FlyBacis();
       tt.fly();
    }
}
 public class babyDuck extends Duck{
    public babyDuck(){
        fly = new FlyBacis();
    }
     public static void main(String[] args) {
         Duck baby = new babyDuck();
         baby.setFly();
         baby.iwantmove(new FlyRoket());
         baby.setFly();
         tang t = new tang();
     }

}