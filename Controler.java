import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

/**
 * The type Controller.
 */
public class Controler {
    /**
     * Category exists boolean.
     *
     * @param CAT      the cat
     * @param Category the category
     * @return the boolean
     */
    public static boolean CategoryExists(ArrayList<String> CAT, String Category){
        for (int i = 0; i<CAT.size();i++){
            if(CAT.get(i).equals(Category)){
                return true;
            }
        }
        return false;
    }

    /**
     * Map category boolean.
     *
     * @param map the map
     * @param cat the cat
     * @return the boolean
     */
    public static boolean MapCategory(Map<String,ArrayList<String>> map,String cat){
        for(String key: map.keySet()){
            if(key.equals(cat)){
                return true;
            }
        }
        return false;
    }

    /**
     * Article boolean.
     *
     * @param Map     the map
     * @param Article the article
     * @param ShowCat the show cat
     * @return the boolean
     */
    public static boolean Article(Map<String,ArrayList<String>> Map, String Article,boolean ShowCat){
        for(String key: Map.keySet()){
            for(int i = 0; i<Map.get(key).size();i++){
                try {
                    if (Map.get(key).get(i).equals(Article)) {
                        if (ShowCat){
                            System.out.println("Category of: "+Article+" -- "+key);
                        }
                        return true;
                    }
                }catch (Exception e){
                }
            }
        }
        return false;
    }

    /**
     * Product in collections boolean.
     *
     * @param User     the user
     * @param Products the products
     * @return the boolean
     */
    public static boolean productInCollections(Map <String,Integer> User,String Products){
        if (User.size() == 0){
            return false;
        }else{
            for(String key:User.keySet()){
                if (key.equals(Products)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Iterate map.
     *
     * @param Map the map
     */
    public static void iterateMap(Map<String,Integer> Map){
        for (String key: Map.keySet()){
            System.out.println("KEY: "+key+" VALUE: "+Map.get(key));
        }
    }

    /**
     * Article info.
     *
     * @param in           the in
     * @param MapBuilt     the map built
     * @param UserMap      the user map
     * @param UserProducts the user products
     */
    public static void articleInfo(Scanner in,Map MapBuilt,Map UserMap,boolean UserProducts){
        System.out.println("Enter the article");
        String art = in.nextLine();
        if (Controler.Article(MapBuilt,art,true)){
            System.out.println("==========================");
            if(UserProducts){
                //Checks if user has the art
                if(Controler.userHasArt(UserMap,art)){
                }else{
                    System.out.println("The user does not have the product in his collection ");
                }
            }
        }else{
            System.out.println("Item not found");
        }
    }

    /**
     * User has art boolean.
     *
     * @param UserMap the user map
     * @param Article the article
     * @return the boolean
     */
    public static boolean userHasArt(Map<String,Integer> UserMap,String Article){
        for(String key: UserMap.keySet()){
            if(Article.equals(key)){
                System.out.println("User has: "+UserMap.get(key)+" of "+key);
                return true;
            }
        }
        return false;
    }

    /**
     * Show sort user infor.
     *
     * @param MapBt    the map bt
     * @param UsMap    the us map
     * @param UserInfo the user info
     */
    public static void showSortUserInfor(Map<String,ArrayList<String>> MapBt, Map<String,Integer> UsMap,boolean UserInfo){
        for(String key: MapBt.keySet()){
            System.out.println("\nCATEGORY: "+key);
            for(int i = 0; i<MapBt.size();i++) {
                try {
                    if (UserInfo){
                        if (UsMap.get(MapBt.get(key).get(i))==null){
                            System.out.println((i + 1) + ". " + MapBt.get(key).get(i)+" --User collection: 0");
                        }else{
                            System.out.println((i + 1) + ". " + MapBt.get(key).get(i)+" --User collection: "+UsMap.get(MapBt.get(key).get(i)));
                        }
                    }else{
                        System.out.println((i + 1) + ". " + MapBt.get(key).get(i));
                    }
                } catch (Exception e) {
                }
            }

        }
    }
}