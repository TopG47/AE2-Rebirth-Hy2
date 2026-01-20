package plugin;

import blocks.MEDriveBlock;
import blocks.METerminalBlock;
import blocks.WorldEngineCrystalBlock;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class HytaleBlockAdapter {

    private static final Map<UUID, WorldEngineCrystalBlock> CRYSTALS = new HashMap<>();
    private static final Map<UUID, METerminalBlock> TERMINALS = new HashMap<>();

    public static UUID placeCrystal() {
        UUID blockId = UUID.randomUUID();

        WorldEngineCrystalBlock crystal = new WorldEngineCrystalBlock();
        crystal.onPlaced();
        CRYSTALS.put(blockId, crystal);

        return blockId;
    }

    public static void placeDrive(UUID crystalBlockId) {
        WorldEngineCrystalBlock crystal = CRYSTALS.get(crystalBlockId);

        MEDriveBlock drive = new MEDriveBlock();
        drive.onPlaced(crystal.getNetworkId());
    }

    public static UUID placeTerminal(UUID crystalBlockId) {
        UUID blockId = UUID.randomUUID();

        WorldEngineCrystalBlock crystal = CRYSTALS.get(crystalBlockId);

        METerminalBlock terminal = new METerminalBlock();
        terminal.onPlaced(crystal.getNetworkId());

        TERMINALS.put(blockId, terminal);
        return blockId;
    }

    public static void interactTerminal(UUID terminalBlockId) {
        TERMINALS.get(terminalBlockId).onInteract();
    }
}
