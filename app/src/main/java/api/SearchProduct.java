package api;

public class SearchProduct {
    private static final String link = "https://dummyjson.com/";

    public static String searchProducts(String keyword) {
        return link + "products/search?q=" + keyword;
    }
}
