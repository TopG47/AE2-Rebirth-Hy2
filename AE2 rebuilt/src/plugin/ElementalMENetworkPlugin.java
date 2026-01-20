package plugin;

import core.MENetwork;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ElementalMENetworkPlugin {

    private static final Map<UUID, MENetwork> NETWORKS = new HashMap<>();

    public static MENetwork createNetwork() {
        MENetwork network = new MENetwork();
        NETWORKS.put(network.getId(), network);
        System.out.println("[ME] Network created: " + network.getId());
        return network;
    }

    public static MENetwork getNetwork(UUID id) {
        return NETWORKS.get(id);
    }

    public static void removeNetwork(UUID id) {
        NETWORKS.remove(id);
        System.out.println("[ME] Network removed: " + id);
    }
}
