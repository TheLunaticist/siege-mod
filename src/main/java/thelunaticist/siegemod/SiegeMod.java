package thelunaticist.siegemod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import thelunaticist.siegemod.blockentities.NexusBlockEntity;
import thelunaticist.siegemod.blocks.Nexus;

public class SiegeMod implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("siegemod");

    public static final Nexus NEXUS_BLOCK = new Nexus(FabricBlockSettings.of(Material.METAL));
    public static BlockEntityType<NexusBlockEntity> NEXUS_BLOCK_ENTITY;
    public static final BlockItem NEXUS_ITEM = new BlockItem(NEXUS_BLOCK, new FabricItemSettings().group(ItemGroup.MISC));

    @Override
    public void onInitialize(){
        LOGGER.info("information is good");

        //Nexus
        Registry.register(Registry.BLOCK, new Identifier("siegemod", "nexus"), NEXUS_BLOCK);
         NEXUS_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "siegemod:nexus_block_entity", FabricBlockEntityTypeBuilder.create(NexusBlockEntity::new, NEXUS_BLOCK).build());
         Registry.register(Registry.ITEM, new Identifier("siegemod", "nexus"), NEXUS_ITEM);
    }
}
