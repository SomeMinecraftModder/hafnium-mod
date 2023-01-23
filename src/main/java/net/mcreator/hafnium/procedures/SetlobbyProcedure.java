package net.mcreator.hafnium.procedures;

import net.minecraftforge.eventbus.api.Event;

public class SetlobbyProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("arguments") == null) {
			if (!dependencies.containsKey("arguments"))
				HafniumMod.LOGGER.warn("Failed to load dependency arguments for procedure Setlobby!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				HafniumMod.LOGGER.warn("Failed to load dependency entity for procedure Setlobby!");
			return;
		}

		CommandContext<CommandSource> arguments = (CommandContext<CommandSource>) dependencies.get("arguments");
		Entity entity = (Entity) dependencies.get("entity");

		{
			double _setval = (DoubleArgumentType.getDouble(arguments, "x"));
			entity.getCapability(HafniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.job_farmer = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = (DoubleArgumentType.getDouble(arguments, "y"));
			entity.getCapability(HafniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.job_farmer = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = (DoubleArgumentType.getDouble(arguments, "z"));
			entity.getCapability(HafniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.job_farmer = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}

}
