package core;

import java.util.UUID;

public class MENetwork {

    private final UUID id;
    private final MEStorage storage;
    private final PowerCore power;

    public MENetwork() {
        this.id = UUID.randomUUID();
        this.storage = new MEStorage();
        this.power = new PowerCore(10_000); // placeholder capacity
    }

    public UUID getId() {
        return id;
    }

    public MEStorage getStorage() {
        return storage;
    }

    public PowerCore getPower() {
        return power;
    }

    public boolean isOnline() {
        return power.isOnline();
    }
}
