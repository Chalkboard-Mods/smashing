package chalkboardmods.smashing.core.registry;

import chalkboardmods.smashing.core.Smashing;
import gg.moonflower.pollen.api.registry.PollinatedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class SmashingItems {
    public static final PollinatedRegistry<Item> ITEMS = PollinatedRegistry.create(Registry.ITEM, Smashing.MOD_ID);

    public static final Supplier<Item> COMMON_SHARD = ITEMS.register("common_shard", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
}
