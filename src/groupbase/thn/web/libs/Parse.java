package groupbase.thn.web.libs;
import groupbase.thn.web.videoapp.util.Helper;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

/**
 * Created by nghiath on 4/3/15.
 */
public class Parse {

    public static <T> T FromJsonToObject(String stringJsonObject, Class<T> object) {

        try {
            JSONObject jsonObject = new JSONObject(stringJsonObject);
            List<Field> fields = new ArrayList<Field>();
            fields.addAll(Arrays.asList(object.getDeclaredFields()));
            Object result = object.newInstance();
            for (Field field : fields) {
                field.setAccessible(true);
                JsonAnnotation jsonAnnotation = field.getAnnotation(JsonAnnotation.class);
                if (jsonAnnotation != null) {
                	Object valueJson = null;
                    try {
                    	if (jsonAnnotation.PathRoot()[0].isEmpty()){
                    		if (jsonObject.has(jsonAnnotation.FieldName())){
                                 valueJson = jsonObject.get(jsonAnnotation.FieldName());                                
                            }
                    	}else{
                    		 valueJson = getObject(jsonAnnotation.PathRoot(), jsonObject).get(jsonAnnotation.FieldName()) ;
                            
                    	}
                    	if (valueJson != null) {
                            if (valueJson instanceof JSONObject) {
                                if (jsonAnnotation.isObject()) {                                	
                                    field.set(result, FromJsonToObject(valueJson.toString(), jsonAnnotation.FieldType()));
                                }
                            } else {
                                if (valueJson instanceof JSONArray) {
                                    if (jsonAnnotation.isObject()) {
                                        field.set(result, FromJsonArrayToArrayObject(valueJson.toString(), jsonAnnotation.FieldType()));
                                    }
                                } else {
                                	if (jsonAnnotation.isEncode()){
                                		field.set(result, jsonAnnotation.FieldType().cast(Helper.base64Encode(valueJson.toString())));
                                	}else{
                                		field.set(result, jsonAnnotation.FieldType().cast(valueJson));
                                	}
                                    
                                }
                            }
                        } else {
                            field.set(result, null);
                        }
                    } catch (JSONException e) {
                    	System.out.printf("JsonParse %s",jsonAnnotation.FieldName()+": "+ e.getMessage());                        
                    } catch (Exception e) {
                    	System.out.printf("ObjectParse %s",jsonAnnotation.FieldName()+": "+ e.getMessage());                          
                    }
                }
            }
            return object.cast(result);
        } catch (Exception e) {         
            System.out.printf("ObjectParse %s", e.getMessage());
            return null;
        }

    }
    
    public static JSONObject getObject(String[] path,JSONObject jsonObject){
    	JSONObject obj = jsonObject;
    	for(String str:path){
    		try {
    			if(obj.has(str)){
				obj = (JSONObject) obj.get(str);
    			}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	return obj;
    }
    public static <T> ArrayList<T> FromJsonArrayToArrayObject(String stringJsonArray,Class<T> typeObject ) {

        try {
            JSONArray jsonArray = new JSONArray(stringJsonArray);
            Class<?> clazz = (Class<?>) typeObject;
            ArrayList<T> result = new ArrayList<T>();
            if (String.class.isAssignableFrom(clazz)) {
                for (int i = 0; i < jsonArray.length(); i++) {
                    try {
                        result.add(typeObject.cast( jsonArray.get(i)));
                    } catch (JSONException e) {                       
                        System.out.printf("JsonParse %s", e.getMessage());
                        result = null;
                    }
                }
            } else {
                if (JSONArray.class.isAssignableFrom(clazz)) {
                    for (int i = 0; i < jsonArray.length(); i++) {
                        try {
                            result.add(typeObject.cast( jsonArray.get(i)));
                        } catch (JSONException e) {                           
                            System.out.printf("JsonParse %s", e.getMessage());
                            result = null;
                        }
                    }
                } else {
                    for (int i = 0; i < jsonArray.length(); i++) {
                        Object value = null;
                        try {
                            value = jsonArray.get(i);
                            if (value instanceof JSONArray) {
                                return FromJsonArrayToArrayObject(jsonArray.getString(i), typeObject);
                            } else {
                                result.add((T) FromJsonToObject(jsonArray.getString(i), typeObject));
                            }
                        } catch (JSONException e) {
                        	System.out.printf("JsonParse %s", e.getMessage());                            
                            result = null;
                        }

                    }
                }
            }
            return result;
        } catch (JSONException e) {            
            System.out.printf("JsonParse %s", e.getMessage());
            return null;
        }

    }
}