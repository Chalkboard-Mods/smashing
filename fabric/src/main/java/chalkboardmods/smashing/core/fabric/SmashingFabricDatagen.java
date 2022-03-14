package chalkboardmods.smashing.core.fabric;

import chalkboardmods.smashing.core.Smashing;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class SmashingFabricDatagen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator dataGenerator) {
        Smashing.PLATFORM.dataSetup(dataGenerator);
    }
}
