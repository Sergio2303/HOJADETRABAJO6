import java.util.*;

/**
 * The type Map fact.
 */
public class MapFact {
    /**
     * Get map map.
     *
     * @param MapValue the map value
     * @return the map
     */
    public static Map getMap(String MapValue){
        if (MapValue.equals("1")) {
            return new HashMap<String, ArrayList<String>>();
        } else if (MapValue.equals("2")) {
            return new TreeMap<String, ArrayList<String>>();
        } else if (MapValue.equals("3")) {
            return new LinkedHashMap<String, ArrayList<String>>();
        }
        return null;
    }
}