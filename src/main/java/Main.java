import com.sun.jndi.toolkit.url.Uri;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {

    public static void main (String [] args) throws URISyntaxException, IOException{
        Token token = new Token("0b3f39cc14d240ed8386d139b457c263","4c47e2453bfc4c9e8e5453d9248b9aa9");
        token.requestToken();
    }
}
