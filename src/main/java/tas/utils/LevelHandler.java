package main.java.tas.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Class that modifies levelStorage.json, or accesses it for data.
 */
public class LevelHandler {
	private static String ASSET_PATH = "asset";
	private static String PATH = ASSET_PATH + File.separator + "levelStorage.json";
	private static String PATH_2_DEFAULT_LEVELS = "levelStorage/levelStorage.json";
    
	/**
	 * @return the number of elements in levelStorage.json (which is the number of
	 *         levels)
	 */
	public static int getNElements() {
		try {
			JSONObject json = JsonUtils.getJsonDataByFile(new File(LevelHandler.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent() + File.separator + PATH);
			return json.length();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * Reads a level off levelStorage.json.
	 * 
	 * @param level the name of the level
	 * @return a list of the nodes of the level
	 */
	public static List<Position> readLevel(String level) {
		JSONObject json = new JSONObject();
		try {
			json = JsonUtils.getJsonDataByFile(new File(LevelHandler.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent() + File.separator + PATH);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		List<Position> list = new ArrayList<Position>();

		JSONArray levelNodes = json.getJSONObject(level).getJSONArray("path");
		for (int i = 0; i < levelNodes.length(); i++) {
			list.add(new Position(levelNodes.getJSONObject(i).getInt("x"), levelNodes.getJSONObject(i).getInt("y")));
		}
		return list;
	}

	/**
	 * Adds a level on levelsStorege.json.
	 * 
	 * @param list the list of nodes of the new level
	 */
	public static void writeLevel(List<Position> list) {
		JSONObject file = new JSONObject();
		try {
			file = JsonUtils.getJsonDataByFile(new File(LevelHandler.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent() + File.separator + PATH);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		JSONObject level = new JSONObject();
		JSONArray path = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			JSONObject node = new JSONObject();
			node.put("x", (int) list.get(i).getX());
			node.put("y", (int) list.get(i).getY());
			path.put(node);
		}
		level.put("path", path);
		file.put("level" + Integer.toString(getNElements() + 1), level);
		saveJson(file);
	}

	/**
	 * Deletes the user made levels.
	 */
	public static void deleteUserLevels() {
		JSONObject json = null;
		try {
			json = JsonUtils.getJsonDataByFile(new File(LevelHandler.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent() + File.separator + PATH);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		if (getNElements() > 3) {
			for (int i = 4; i <= (json.length() + 2); i++) {
				json.remove("level" + Integer.toString(i));
			}
			saveJson(json);
		}
	}

	/**
	 * Saves the JSON.
	 * 
	 * @param jsonObj the JSON
	 */
	private static void saveJson(JSONObject jsonObj) {
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(PATH);
			fileWriter.write(jsonObj.toString(4));
			fileWriter.flush();
			fileWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
    * Checks if the 'asset' file exists, otherwise it creates it
    */
   public static boolean checkAssetFile() {
       if (!checkFileExists(ASSET_PATH)) {
           try {
               File dir = new File(new File(LevelHandler.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent().concat(File.separator + ASSET_PATH));
               boolean dirCreation = dir.mkdirs();

               File jsonFile = new File(new File(LevelHandler.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent().concat(File.separator + PATH));
               boolean fileCreation = jsonFile.createNewFile();

               saveJson(JsonUtils.getJsonData(PATH_2_DEFAULT_LEVELS));

               return dirCreation && fileCreation;

           } catch (URISyntaxException e) {
               e.printStackTrace();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
       return false;
   }

   /**
    * Return true if the directory exists in the external path.
    * @return true if the directory exists in the external path
    */
   private static boolean checkFileExists(String directory) {
       try {
           File dir = new File(new File(LevelHandler.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent() + File.separator + directory);
           return dir.exists();
       } catch (URISyntaxException e) {
           e.printStackTrace();
           return false;
       }
   }
}
