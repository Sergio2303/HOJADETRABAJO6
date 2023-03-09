import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * The type Map build.
 */
public class MapBuild {
    /**
     * Gets initial values.
     *
     * @param map the map
     * @return the initial values
     */
    public static Map getInitialValues(Map<String,ArrayList<String>> map) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("ListadoProducto.txt"));
            String line = reader.readLine();
            ArrayList<String> values = new ArrayList<String>();

            while (line!= null) {
                String[] split = line.split("|");
                String key = split[0].substring(0,split[0].length()-1);
                String value = split[1].substring(0,split[1].length()-1);

                if (Controler.CategoryExists(values, key)) {
                    map.get(key).add(value);
                }else {
                    values.add(key);
                    map.put(key,new ArrayList<String>());
                    map.get(key).add(value);
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("File not found, try again.");
        } finally {
            try {
                if (reader!= null) {
                    reader.close();
                }
            }catch (IOException e) {
                System.out.println("ERROR");
            }
        }
        return map;
    }
}
