package core;

public class PowerCore {

    private long power;
    private final long maxPower;

    public PowerCore(long maxPower) {
        this.maxPower = maxPower;
        this.power = maxPower; // start fully charged
    }

    public boolean consume(long amount) {
        if (amount <= 0) return true;
        if (power < amount) return false;

        power -= amount;
        return true;
    }

    public void addPower(long amount) {
        if (amount <= 0) return;
        power = Math.min(maxPower, power + amount);
    }

    public boolean isOnline() {
        return power > 0;
    }

    public long getPower() {
        return power;
    }

    public long getMaxPower() {
        return maxPower;
    }
}
