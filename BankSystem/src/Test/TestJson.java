package Test;

import org.json.JSONObject;

public class TestJson {

	public static void main(String[] args) {
		JSONObject jo=new JSONObject();
		jo.put("name", "smith");
		jo.put("age", 20);
		jo.put("isMen", true);
		
		System.out.println(jo);

	}

}
