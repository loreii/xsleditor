//import java.io.ByteArrayInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.URL;
//
//import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
//import org.apache.commons.httpclient.HttpClient;
//import org.apache.commons.httpclient.HttpException;
//import org.apache.commons.httpclient.HttpStatus;
//import org.apache.commons.httpclient.methods.GetMethod;
//import org.apache.commons.httpclient.params.HttpMethodParams;
//
////import sun.net.www.http.HttpClient;
//
//import com.sun.xml.internal.messaging.saaj.util.Base64;
//
//
//public class test {
//
//	/**
//	 * @param args
//	 */
//	public static void main(String[] args) {
//
//		System.out.print(getRemoteData("http://www.google.com"));
//
//	}
//
//	//	static String getUrl() {
//	//		URL contentUrl;
//	//		try {
//	//			HttpClient httpClient;
//	//			contentUrl = new URL("http://www.google.com");
//	//			
//	//			httpClient = HttpClient.New(contentUrl);
//	//			
//	//			InputStream ps = httpClient.getInputStream();
//	//			int    buffSize = ps.available();
//	//			byte[] buff     = new byte[buffSize];
//	//			
//	//			ps.read(buff);
//	//			
//	//			byte[] buffEncoded = Base64.encode(buff);
//	//			
//	//			return new String(buffEncoded);
//	//			
//	//		} catch (IOException e) {
//	//			return "URL not downlodable";
//	//		}
//	//
//	//		
//	//	}
//
//	private static String getRemoteData(String url){
//
//		String encodeBody = null;
//		ByteArrayInputStream bais = null;
//		HttpClient client = new HttpClient();
//
//		// Create a method instance.
//		GetMethod method = new GetMethod(url);
//
//		// Provide custom retry handler is necessary
//		method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, 
//				new DefaultHttpMethodRetryHandler(3, false));
//
//
//		try {
//			// Execute the method.
//			int statusCode = client.executeMethod(method);
//
//			if (statusCode != HttpStatus.SC_OK) {
//				System.err.println("Method failed: " + method.getStatusLine());
//			}
//
//			// Read & encode the response body.
//			byte[] responseBody = method.getResponseBody();
//			encodeBody = new sun.misc.BASE64Encoder().encode(responseBody);
//
//
//		} catch (HttpException e) {
//			System.err.println("Fatal protocol violation: " + e.getMessage());
//			e.printStackTrace();
//		} catch (IOException e) {
//			System.err.println("Fatal transport error: " + e.getMessage());
//			e.printStackTrace();
//		} finally {
//			method.releaseConnection();
//		}
//
//		return encodeBody;
//	}
//}
