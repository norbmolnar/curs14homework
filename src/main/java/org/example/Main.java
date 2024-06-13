import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// Interface ShopItem
interface ShopItem {
    String name();
    int price();
    Category category();
}

// Enum Category
enum Category {
    ON_SALE, NEW, REFURBISHED;
}

// Class Clothes implementing ShopItem
class Clothes implements ShopItem {
    private String name;
    private int price;
    private Category category;

    public Clothes(String name, int price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public int price() {
        return price;
    }

    @Override
    public Category category() {
        return category;
    }

    @Override
    public String toString() {
        return "Clothes{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';
    }
}

// Class Electronics implementing ShopItem
class Electronics implements ShopItem {
    private String name;
    private int price;
    private Category category;

    public Electronics(String name, int price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public int price() {
        return price;
    }

    @Override
    public Category category() {
        return category;
    }

    @Override
    public String toString() {
        return "Electronics{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';
    }
}

// Class Fruits implementing ShopItem
class Fruits implements ShopItem {
    private String name;
    private int price;
    private Category category;

    public Fruits(String name, int price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public int price() {
        return price;
    }

    @Override
    public Category category() {
        return category;
    }

    @Override
    public String toString() {
        return "Fruits{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';
    }
}

// Generic Shop class
class Shop<T extends ShopItem> {
    private List<T> items;

    public Shop() {
        this.items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public List<T> findByCategory(Category cat) {
        return items.stream()
                .filter(item -> item.category() == cat)
                .collect(Collectors.toList());
    }

    public List<T> findWithLowerPrice(int maxPrice) {
        return items.stream()
                .filter(item -> item.price() < maxPrice)
                .collect(Collectors.toList());
    }

    public Optional<T> findByName(String name) {
        return items.stream()
                .filter(item -> item.name().equalsIgnoreCase(name))
                .findFirst();
    }

    public Optional<T> removeItem(String name) {
        Optional<T> itemToRemove = findByName(name);
        itemToRemove.ifPresent(items::remove);
        return itemToRemove;
    }

    // Extra methods
    public List<T> getAllItems() {
        return new ArrayList<>(items);
    }

    public int getTotalItems() {
        return items.size();
    }

    public int getTotalInventoryValue() {
        return items.stream().mapToInt(ShopItem::price).sum();
    }
}

// Main class to demonstrate functionality
public class Main {
    public static void main(String[] args) {
        Shop<Clothes> clothesShop = new Shop<>();
        clothesShop.addItem(new Clothes("T-Shirt", 20, Category.NEW));
        clothesShop.addItem(new Clothes("Jeans", 50, Category.ON_SALE));
        clothesShop.addItem(new Clothes("Jacket", 100, Category.REFURBISHED));

        Shop<Electronics> electronicsShop = new Shop<>();
        electronicsShop.addItem(new Electronics("Smartphone", 600, Category.NEW));
        electronicsShop.addItem(new Electronics("Laptop", 1200, Category.ON_SALE));
        electronicsShop.addItem(new Electronics("Headphones", 150, Category.REFURBISHED));

        Shop<Fruits> fruitsShop = new Shop<>();
        fruitsShop.addItem(new Fruits("Apple", 2, Category.NEW));
        fruitsShop.addItem(new Fruits("Banana", 1, Category.ON_SALE));
        fruitsShop.addItem(new Fruits("Cherry", 3, Category.REFURBISHED));

        System.out.println("Clothes on sale: " + clothesShop.findByCategory(Category.ON_SALE));
        System.out.println("Electronics under $200: " + electronicsShop.findWithLowerPrice(200));
        System.out.println("Find Banana: " + fruitsShop.findByName("Banana"));
        System.out.println("Remove Cherry: " + fruitsShop.removeItem("Cherry"));
        System.out.println("All fruits: " + fruitsShop.getAllItems());
    }
}
