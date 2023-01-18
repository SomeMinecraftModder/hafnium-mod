package net.mcreator.hafnium.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.Util;
import net.minecraft.server.MinecraftServer;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import net.mcreator.hafnium.HafniumModVariables;
import net.mcreator.hafnium.HafniumMod;

import java.util.Map;
import java.util.HashMap;

public class ClearLagProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onWorldTick(TickEvent.WorldTickEvent event) {
			if (event.phase == TickEvent.Phase.END) {
				IWorld world = event.world;
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("world", world);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				HafniumMod.LOGGER.warn("Failed to load dependency world for procedure ClearLag!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if (HafniumModVariables.MapVariables.get(world).clearlagnum == 6000) {
			HafniumModVariables.MapVariables.get(world).clearlagnum = 0;
			HafniumModVariables.MapVariables.get(world).syncData(world);
			if (!world.isRemote()) {
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().func_232641_a_(
							new StringTextComponent("\u00A7a[Hafnium] \u00A74Toutes les entit\u00E9s ont \u00E9tait supprim\u00E9s !"),
							ChatType.SYSTEM, Util.DUMMY_UUID);
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager()
						.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d(0, 0, 0), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(), "kill @e[type=item]");
			}
		} else {
			HafniumModVariables.MapVariables.get(world).clearlagnum = (HafniumModVariables.MapVariables.get(world).clearlagnum + 1);
			HafniumModVariables.MapVariables.get(world).syncData(world);
			if (HafniumModVariables.MapVariables.get(world).clearlagnum == 5400) {
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().func_232641_a_(
								new StringTextComponent(
										"\u00A7a[Hafnium] \u00A74 Toutes les entit\u00E9s vont \u00EAtre supprim\u00E9s dans 30 seconde !"),
								ChatType.SYSTEM, Util.DUMMY_UUID);
				}
			}
		}
		HafniumModVariables.MapVariables.get(world).clearlagnum_in_s = ((6000 - HafniumModVariables.MapVariables.get(world).clearlagnum) / 20);
		HafniumModVariables.MapVariables.get(world).syncData(world);
	}
}
