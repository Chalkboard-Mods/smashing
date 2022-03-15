package chalkboardmods.smashing.core.forge;

import chalkboardmods.smashing.core.Smashing;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Smashing.MOD_ID)
public class SmashingForge {
    public SmashingForge() {
        Smashing.PLATFORM.setup();
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
    }
}
