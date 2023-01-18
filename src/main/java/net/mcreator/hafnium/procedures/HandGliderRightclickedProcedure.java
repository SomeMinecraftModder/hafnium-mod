package net.mcreator.hafnium.procedures;

import net.minecraft.world.IWorld;

import net.mcreator.hafnium.HafniumModVariables;
import net.mcreator.hafnium.HafniumMod;

import java.util.Map;

public class HandGliderRightclickedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				HafniumMod.LOGGER.warn("Failed to load dependency world for procedure HandGliderRightclicked!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if (HafniumModVariables.MapVariables.get(world).is_gang_glider_enabled) {
			HafniumModVariables.MapVariables.get(world).is_gang_glider_enabled = (false);
			HafniumModVariables.MapVariables.get(world).syncData(world);
		} else {
			HafniumModVariables.MapVariables.get(world).is_gang_glider_enabled = (true);
			HafniumModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
