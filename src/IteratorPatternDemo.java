import java.util.ArrayList;

// Iterator 인터페이스
interface Iterator {
    boolean hasNext();
    Object next();
}

// 배열 기반의 이터레이터
class ArrayMenuIterator implements Iterator {
    String[] items;
    int position = 0;

    public ArrayMenuIterator(String[] items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return position < items.length && items[position] != null;
    }

    @Override
    public Object next() {
        String menuItem = items[position];
        position += 1;
        return menuItem;
    }
}

// 배열 기반의 메뉴 클래스
class ArrayMenu {
    static final int MAX_ITEMS = 6;
    int numberOfItems = 0;
    String[] menuItems;

    public ArrayMenu() {
        menuItems = new String[MAX_ITEMS];
        addItem("Pancake");
        addItem("Waffle");
        addItem("Toast");
    }

    public void addItem(String name) {
        if (numberOfItems >= MAX_ITEMS) {
            System.out.println("Menu is full! Can't add item to menu");
        } else {
            menuItems[numberOfItems] = name;
            numberOfItems += 1;
        }
    }

    public Iterator createIterator() {
        return new ArrayMenuIterator(menuItems);
    }
}

// ArrayList 기반의 이터레이터
class ArrayListMenuIterator implements Iterator {
    ArrayList<String> items;
    int position = 0;

    public ArrayListMenuIterator(ArrayList<String> items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return position < items.size();
    }

    @Override
    public Object next() {
        String menuItem = items.get(position);
        position += 1;
        return menuItem;
    }
}

// ArrayList 기반의 메뉴 클래스
class ArrayListMenu {
    ArrayList<String> menuItems;

    public ArrayListMenu() {
        menuItems = new ArrayList<>();
        addItem("Burger");
        addItem("Fries");
        addItem("Shake");
    }

    public void addItem(String name) {
        menuItems.add(name);
    }

    public Iterator createIterator() {
        return new ArrayListMenuIterator(menuItems);
    }
}

// 클라이언트 코드
public class IteratorPatternDemo {
    public static void main(String[] args) {
        ArrayMenu arrayMenu = new ArrayMenu();
        ArrayListMenu arrayListMenu = new ArrayListMenu();

        Iterator arrayIterator = arrayMenu.createIterator();
        Iterator arrayListIterator = arrayListMenu.createIterator();

        System.out.println("Array Menu:");
        printMenu(arrayIterator);

        System.out.println("\nArrayList Menu:");
        printMenu(arrayListIterator);
    }

    public static void printMenu(Iterator iterator) {
        while (iterator.hasNext()) {
            String menuItem = (String) iterator.next();
            System.out.println(menuItem);
        }
    }
}
