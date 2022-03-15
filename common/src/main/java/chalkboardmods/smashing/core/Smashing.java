package chalkboardmods.smashing.core;

import chalkboardmods.smashing.core.registry.SmashingBlocks;
import chalkboardmods.smashing.core.registry.SmashingItems;
import chalkboardmods.smashing.core.registry.SmashingSounds;
import gg.moonflower.pollen.api.platform.Platform;

public class Smashing {
    public static final String MOD_ID = "smashing";
    public static final Platform PLATFORM = Platform.builder(MOD_ID)
            .clientInit(Smashing::onClientInit)
            .clientPostInit(Smashing::onClientPostInit)
            .commonInit(Smashing::onCommonInit)
            .commonPostInit(Smashing::onCommonPostInit)
            .dataInit(Smashing::onDataInit)
            .build();

    public static void onClientInit() {
    }

    public static void onClientPostInit(Platform.ModSetupContext ctx) {
    }

    public static void onCommonInit() {
        SmashingBlocks.BLOCKS.register(PLATFORM);
        SmashingItems.ITEMS.register(PLATFORM);
        SmashingSounds.SOUNDS.register(PLATFORM);
    }

    public static void onCommonPostInit(Platform.ModSetupContext ctx) {
    }

    public static void onDataInit(Platform.DataSetupContext ctx) {
    }
}
