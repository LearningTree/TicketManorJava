
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

/**
 * This exercise is ONLY used in the JavaScript exercise.
 * <br>
 * This class is called SimpleServer for a reason; it has no security so DO NOT
 * USE WHEN CONNECTED TO THE INTERNET
 * <br>
 * Also note that this uses code from com.sun.net which is not
 * guaranteed to exist in any particular Java implementation
 * (although it's been in Java 6, 7, and 8 so it's unlikely to
 * completely disappear without warning).
 * @author Ian Darwin
 */
@SuppressWarnings("restriction")
public class SimpleServer {

	private static final String BASE_FILE_PATH = "src/main/webapp";

	public static void main(String[] args) throws IOException {

		HttpServer server = HttpServer.create(new InetSocketAddress(8081), 0);
		// Create the ServletContext, given a starting directory and
		// an HttpExchange ('t' here).
		server.createContext("/", (t) -> {
			String response = 
					t.getRequestURI().toString();
			final File realFile = new File(BASE_FILE_PATH + response);
			if (!realFile.exists()) {
				t.sendResponseHeaders(404, 0);
				final String error404 = "404 Not Found: " + response + "\r\n";
				System.out.print(error404);
				final OutputStream outputStream = t.getResponseBody();
				outputStream.write(error404.getBytes(), 0, error404.length());
				outputStream.close();
				return;
			}
			InputStream is = new FileInputStream(realFile);
			t.sendResponseHeaders(200, realFile.length());
			System.out.println("200 " + response);
			OutputStream os = t.getResponseBody();
			byte[] data = new byte[4096];
			int n = 0;
			do {
				n = is.read(data);
				os.write(data, 0, n);
			} while (n > 0);
			is.close();
			os.close();
		});
		server.setExecutor(null); // Don't need a special executor
		server.start();
	}

}
