package API_Test;
import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class GetRequestTest {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		 
		CloseableHttpClient CloseableHttpClient = HttpClients.createDefault();
		HttpGet get = new HttpGet ("https://reqres.in/api/users?page=2");
		CloseableHttpResponse closeableHttpResponse = CloseableHttpClient.execute(get);
		
		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
		
		System.out.println(statuscode);
		Header[] headers = closeableHttpResponse.getAllHeaders();
		
		for(int i=0; i<headers.length;i++){
			
			String Headerkey = headers[i].getName();
			String headervalue = headers[i].getValue();
			
			System.out.println(Headerkey + "--> " + headervalue);
		
		}
		
		String response = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		
		//System.out.println(response);
		
		//JSON 
		// Below code to read the response body
		
		JSONObject jSONObj = new JSONObject(response);
		Integer sTotal = (Integer) jSONObj.get("total");
		Integer sPage = (Integer) jSONObj.get("page");
		System.out.println("Total --> " + sTotal + "and page -->" + sPage);
		
		JSONArray JSON_array = jSONObj.getJSONArray("data");
		
		for (int i = 0; i < JSON_array.length(); i++) 
		{
				
		
		JSONObject jSONObj_dataArray = JSON_array.getJSONObject(i);
		String strEmailid = (String) jSONObj_dataArray.get("email");
		System.out.println(strEmailid);
		
		}
	
		
		
		
		
		
		
		
		
				
   }
}
