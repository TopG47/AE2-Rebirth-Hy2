package core;

import util.ItemKey;

import java.util.HashMap;
import java.util.Map;

public class MEStorage {

    private final Map<ItemKey, Long> items = new HashMap<>();
    private long maxCapacity = 0;

    public void addCapacity(long amount) {
        maxCapacity += amount;
    }

    public long getUsed() {
        long used = 0;
        for (long v : items.values()) {
            used += v;
        }
        return used;
    }

    public long getMaxCapacity() {
        return maxCapacity;
    }

    public boolean insert(ItemKey item, long amount) {
        if (amount <= 0) return false;
        if (getUsed() + amount > maxCapacity) return false;

        items.put(item, items.getOrDefault(item, 0L) + amount);
        return true;
    }

    public boolean extract(ItemKey item, long amount) {
        if (amount <= 0) return false;

        long stored = items.getOrDefault(item, 0L);
        if (stored < amount) return false;

        long remaining = stored - amount;
        if (remaining == 0) {
            items.remove(item);
        } else {
            items.put(item, remaining);
        }
        return true;
    }

    public Map<ItemKey, Long> getSnapshot() {
        return new HashMap<>(items);
    }
}
