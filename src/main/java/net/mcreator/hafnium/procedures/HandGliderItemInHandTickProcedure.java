package net.mcreator.hafnium.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.entity.Entity;

import net.mcreator.hafnium.HafniumModVariables;
import net.mcreator.hafnium.HafniumMod;

import java.util.Map;

public class HandGliderItemInHandTickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				HafniumMod.LOGGER.warn("Failed to load dependency world for procedure HandGliderItemInHandTick!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				HafniumMod.LOGGER.warn("Failed to load dependency entity for procedure HandGliderItemInHandTick!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		if (HafniumModVariables.MapVariables.get(world).is_gang_glider_enabled) {
			if (entity.isOnGround()) {
				HafniumModVariables.MapVariables.get(world).is_gang_glider_enabled = (false);
				HafniumModVariables.MapVariables.get(world).syncData(world);
			}
			if (entity.isSneaking()) {
				if (Math.abs(entity.getMotion().getX()) + Math.abs(entity.getMotion().getZ()) < 0.6) {
					entity.setMotion((entity.getMotion().getX() / 2 + entity.getMotion().getX()), (entity.getMotion().getY() + 0.05),
							(entity.getMotion().getZ() / 2 + entity.getMotion().getZ()));
				} else {
					entity.setMotion((entity.getMotion().getX()), (entity.getMotion().getY() + 0.04), (entity.getMotion().getZ()));
				}
			} else {
				entity.setMotion((entity.getMotion().getX()), (entity.getMotion().getY() + 0.04), (entity.getMotion().getZ()));
			}
		}
	}
}
