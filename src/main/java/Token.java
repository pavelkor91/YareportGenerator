import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import javax.imageio.IIOException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Token {
    private String token;
    private final String client_id;
    private final String client_secret;
    private String verificationCode;
    public Token(final String client_id, final String client_secret) {
        this.client_id = client_id;
        this.client_secret = client_secret;
    }
    public void requestToken() throws URISyntaxException{
        String url = "https://oauth.yandex.ru/authorize?response_type=token&client_id="+client_id;
        URI uri;
        try{
            uri = new URI(url);
            java.awt.Desktop.getDesktop().browse(uri);
        }
        catch (URISyntaxException ex){
            ex.printStackTrace();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }

        Scanner in = new Scanner(System.in);
        token = in.next();
//        String result;
//        uri = new URI(url);
//        HttpGet req = new HttpGet(uri);
//        req.setHeader("User-Agent", "DEFAULT_USER_AGENT");
//        try {
//            CloseableHttpClient client = HttpClients.createDefault();
//            CloseableHttpResponse response = client.execute(req);
//            InputStream inputStream = response.getEntity().getContent();
//            result = IOUtils.toString(inputStream);
//            System.out.println(result);
//        }
//        catch (IOException ex){
//            ex.printStackTrace();
//        }
    }
}
