package views.formdata;

import java.util.HashMap;
import java.util.Map;


/**
 * Class that declares telephone types.
 * @author Owner
 *
 */
public class TelephoneTypes {
  
  private static String[] types = {"Home", "Work", "Mobile"};
  
  /**
   * Returns a map of all the telephone Types.
   * @return The telephone type map.
   */
  public static Map<String, Boolean> getTypes() {
    Map<String, Boolean> typeMap = new HashMap();
    for (String type: types) {
      typeMap.put(type,  false);
    }
    return typeMap;
  }
  
  /**
   * Sets a valid type and return the map.
   * @param telephoneType A string that will be set to a valid type.
   * @return Map A map of the valid telephone types.
   */
  public static Map<String, Boolean> getTypes(String telephoneType) {
    Map<String, Boolean> typeMap = TelephoneTypes.getTypes();
    typeMap.put(telephoneType, true);
    return typeMap;
  }
  
  /**
   * Returns true if the parameter is a valid type.
   * @param type The telephone type.
   * @return True if the type is valid.
   */
  public static boolean isType(String type) {
    return TelephoneTypes.getTypes().keySet().contains(type);
  }
  

}
