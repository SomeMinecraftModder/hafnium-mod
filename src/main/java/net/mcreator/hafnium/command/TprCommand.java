
package net.mcreator.hafnium.command;

@Mod.EventBusSubscriber
public class TprCommand {

	@SubscribeEvent
	public static void registerCommands(RegisterCommandsEvent event) {
		event.getDispatcher().register(LiteralArgumentBuilder.<CommandSource>literal("rtp")

				.then(Commands.argument("arguments", StringArgumentType.greedyString()).executes(TprCommand::execute)).executes(TprCommand::execute));
	}

	private static int execute(CommandContext<CommandSource> ctx) {
		ServerWorld world = ctx.getSource().getWorld();

		double x = ctx.getSource().getPos().getX();
		double y = ctx.getSource().getPos().getY();
		double z = ctx.getSource().getPos().getZ();

		Entity entity = ctx.getSource().getEntity();
		if (entity == null)
			entity = FakePlayerFactory.getMinecraft(world);

		HashMap<String, String> cmdparams = new HashMap<>();
		int[] index = {-1};
		Arrays.stream(ctx.getInput().split("\\s+")).forEach(param -> {
			if (index[0] >= 0)
				cmdparams.put(Integer.toString(index[0]), param);
			index[0]++;
		});

		TprCommandExecutedProcedure
				.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));

		return 0;
	}

}