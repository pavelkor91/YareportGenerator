import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {

    public static void main (String [] args) throws URISyntaxException, IOException, OAuthSystemException, OAuthProblemException {
        Account token = new Account("0b3f39cc14d240ed8386d139b457c263","4c47e2453bfc4c9e8e5453d9248b9aa9");
        token.requestToken();
        HttpRequest request = new HttpRequest(token.getToken());
        System.out.println(request.doRequest("https://api.webmaster.yandex.net/v3/user/", HttpRequest.HttpMethod.GET,null));
        System.out.println(request.doRequest("https://api.webmaster.yandex.net/v3/user/287230149/hosts/", HttpRequest.HttpMethod.GET,null));
        System.out.println(request.doRequest("https://api.webmaster.yandex.net/v3/user/287230149/hosts/http:www.transstroyauto.ru:80", HttpRequest.HttpMethod.GET,null));

        System.out.println(request.doRequest("https://api.webmaster.yandex.net/v3/user/287230149/hosts/http:www.transstroyauto.ru:80/summary/", HttpRequest.HttpMethod.GET,null));

        System.out.println(request.doRequest("https://api.webmaster.yandex.net/v3/user/287230149/hosts/http:www.transstroyauto.ru:80/links/external/samples/", HttpRequest.HttpMethod.GET,null));
      //  System.out.println(request.doRequest("https://api.webmaster.yandex.net/v3/user/287230149/hosts", HttpRequest.HttpMethod.GET,null));
     //   System.out.println(request.doRequest("https://api.webmaster.yandex.net/v3/user/287230149/hosts", HttpRequest.HttpMethod.GET,null));
       // System.out.println(request.doRequest("https://api-metrika.yandex.ru/management/v1/counters", HttpRequest.HttpMethod.GET,null));
      //  System.out.println(request.doRequest("https://api-metrika.yandex.ru/stat/v1/data?preset=traffic&id=27460554", HttpRequest.HttpMethod.GET,null));
       // System.out.println(request.doRequest("https://api-metrika.yandex.ru/stat/v1/data?preset=traffic&ym:s:datePeriod<group>&group=Month&date1=31daysAgo&date2=today&id=27460554", HttpRequest.HttpMethod.GET,null));
    }
}
