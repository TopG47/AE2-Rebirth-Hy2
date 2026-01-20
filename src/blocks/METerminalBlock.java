package blocks;

import plugin.UISystem;

import java.util.UUID;

public class METerminalBlock {

    private UUID networkId;

    public void onPlaced(UUID networkId) {
        this.networkId = networkId;
        System.out.println("[ME] Terminal connected to network " + networkId);
    }

    public void onInteract() {
        UISystem.openTerminalUI(networkId);
    }
}
