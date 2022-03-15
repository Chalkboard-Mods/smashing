package chalkboardmods.smashing.core.registry;

import chalkboardmods.smashing.common.block.LargePotBlock;
import chalkboardmods.smashing.common.block.PotBlock;
import chalkboardmods.smashing.common.block.TallPotBlock;
import chalkboardmods.smashing.core.Smashing;
import gg.moonflower.pollen.api.registry.PollinatedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

import java.util.function.Supplier;

public class SmashingBlocks {
    public static final PollinatedRegistry<Block> BLOCKS = PollinatedRegistry.create(Registry.BLOCK, Smashing.MOD_ID);

    public static final Supplier<Block> COMMON_POT = registerBlock("common_pot", () -> new PotBlock(BlockBehaviour.Properties.of(Material.DECORATION).noOcclusion()), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
    public static final Supplier<Block> TALL_COMMON_POT = registerBlock("tall_common_pot", () -> new TallPotBlock(BlockBehaviour.Properties.copy(COMMON_POT.get())), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
    public static final Supplier<Block> LARGE_COMMON_POT = registerBlock("large_common_pot", () -> new LargePotBlock(BlockBehaviour.Properties.copy(COMMON_POT.get())), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));

    private static Supplier<Block> registerBlock(String name, Supplier<Block> block, Item.Properties itemProperties) {
        Supplier<Block> register = BLOCKS.register(name, block);
        SmashingItems.ITEMS.register(name,() -> new BlockItem(register.get(), itemProperties));
        return register;
    }

    private static Supplier<Block> registerBlockWithoutItem(String name, Supplier<Block> block) {
        Supplier<Block> register = BLOCKS.register(name, block);
        return register;
    }
}
