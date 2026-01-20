package plugin;

public class RunPlugin {

    public static void main(String[] args) {

        System.out.println("[SERVER] Starting Hytale Server (simulated)");

        BlockBindings.register();

        System.out.println("[SERVER] Shutdown");
    }
}
