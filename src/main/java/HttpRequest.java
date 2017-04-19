import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequest {
    private final String accessToken;

    public HttpRequest(final String accessToken) {
        this.accessToken = accessToken;
    }
    public String doRequest(String url, HttpMethod method, String content) {
        try {
            URL address = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) address.openConnection();
            conn.setRequestProperty("Authorization", "OAuth " + accessToken);
            conn.setRequestProperty("User-Agent", "AutoReportGenerator");
            conn.setRequestProperty("Accept", "application/json");
            conn.setAllowUserInteraction(false);
            conn.setRequestMethod(method.name());


            StringBuilder result = new StringBuilder();
            try {
                if (content != null) {
                    conn.setDoOutput(true);
                    conn.setRequestProperty("Content-Type", "application/json");
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream(), "UTF-8"));
                    try {
                        writer.write(content);
                    } finally {
                        writer.close();
                    }
                }

                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"), 8192);
                try {
                    char[] buffer = new char[8192];
                    int read;
                    while ((read = reader.read(buffer)) >= 0) {
                        result.append(buffer, 0, read);
                    }
                } finally {
                    reader.close();
                }
            } catch (IOException e) {
                if (conn.getResponseCode() == 401) {
                    //  throw new AuthException();
                } else {
                    //  throw new TransportException(e);
                }
            }
            return result.toString();
        }
        catch (IOException ex)
        {

        }
        return  null;
    }
    public enum HttpMethod {
        GET,
        POST,
        PUT,
        DELETE
    }
}
