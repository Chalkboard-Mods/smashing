package chalkboardmods.smashing.core.fabric;

import chalkboardmods.smashing.core.Smashing;
import chalkboardmods.smashing.core.fabric.other.FabricGeneration;
import net.fabricmc.api.ModInitializer;

public class SmashingFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Smashing.PLATFORM.setup();
        FabricGeneration.onInit();
    }
}
