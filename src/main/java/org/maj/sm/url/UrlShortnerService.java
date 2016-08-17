package org.maj.sm.url;

import java.util.Stack;

/**
 * Consider each url is stored in database and each one of them has integer ID associated
 * Keep in mind we need a bijective function such that we can convert the id to short url
 * and from short url we can get the id
 * @author shamik.majumdar
 */
public class UrlShortnerService {
    /**
     * Convert the id to a 6 char long Url
     * @param id
     * @return
     */
    public String idToShortUrl(int id){
        // Map to store 62 possible characters
        char map[] = new char[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o'
                ,'p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K'
                ,'L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8','9'};

        Stack<Character> sb = new Stack<>();

        // Convert given integer id to a base 62 number
        while (id != 0)
        {
            // use above map to store actual character
            // in short url
            sb.add(map[id%map.length]);
            id = id /map.length;
        }
        char[] val = new char[sb.size()];
        for (int i=0; i < val.length;i++){
            val[i] = sb.pop();
        }

        return new String(val);
    }

    /**
     * Convert the shortUrl to int id
     * @param shortUrl
     * @return
     */
    public int idToShortUrl(String shortUrl){
        int id = 0; // initialize result

        // A simple base conversion logic
        for (int i=0; i < shortUrl.length(); i++)
        {
            if ('a' <= shortUrl.charAt(i) && shortUrl.charAt(i) <= 'z')
                id = id*62 + shortUrl.charAt(i) - 'a';
            if ('A' <= shortUrl.charAt(i) && shortUrl.charAt(i) <= 'Z')
                id = id*62 + shortUrl.charAt(i) - 'A' + 26;
            if ('0' <= shortUrl.charAt(i) && shortUrl.charAt(i) <= '9')
                id = id*62 + shortUrl.charAt(i) - '0' + 52;
        }
        return id;
    }
}
