package net.mcreator.hafnium.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BlockEvent;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.hafnium.block.UraniumOreBlock;
import net.mcreator.hafnium.block.HafniumOreBlock;
import net.mcreator.hafnium.HafniumModVariables;
import net.mcreator.hafnium.HafniumMod;

import java.util.Map;
import java.util.HashMap;

public class JobminerProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onBlockBreak(BlockEvent.BreakEvent event) {
			Entity entity = event.getPlayer();
			IWorld world = event.getWorld();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("xpAmount", event.getExpToDrop());
			dependencies.put("x", event.getPos().getX());
			dependencies.put("y", event.getPos().getY());
			dependencies.put("z", event.getPos().getZ());
			dependencies.put("px", entity.getPosX());
			dependencies.put("py", entity.getPosY());
			dependencies.put("pz", entity.getPosZ());
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("blockstate", event.getState());
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("blockstate") == null) {
			if (!dependencies.containsKey("blockstate"))
				HafniumMod.LOGGER.warn("Failed to load dependency blockstate for procedure Jobminer!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				HafniumMod.LOGGER.warn("Failed to load dependency entity for procedure Jobminer!");
			return;
		}
		BlockState blockstate = (BlockState) dependencies.get("blockstate");
		Entity entity = (Entity) dependencies.get("entity");
		if (blockstate.getBlock() == HafniumOreBlock.block || blockstate.getBlock() == Blocks.NETHER_QUARTZ_ORE
				|| blockstate.getBlock() == UraniumOreBlock.block || blockstate.getBlock() == Blocks.IRON_ORE) {
			{
				double _setval = ((entity.getCapability(HafniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new HafniumModVariables.PlayerVariables())).job_miner + 1);
				entity.getCapability(HafniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.job_miner = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(("Miner: " + (Math
						.round((entity.getCapability(HafniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new HafniumModVariables.PlayerVariables())).job_miner)
						+ "" + (" xp/" + (5000 + (entity.getCapability(HafniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new HafniumModVariables.PlayerVariables())).job_miner_lvl * 1000))))),
						(true));
			}
			if ((entity.getCapability(HafniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new HafniumModVariables.PlayerVariables())).job_miner == 5000
							+ (entity.getCapability(HafniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new HafniumModVariables.PlayerVariables())).job_miner_lvl * 1000) {
				{
					double _setval = 0;
					entity.getCapability(HafniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.job_miner = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = ((entity.getCapability(HafniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new HafniumModVariables.PlayerVariables())).job_miner_lvl + 1);
					entity.getCapability(HafniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.job_miner_lvl = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
							("Farmer level: " + (Math.round((entity.getCapability(HafniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new HafniumModVariables.PlayerVariables())).job_miner_lvl) + " !"))),
							(true));
				}
			}
		}
	}
}
