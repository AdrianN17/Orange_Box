package init;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
class URLValidator {
    /*expresión regular*/
    private static final String URL_REGEX ="^((((https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$, A-Za-z0-9])+)" + "([).!';/?:, ][[:blank:]])?$";
    private static final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);
    
    
    public static boolean urlValidator(String url)
    {
        Matcher matcher = URL_PATTERN.matcher(url);
        return matcher.matches();
    }
    public static void main(String[] args)
    {
        String url = "https://www.javadesdecero.es/";
        /* validar la url */
        if (urlValidator(url))
            System.out.println("La url dada " + url + " es válida");
        else
            System.out.println("La url dada " + url + " no es válida");
    }
}
