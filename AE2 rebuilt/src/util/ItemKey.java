package util;

import java.io.Serializable;
import java.util.Objects;

public class ItemKey implements Serializable {


    private final String itemId;

    public ItemKey(String itemId) {
        this.itemId = itemId;
    }

    public String getItemId() {
        return itemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemKey)) return false;
        ItemKey itemKey = (ItemKey) o;
        return Objects.equals(itemId, itemKey.itemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId);
    }

    @Override
    public String toString() {
        return itemId;
    }
}
