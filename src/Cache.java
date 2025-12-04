import com.google.gson.JsonObject;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class Cache {

    private static class CacheItem {
        JsonObject data;
        Instant expiresAt;

        CacheItem(JsonObject data, Instant expiresAt) {
            this.data = data;
            this.expiresAt = expiresAt;
        }
    }

    private static final Map<String, CacheItem> cache = new HashMap<>();
    private static final long TTL_SECONDS = 600; // 10 minutos

    public static JsonObject get(String key) {
        if (!cache.containsKey(key)) return null;

        CacheItem item = cache.get(key);

        if (Instant.now().isAfter(item.expiresAt)) {
            cache.remove(key);
            return null;
        }

        return item.data;
    }

    public static void put(String key, JsonObject value) {
        cache.put(key, new CacheItem(
                value,
                Instant.now().plusSeconds(TTL_SECONDS)
        ));
    }
}
