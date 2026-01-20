package ui;

import core.MENetwork;
import plugin.ElementalMENetworkPlugin;
import util.ItemKey;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class METerminalUIController {

    private final MENetwork network;
    private String lastError;

    private static final long STACK_SIZE = 64;
    private static final long POWER_COST = 1;

    public METerminalUIController(UUID networkId) {
        this.network = ElementalMENetworkPlugin.getNetwork(networkId);
    }

    public String power() {
        return "Power: " +
                network.getPower().getPower() +
                " / " +
                network.getPower().getMaxPower();
    }

    public String storage() {
        return "Storage: " +
                network.getStorage().getUsed() +
                " / " +
                network.getStorage().getMaxCapacity();
    }

    public String error() {
        return lastError == null ? "" : "ERROR: " + lastError;
    }

    public List<String> item_list() {
        List<String> items = new ArrayList<>();

        for (Map.Entry<ItemKey, Long> e :
                network.getStorage().getSnapshot().entrySet()) {

            items.add(e.getKey() + " x" + e.getValue());
        }

        return items;
    }

    public void extractStack(String itemId) {
        lastError = null;

        if (!network.isOnline()) {
            lastError = "Network offline";
            return;
        }

        if (network.getPower().getPower() < POWER_COST) {
            lastError = "Not enough power";
            return;
        }

        boolean ok = network.getStorage()
                .extract(new ItemKey(itemId), STACK_SIZE);

        if (!ok) {
            lastError = "Not enough items";
            return;
        }

        network.getPower().consume(POWER_COST);
    }
}
