package org.icannt.netherendingores.common.registry;

import java.util.HashSet;
import java.util.Set;

import org.icannt.netherendingores.NetherendingOres;
import org.icannt.netherendingores.client.block.itemblock.ItemBlockOreModded1;
import org.icannt.netherendingores.client.block.itemblock.ItemBlockOreOther1;
import org.icannt.netherendingores.client.block.itemblock.ItemBlockOreVanilla;
import org.icannt.netherendingores.common.block.blocks.BlockOreEndModded1;
import org.icannt.netherendingores.common.block.blocks.BlockOreEndVanilla;
import org.icannt.netherendingores.common.block.blocks.BlockOreNetherModded1;
import org.icannt.netherendingores.common.block.blocks.BlockOreNetherVanilla;
import org.icannt.netherendingores.common.block.blocks.BlockOreOther1;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

/**
 * Created by ICannt on 17/08/17.
 */

@GameRegistry.ObjectHolder(NetherendingOres.MOD_ID)
public class BlockRegistry {

    @GameRegistry.ObjectHolder("ore_nether_vanilla")
    public static final BlockOreNetherVanilla ORE_NETHER_VANILLA = new BlockOreNetherVanilla();
    
    @GameRegistry.ObjectHolder("ore_nether_modded_1")
    public static final BlockOreNetherModded1 ORE_NETHER_MODDED_1 = new BlockOreNetherModded1();
    
    @GameRegistry.ObjectHolder("ore_end_vanilla")
    public static final BlockOreEndVanilla ORE_END_VANILLA = new BlockOreEndVanilla();
    
    @GameRegistry.ObjectHolder("ore_end_modded_1")
    public static final BlockOreEndModded1 ORE_END_MODDED_1 = new BlockOreEndModded1();
    
    @GameRegistry.ObjectHolder("ore_other_1")
    public static final BlockOreOther1 ORE_OTHER_1 = new BlockOreOther1();

    private static final Block[] blocks = {
            ORE_NETHER_VANILLA,
            ORE_NETHER_MODDED_1,
            ORE_END_VANILLA,
            ORE_END_MODDED_1,
            ORE_OTHER_1
    };    
    
    private static final ItemBlock[] itemBlocks = {
        new ItemBlockOreVanilla(ORE_NETHER_VANILLA),
        new ItemBlockOreModded1(ORE_NETHER_MODDED_1),
        new ItemBlockOreVanilla(ORE_END_VANILLA),
        new ItemBlockOreModded1(ORE_END_MODDED_1),
        new ItemBlockOreOther1(ORE_OTHER_1)
    };
    
    @Mod.EventBusSubscriber
    public static class RegistrationHandler {
        public static final Set<ItemBlock> ITEM_BLOCKS = new HashSet<>();

        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
            final IForgeRegistry<Block> registry = event.getRegistry();
            registry.registerAll(blocks);
        }

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            final IForgeRegistry<Item> registry = event.getRegistry();
            for (ItemBlock iB : itemBlocks) {
                registry.register(iB.setRegistryName(iB.getBlock().getRegistryName()));
                ITEM_BLOCKS.add(iB);
            }
        }

    }
    
    @SideOnly(Side.CLIENT)
    public static void initModels() {
    	ORE_NETHER_VANILLA.initItemBlockModels();
    	ORE_NETHER_MODDED_1.initItemBlockModels();
    	ORE_END_VANILLA.initItemBlockModels();
    	ORE_END_MODDED_1.initItemBlockModels();
    	ORE_OTHER_1.initItemBlockModels();
    }

}
