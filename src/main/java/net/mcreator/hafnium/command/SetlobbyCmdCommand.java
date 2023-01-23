
package net.mcreator.hafnium.command;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.common.util.FakePlayerFactory;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.util.Direction;
import net.minecraft.entity.Entity;
import net.minecraft.command.Commands;
import net.minecraft.command.CommandSource;

import net.mcreator.hafnium.procedures.SetlobbyProcedure;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.arguments.DoubleArgumentType;

@Mod.EventBusSubscriber
public class SetlobbyCmdCommand {
	@SubscribeEvent
	public static void registerCommands(RegisterCommandsEvent event) {
		event.getDispatcher()
				.register(LiteralArgumentBuilder.<CommandSource>literal("setlobby").requires(s -> s.hasPermissionLevel(4))
						.then(Commands.argument("x", DoubleArgumentType.doubleArg()).then(Commands.argument("y", DoubleArgumentType.doubleArg())
								.then(Commands.argument("z", DoubleArgumentType.doubleArg()).executes(arguments -> {
									ServerWorld world = arguments.getSource().getWorld();
									double x = arguments.getSource().getPos().getX();
									double y = arguments.getSource().getPos().getY();
									double z = arguments.getSource().getPos().getZ();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getHorizontalFacing();

									SetlobbyProcedure.executeProcedure(Stream
											.of(new AbstractMap.SimpleEntry<>("arguments", arguments),
													new AbstractMap.SimpleEntry<>("entity", entity))
											.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
									return 0;
								})))));
	}
}
