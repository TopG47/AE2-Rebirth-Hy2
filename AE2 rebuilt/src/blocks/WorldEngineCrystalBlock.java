package blocks;

import core.MENetwork;
import plugin.ElementalMENetworkPlugin;

import java.util.UUID;

public class WorldEngineCrystalBlock {

    private UUID networkId;

    public void onPlaced() {
        MENetwork network = ElementalMENetworkPlugin.createNetwork();
        this.networkId = network.getId();
        System.out.println("[ME] Crystal placed. Network: " + networkId);
    }

    public void onBroken() {
        if (networkId != null) {
            ElementalMENetworkPlugin.removeNetwork(networkId);
            System.out.println("[ME] Crystal broken. Network destroyed: " + networkId);
            networkId = null;
        }
    }

    public UUID getNetworkId() {
        return networkId;
    }
}
