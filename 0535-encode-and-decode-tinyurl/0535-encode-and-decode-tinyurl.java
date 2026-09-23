public class Codec {
    private HashMap<String, String> short_to_long = new HashMap<>();
    private HashMap<String, String> long_to_short = new HashMap<>();
    private AtomicLong counter = new AtomicLong(1000);
    private static final String BASE62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final String DOMAIN = "http://tiny.url/";

    public String encode(String long_url) {
        if (long_to_short.containsKey(long_url)) {
            return DOMAIN + long_to_short.get(long_url);
        }

        String short_code = encode_base62(counter.incrementAndGet());

        short_to_long.put(short_code, long_url);
        long_to_short.put(long_url, short_code);

        return DOMAIN + short_code;
    }

    public String decode(String short_url) {
        String short_code = short_url.replace(DOMAIN, "");

        return short_to_long.getOrDefault(short_code, "");
    }
    
    public String encode_base62(long num) {
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(BASE62.charAt((int) num % 62));
            num /= 62;
        } while (num > 0);

        return sb.reverse().toString();
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));