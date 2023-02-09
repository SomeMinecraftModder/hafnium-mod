package net.mcreator.hafnium.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.hafnium.block.SmelterBlock;
import net.mcreator.hafnium.block.ManacristalisatorBlock;
import net.mcreator.hafnium.block.CentrifugeBlock;
import net.mcreator.hafnium.block.AdvancedsmeltercontrolerBlock;
import net.mcreator.hafnium.HafniumMod;

import java.util.Map;

public class BasicUnclaimFinderOnPlayerStoppedUsingProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				HafniumMod.LOGGER.warn("Failed to load dependency world for procedure BasicUnclaimFinderOnPlayerStoppedUsing!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				HafniumMod.LOGGER.warn("Failed to load dependency x for procedure BasicUnclaimFinderOnPlayerStoppedUsing!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				HafniumMod.LOGGER.warn("Failed to load dependency y for procedure BasicUnclaimFinderOnPlayerStoppedUsing!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				HafniumMod.LOGGER.warn("Failed to load dependency z for procedure BasicUnclaimFinderOnPlayerStoppedUsing!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				HafniumMod.LOGGER.warn("Failed to load dependency entity for procedure BasicUnclaimFinderOnPlayerStoppedUsing!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double level = 0;
		level = 0;
		sx = (-8);
		found = (false);
		for (int index0 = 0; index0 < (int) (16); index0++) {
			sy = (-25);
			for (int index1 = 0; index1 < (int) (50); index1++) {
				sz = (-8);
				for (int index2 = 0; index2 < (int) (16); index2++) {
					if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.CHEST) {
						level = (level + 1);
					}
					if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.ENDER_CHEST) {
						level = (level + 1);
					}
					if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == CentrifugeBlock.block) {
						level = (level + 1);
					}
					if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == SmelterBlock.block) {
						level = (level + 1);
					}
					if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == ManacristalisatorBlock.block) {
						level = (level + 1);
					}
					if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == AdvancedsmeltercontrolerBlock.block) {
						level = (level + 1);
					}
					if (BlockTags.getCollection().getTagByID(new ResourceLocation("forge:unclaim_finder"))
							.contains((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock())) {
						level = (level + 1);
					}
					sz = (sz + 1);
				}
				sy = (sy + 1);
			}
			sx = (sx + 1);
		}
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent((level + " %")), (true));
		}
	}
}
