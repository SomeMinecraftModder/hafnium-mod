package net.mcreator.hafnium.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.hafnium.HafniumMod;

import java.util.Map;

public class HandGliderItemInHandTickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				HafniumMod.LOGGER.warn("Failed to load dependency entity for procedure HandGliderItemInHandTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity.isSneaking()) {
			entity.setMotion((entity.getMotion().getX()), (entity.getMotion().getY() + 0.02), (entity.getMotion().getZ()));
		} else {
			entity.setMotion((entity.getMotion().getX()), (entity.getMotion().getY() + 0.05), (entity.getMotion().getZ()));
		}
	}
}
