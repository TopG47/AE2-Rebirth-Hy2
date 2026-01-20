package blocks;

import core.MENetwork;
import plugin.ElementalMENetworkPlugin;

import java.util.UUID;

public class MEDriveBlock {

    private static final long DRIVE_CAPACITY = 1024;

    public void onPlaced(UUID networkId) {
        MENetwork network = ElementalMENetworkPlugin.getNetwork(networkId);
        network.getStorage().addCapacity(DRIVE_CAPACITY);
        System.out.println("[ME] Drive added to network " + networkId);
    }
}
