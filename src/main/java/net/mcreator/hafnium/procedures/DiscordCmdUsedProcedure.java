package net.mcreator.hafnium.procedures;

import net.minecraftforge.eventbus.api.Event;

public class DiscordCmdUsedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				HafniumMod.LOGGER.warn("Failed to load dependency world for procedure DiscordCmdUsed!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				HafniumMod.LOGGER.warn("Failed to load dependency x for procedure DiscordCmdUsed!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				HafniumMod.LOGGER.warn("Failed to load dependency y for procedure DiscordCmdUsed!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				HafniumMod.LOGGER.warn("Failed to load dependency z for procedure DiscordCmdUsed!");
			return;
		}

		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");

		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"tellraw @p {\"text\":\"Rejoigner le serveur discord ici en clickant ici! \",\"clickEvent\":{\"action\":\"open_url\",\"value\":\"https://discord.gg/jxSRWSJu2w\"}}");
		}
	}

}
