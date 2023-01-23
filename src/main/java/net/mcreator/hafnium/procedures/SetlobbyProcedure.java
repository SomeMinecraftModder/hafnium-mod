package net.mcreator.hafnium.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.command.CommandSource;

import net.mcreator.hafnium.HafniumModVariables;
import net.mcreator.hafnium.HafniumMod;

import java.util.Map;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class SetlobbyProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				HafniumMod.LOGGER.warn("Failed to load dependency world for procedure Setlobby!");
			return;
		}
		if (dependencies.get("arguments") == null) {
			if (!dependencies.containsKey("arguments"))
				HafniumMod.LOGGER.warn("Failed to load dependency arguments for procedure Setlobby!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		CommandContext<CommandSource> arguments = (CommandContext<CommandSource>) dependencies.get("arguments");
		HafniumModVariables.MapVariables.get(world).lobby_x = (DoubleArgumentType.getDouble(arguments, "x"));
		HafniumModVariables.MapVariables.get(world).syncData(world);
		HafniumModVariables.MapVariables.get(world).lobby_y = (DoubleArgumentType.getDouble(arguments, "y"));
		HafniumModVariables.MapVariables.get(world).syncData(world);
		HafniumModVariables.MapVariables.get(world).lobby_z = (DoubleArgumentType.getDouble(arguments, "z"));
		HafniumModVariables.MapVariables.get(world).syncData(world);
	}
}
