package data;

import core.MENetwork;
import util.ItemKey;

import java.io.*;
import java.util.Map;
import java.util.UUID;

public class NetworkSaveData {

    private static final String FILE_NAME = "network.dat";

    public static void save(MENetwork network) {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(FILE_NAME))) {

            out.writeObject(network.getId());
            out.writeObject(network.getPower().getPower());
            out.writeObject(network.getStorage().getSnapshot());

            System.out.println("[ME] Network saved.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static MENetwork load() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("[ME] No save found. Creating new network.");
            return new MENetwork();
        }

        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(file))) {

            UUID id = (UUID) in.readObject();
            long power = (long) in.readObject();
            Map<ItemKey, Long> items = (Map<ItemKey, Long>) in.readObject();

            MENetwork network = new MENetwork();
            network.getPower().addPower(power - network.getPower().getPower());
            items.forEach((k, v) -> network.getStorage().insert(k, v));

            System.out.println("[ME] Network loaded: " + id);
            return network;

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new MENetwork();
        }
    }
}
