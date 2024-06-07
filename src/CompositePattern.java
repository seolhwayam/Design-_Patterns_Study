import java.util.ArrayList;
import java.util.List;

abstract class MenuComponent{
    public void add(MenuComponent menuComponent){
        throw new UnsupportedOperationException();
    }

    public void remove(MenuComponent menuComponent){
        throw new UnsupportedOperationException();
    }

    public MenuComponent getChile(int i){
        throw new UnsupportedOperationException();
    }

    public String getName(){
        throw new UnsupportedOperationException();
    }

    public String getDescription(){
        throw new UnsupportedOperationException();
    }

    public double getPrice(){
        throw new UnsupportedOperationException();
    }

    public boolean isVegetarian(){
        throw new UnsupportedOperationException();
    }

    public void print(){
        throw new UnsupportedOperationException();
    }
}

class MenuItem extends MenuComponent{
    String name;
    String description;
    boolean vegetarian;
    double price;

    public MenuItem(String name, String description, boolean vegetarian, double price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean isVegetarian() {
        return vegetarian;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void print() {
        System.out.println("   "+getName());
        if (isVegetarian()){
            System.out.println("(v)");
        }
        System.out.println(", "+getPrice());
        System.out.println("    -- "+getDescription());
    }
}


class Menu extends MenuComponent{
    List<MenuComponent> menuComponents = new ArrayList<MenuComponent>();
    String name;
    String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    @Override
    public MenuComponent getChile(int i) {
       return menuComponents.get(i);
    }

    public String getName(){
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void print() {
        System.out.println("\n"+getName());
        System.out.println(", "+getDescription());
        System.out.println("------------------------");

        for(MenuComponent menuComponent :  menuComponents){
            menuComponent.print();
        }
    }
}

class Waitress{
    MenuComponent allMenus;

    public Waitress(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }

    public void printMenu(){
        allMenus.print();
    }
}

public class CompositePattern {
    public static void main(String[] args) {
        MenuComponent pancakeHouseMenu = new Menu("팬케이크 하우스 메뉴","아침 메뉴");
        MenuComponent dinerMenu = new Menu("객체 마을 식당 메뉴","점심 메뉴");
        MenuComponent cafeMenu = new Menu("카페 메뉴","저녁 메뉴");
        MenuComponent dessertMenu = new Menu("디저트 메뉴","디저트를 즐겨보세요");

        MenuComponent allMenus = new Menu("전체 메뉴","전체 메뉴");

        allMenus.add(pancakeHouseMenu);
        allMenus.add(dinerMenu);
        allMenus.add(cafeMenu);

        dinerMenu.add(new MenuItem("파스타","마리나라 소스 스파케디, 효모빵도 드립니다.",true,3.89));

        dinerMenu.add(dessertMenu);
        dessertMenu.add(new MenuItem("애플 파이","바삭바삭",true,1.59));

        Waitress waitress = new Waitress(allMenus);
        waitress.printMenu();
    }
}
