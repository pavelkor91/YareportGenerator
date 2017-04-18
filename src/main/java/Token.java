import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.*;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.types.GrantType;

import java.io.IOException;
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
    public void requestToken() throws URISyntaxException, IOException, OAuthSystemException, OAuthProblemException{
        String url = "https://oauth.yandex.ru/authorize?response_type=code&client_id="+client_id;
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
        String tokenUrl = "https://oauth.yandex.ru/token";

        OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());
        OAuthClientRequest request = OAuthClientRequest
                .tokenLocation(tokenUrl)
                .setCode(token)
                .setGrantType(GrantType.AUTHORIZATION_CODE)
                .setRedirectURI(tokenUrl)
                .setClientId(client_id)
                .setClientSecret(client_secret)
                .buildBodyMessage();
        request.setHeader(OAuth.HeaderType.CONTENT_TYPE,"application/x-www-form-urlencoded");
        System.out.println(request.getBody());
        OAuthJSONAccessTokenResponse oAuthResponse = oAuthClient.accessToken(request, OAuthJSONAccessTokenResponse.class);
        System.out.println(oAuthResponse.getAccessToken());
    }
}
