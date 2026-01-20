package plugin;

import ui.METerminalUIController;

import java.util.UUID;

public class UISystem {

    public static void openTerminalUI(UUID networkId) {

        METerminalUIController controller =
                new METerminalUIController(networkId);

        System.out.println("[UI] ME Terminal opened");
        render(controller);

        if (!controller.item_list().isEmpty()) {
            String first = controller.item_list().get(0);
            String itemId = first.split(" x")[0];
            controller.extractStack(itemId);
        }

        System.out.println("[UI] --- REFRESH ---");
        render(controller);
    }

    private static void render(METerminalUIController c) {

        System.out.println("[UI] " + c.power());
        System.out.println("[UI] " + c.storage());

        if (!c.error().isEmpty()) {
            System.out.println("[UI] " + c.error());
        }

        c.item_list().forEach(i ->
                System.out.println("[UI] " + i));
    }
}
