package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represent a student standing.
 * This class includes:
 * <ul>
 * <li> The model structure (fields, plus getters and setters).
 * <li> Some methods to facilitate form display and manipulation (getNameList, etc.).
 * <li> Some fields and methods to "fake" a database of Standings.
 * </ul>
 */
public class Standing {
  private long id;
  private String name;
  private static final long JUNIOR = 3L;
  private static final long SENIOR = 4L;
  private static final long NA = 5L;
  
  /**
   * Create a new Grade Level.
   * @param id The id.
   * @param name The name of the grade.
   */
  public Standing(long id, String name) {
    this.id = id;
    this.name = name;
  }
  
  /** 
   * Sets the id.
   * @param id The id to set.
   * 
   */
  public void setId(long id) {
    this.id = id;
  }
  
  /** 
   * Sets the id.
   * @param name The name to set.
   * 
   */
  public void setName(String name) {
    this.name = name;
  }
  
  /** 
   * Gets the id.
   * @return long The id.
   * 
   */
  public long getId() {
    return id;
  }
  
  /** 
   * Gets the standing name.
   * @return String The name.
   * 
   */
  public String getName() {
    return name;
  }

  /**
   * Provide a list of names for use in form display.
   * @return A list of level names in sorted order.
   */
  public static List<String> getNameList() {
    String[] nameArray = {"Freshman", "Sophomore", "Junior", "Senior", "N/A"};
    return Arrays.asList(nameArray);
  }

  /**
   * Return the Standing instance in the database with name 'levelName' or null if not found.
   * @param levelName The Level name.
   * @return The Standing instance, or null if not found.
   */
  public static Standing findLevel(String levelName) {
    for (Standing level : allLevels) {
      if (levelName.equals(level.getName())) {
        return level;
      }
    }
    return null;
  }

  /**
   * Provide a default Standing for use in form display.
   * @return The default grade level.
   */
  public static Standing getDefaultLevel() {
    return findLevel("Freshman");
  }

  @Override
  public String toString() {
    return String.format("[Standing %s]", this.name);
  }

  /** Fake a database of Standings. */
  private static List<Standing> allLevels = new ArrayList<>();

  /** Instantiate the fake database. */
  static {
    allLevels.add(new Standing(1L, "Freshman"));
    allLevels.add(new Standing(2L, "Sophomore"));
    allLevels.add(new Standing(JUNIOR, "Junior"));
    allLevels.add(new Standing(SENIOR, "Senior"));
    allLevels.add(new Standing(NA, "N/A"));
  }


}
