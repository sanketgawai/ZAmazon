package rhl.data;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.nio.charset.StandardCharsets;

public class DataReader {

	public List<HashMap<String, String>> getJsonData()
	{
		  ObjectMapper mapper = new ObjectMapper();
	        List<HashMap<String, String>> data = null;

	        try {
	            data = mapper.readValue(new File(System.getProperty("user.dir")+"\\src\\test\\java\\rhl\\data\\LoginCredential.json"), new TypeReference<List<HashMap<String, String>>>(){});
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return data;
			
	}
	
}
