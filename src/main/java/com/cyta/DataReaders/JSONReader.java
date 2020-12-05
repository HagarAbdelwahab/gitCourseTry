package com.cyta.DataReaders;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONReader {
	
    private static JSONArray ObjList;
    
	//read the JSON Doc and return JSON Array of it
	public static JSONArray readJSONdoc (String FilePath)   
	{  
		
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader(FilePath));
	 
	        ObjList = (JSONArray) obj;
	        System.out.println(ObjList);
	        return ObjList;
			 
		}   
		catch (Exception e)   
		{  
			e.printStackTrace(); 
			System.out.println(e);
			return null;
		}  
	}
	
	public JSONArray getObjList() {	
		return ObjList;
	}

	//read child value with the child name and its parent tag name
	public static List<String> getValueByName(String Parentkey, String Childkey)
	{
		List<String> ChildsValues = new ArrayList<String>();
		try {
			
			for (int itr = 0; itr < ObjList.size(); itr++)   
			{  
		        JSONObject ParentObject = (JSONObject) ((JSONObject)ObjList.get(itr)).get(Parentkey);
		        
		        String ChildValue = (String) ParentObject.get(Childkey);    
		        System.out.println(ChildValue);
		        ChildsValues.add(ChildValue);
			}  
			
			return ChildsValues;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace(); 
			return null;
		}
	}
	
}
