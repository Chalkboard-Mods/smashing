package chalkboardmods.smashing.core.forge;

import chalkboardmods.smashing.core.Smashing;
import net.minecraftforge.fml.common.Mod;

@Mod(Smashing.MOD_ID)
public class SmashingForge {
    public SmashingForge() {
        Smashing.PLATFORM.setup();
    }
}
