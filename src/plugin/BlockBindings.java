package plugin;

import java.util.UUID;

public class BlockBindings {

    public static void register() {

        UUID crystalA = HytaleBlockAdapter.placeCrystal();
        HytaleBlockAdapter.placeDrive(crystalA);
        UUID terminalA = HytaleBlockAdapter.placeTerminal(crystalA);
        HytaleBlockAdapter.interactTerminal(terminalA);

        UUID crystalB = HytaleBlockAdapter.placeCrystal();
        HytaleBlockAdapter.placeDrive(crystalB);
        UUID terminalB = HytaleBlockAdapter.placeTerminal(crystalB);
        HytaleBlockAdapter.interactTerminal(terminalB);
    }
}
