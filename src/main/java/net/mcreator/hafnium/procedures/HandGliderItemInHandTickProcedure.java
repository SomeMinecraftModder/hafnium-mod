package net.mcreator.hafnium.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.hafnium.HafniumModVariables;
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
		if ((entity.getCapability(HafniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new HafniumModVariables.PlayerVariables())).is_gang_glider_enabled) {
			if (entity.isOnGround()) {
				{
					boolean _setval = (false);
					entity.getCapability(HafniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.is_gang_glider_enabled = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (entity.isSneaking()) {
				if (Math.abs(entity.getMotion().getX()) + Math.abs(entity.getMotion().getZ()) < 0.6) {
					entity.setMotion((entity.getMotion().getX() / 2 + entity.getMotion().getX()), (entity.getMotion().getY() + 0.05),
							(entity.getMotion().getZ() / 2 + entity.getMotion().getZ()));
				} else {
					entity.setMotion((entity.getMotion().getX()), (entity.getMotion().getY() + 0.05), (entity.getMotion().getZ()));
				}
			} else {
				entity.setMotion((entity.getMotion().getX()), (entity.getMotion().getY() + 0.07), (entity.getMotion().getZ()));
			}
		}
	}
}
