package API_Test;

		import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.http.Header;
		import org.apache.http.client.ClientProtocolException;
		import org.apache.http.client.methods.CloseableHttpResponse;
		import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
		import org.apache.http.impl.client.HttpClients;
		import org.apache.http.util.EntityUtils;
		import org.json.JSONArray;
		import org.json.JSONObject;

		public class PutrequestTest {

			//for postman app go to reqres.in application no need to download
			
			public static void main(String[] args) throws ClientProtocolException, IOException {
				 
				CloseableHttpClient CloseableHttpClient = HttpClients.createDefault();
				HttpPost post = new HttpPost ("https://reqres.in/api/users?page=2");
				
				post.addHeader("Content-Type", "application/json");
				
				
				String strRequestPayload = FileUtils.readFileToString(new File("G:\\New Workspace\\APITestingNovBatch\\src\\main\\java\\API_Test\\Postrequest.txt"));
				
				post.setEntity(new StringEntity(strRequestPayload));
				
				CloseableHttpResponse closeableHttpResponse = CloseableHttpClient.execute(post);
				
				int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
				
				System.out.println(statuscode);
				
				
				
						
		   }
		


	}


