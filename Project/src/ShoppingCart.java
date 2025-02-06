//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ShoppingCart {
    private static final int  MAX_ITEMS=100;

    private String[] itemNames;
    private double[] itemPrices;
    private int itemCount;

    public ShoppingCart(){
        this.itemCount=0;
        this.itemNames=new String[MAX_ITEMS];
        this.itemPrices=new double[MAX_ITEMS];

    }
    private void addItemToCart(String itemName,double itemPrice){
        if (itemCount<MAX_ITEMS){
            itemNames[itemCount]=itemName;
            itemPrices[itemCount]=itemPrice;
            itemCount++;
            System.out.println(itemName+" added to the cart.");
        }else {
            System.out.println("Sorry, the cart is full");
        }
    }
    public static void main(String[] args) {

    }
}