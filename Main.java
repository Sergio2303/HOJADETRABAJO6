import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

/**
 * The type Main.
 */
public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.print("Choose implementation\n1) HashMap\n2) TreeMap\n3) LinkeHashMap\n4) Exit");
            String choice = in.nextLine();

            if (choice.equals("4")) {
                break;
            }

            Map map = MapFact.getMap(choice);
            if (map == null) {
                System.out.println("Map not found, try again");
            }else {
                Map<String, ArrayList<String>> mapData = MapBuild.getInitialValues(map);
                Map<String,Integer> userCollection = MapFact.getMap(choice);

                while(true) {

                    System.out.println("Main menu\n1) Add products");
                    System.out.println("2) Show product category");
                    System.out.println("3) Display product data");
                    System.out.println("4) Show product and products in the category");
                    System.out.println("5) Display product and category of all inventory");
                    System.out.println("6) Show existing product and category");
                    System.out.println("7) Exit");
                    String menuSelection = in.nextLine();

                    switch (menuSelection) {

                        case "1":
                            while (true) {
                                System.out.println("Enter the product category: ");
                                String car = in.nextLine();
                                if (Controller.MapCategory(mapData, car)) {
                                    System.out.println("Enter article");
                                    String art = in.nextLine();
                                    if (Controller.Article(mapData, art, false)) {
                                        if (Controller.productInCollections(userCollection, art)) {
                                            userCollection.put(art, userCollection.get(art) + 1);
                                            Controller.iterateMap(userCollection);
                                        } else {
                                            userCollection.put(art, 1);
                                            Controller.iterateMap(userCollection);
                                        }
                                        System.out.println("Article pleasing to the collection: ");
                                        break;
                                    } else {
                                        System.out.println("The item does not exist or does not belong to the category: " + car);
                                    }
                                } else {
                                    System.out.println("The category does not exist, enter again ");
                                }
                            }
                            break;
                        case "2":
                            Controller.articleInfo(in, mapData, userCollection, false);
                            break;
                        case "3":
                            Controller.articleInfo(in, mapData, userCollection, true);
                            break;
                        case "4":
                            Controller.showSortUserInfor(mapData, userCollection, true);
                            break;
                        case "5":
                            Controller.showSortUserInfor(mapData, userCollection, false);
                            break;
                        case "6":
                            Controller.showSortUserInfor(mapData, userCollection, false);
                            break;
                        case "7":
                            return;
                        default:
                            System.out.println("Not valid option");
                            break;

                    }
                }
            }
        }
    }
}
