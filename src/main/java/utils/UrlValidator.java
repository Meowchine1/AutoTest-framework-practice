package utils;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class UrlValidator {

    private static final String URL_PATTERN =
            "/^(([^:/?#]+):)?(//([^/?#]*))?([^?#]*)(\\?([^#]*))?(#(.*))?/";
//         12            3  4          5       6   7        8 9

    public static String sanitize(String url) throws URISyntaxException, MalformedURLException {
        URL temp = new URL(url);
        URI uri = new URI(
                temp.getProtocol(),
                temp.getUserInfo(),
                temp.getHost(),
                temp.getPort(),
                temp.getPath(),
                temp.getQuery(),
                temp.getRef());
        return uri.toASCIIString();
    }

}
