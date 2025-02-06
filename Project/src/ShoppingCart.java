import java.util.Arrays;
import java.util.Scanner;

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

    private void viewCart(){
        if (itemCount==0){
            System.out.println("Cart is empty");
        }else {
            System.out.println("\n"+"Cart Content: ");
            for (int i=0;i<itemCount;i++){
                System.out.println(itemNames[i]+": $"+itemPrices[i]);
            }

        }
    }
    private void removeItem(int id){
        System.out.println(itemNames[id]+" Removed to the cart.");
        for (int i=0;i<itemCount;i++){
            itemNames[i]=itemNames[i+1];
            itemPrices[i]=itemPrices[i+1];

        }
        itemCount--;
        viewCart();
        /*itemCount--;
        itemNames[id]=null;
        itemPrices[id]=0;
*/
    }
    private void calculateTotal(){
        double total=0;
        for (int i=0;i<itemCount;i++){
            total+=itemPrices[i];
        }
        System.out.println("Total price of items in the cart $: "+total);
    }
    public static void main(String[] args) {
        ShoppingCart shoppingCart=new ShoppingCart();
        Scanner scanner=new Scanner(System.in);

        System.out.println("Welcome to Shopping cart");
        while (true){
            System.out.println("\n Choose an option:");
            System.out.println("1. Add Item to cart");
            System.out.println("2. View Cart");
            System.out.println("3. Calculete Cart");
            System.out.println("4. Remove Item");
            System.out.println("5. Exit");

            System.out.print(" \n"+"Your choice: ");
            int choice=scanner.nextInt();

            switch (choice){
                case 1:
                    System.out.print("Enter Item Name:");
                    String name=scanner.next();
                    System.out.print("Enter Item Price: ");
                    double price=scanner.nextDouble();
                    shoppingCart.addItemToCart(name,price);
                    break;
                case 2:
                    shoppingCart.viewCart();
                    break;
                case 3:
                    shoppingCart.calculateTotal();
                    break;
                case 5:
                    System.out.println("Exiting the sopping cart. Have nice day");
                    System.exit(0);
                    break;
                case 4:
                    if (shoppingCart.itemCount>0){
                        System.out.println("Which item do you want to delete? \n");
                        for (int i=0;i<shoppingCart.itemCount;i++){
                            System.out.println(i+"."+shoppingCart.itemNames[i]);
                        }
                        System.out.print("Delete choice: ");
                        int delete=scanner.nextInt();
                        shoppingCart.removeItem(delete);
                     }
                    break;
                default:
                    System.out.println("Invalid choice..");
                    break;
            }
        }
    }
}