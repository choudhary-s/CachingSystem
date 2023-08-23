package src;

/**
 * Hello world!
 *
 */
public class Driver {
    public static void main( String[] args ) {
        CacheFactory cacheFactory = new CacheFactory();
        Cache cache = cacheFactory.getDefaultCache();

        cache.add(1, "Saurabh");
        cache.add(2, "Atul");
        cache.add(3, "Shivam");
        cache.add(4, "Manav");
        cache.add(5, "Subodh");
        cache.get(1);
        cache.add(6, "Kiran");

        cache.get(4);
        cache.get(2);
        cache.remove(3);
        cache.get(3);

    }
}
