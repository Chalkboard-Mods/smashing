package chalkboardmods.smashing.core.registry;

import chalkboardmods.smashing.core.Smashing;
import gg.moonflower.pollen.api.registry.PollinatedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.world.item.Item;

public class SmashingItems {
    public static final PollinatedRegistry<Item> ITEMS = PollinatedRegistry.create(Registry.ITEM, Smashing.MOD_ID);
}
