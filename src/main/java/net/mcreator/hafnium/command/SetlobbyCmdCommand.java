
package net.mcreator.hafnium.command;

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
