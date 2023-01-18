package net.mcreator.hafnium.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.hafnium.HafniumModVariables;
import net.mcreator.hafnium.HafniumMod;

import java.util.Map;

public class HandGliderRightclickedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				HafniumMod.LOGGER.warn("Failed to load dependency entity for procedure HandGliderRightclicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(HafniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new HafniumModVariables.PlayerVariables())).is_gang_glider_enabled) {
			{
				boolean _setval = (false);
				entity.getCapability(HafniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.is_gang_glider_enabled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			{
				boolean _setval = (true);
				entity.getCapability(HafniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.is_gang_glider_enabled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
