abstract class ActionGame{
    String name;
    WeaponBehavior weapon;

    public void fight(){
        weapon.useWeapon();
    }
    public void setWeapon(WeaponBehavior w){
        weapon = w;
    }

}
class King extends ActionGame{
    public King(){
        name = "king";
        weapon = new KnifeBehavior();
    }
}
class Queen extends ActionGame{
    public Queen(){
        name = "Queen";
        weapon = new BowAndArrowBehavior();
    }
}



interface WeaponBehavior{
    public void useWeapon();
}
class KnifeBehavior implements WeaponBehavior{
    @Override
    public void useWeapon() {
        System.out.println("칼로 벤다 싹!");
    }
}
class BowAndArrowBehavior implements WeaponBehavior{
    @Override
    public void useWeapon() {
        System.out.println("화살로 쏜다 슝슝");
    }
}





public class Game {
    public static void main(String[] args) {
        King k = new King();
        k.fight();
        k.setWeapon(new BowAndArrowBehavior());
        k.fight();

        Queen q = new Queen();
        q.fight();
        q.setWeapon(new KnifeBehavior());
        q.fight();
    }
}
