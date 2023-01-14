package net.mcreator.hafnium.procedures;

import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.hafnium.HafniumMod;

import java.util.Random;
import java.util.Map;
import java.util.Collections;

public class TprCommandExecutedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				HafniumMod.LOGGER.warn("Failed to load dependency world for procedure TprCommandExecuted!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				HafniumMod.LOGGER.warn("Failed to load dependency entity for procedure TprCommandExecuted!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		double random_x = 0;
		double random_z = 0;
		random_x = (MathHelper.nextDouble(new Random(), -100000, 100000));
		random_z = (MathHelper.nextDouble(new Random(), -100000, 100000));
		{
			Entity _ent = entity;
			_ent.setPositionAndUpdate(random_x, (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) random_x, (int) random_z)),
					random_z);
			if (_ent instanceof ServerPlayerEntity) {
				((ServerPlayerEntity) _ent).connection.setPlayerLocation(random_x,
						(world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) random_x, (int) random_z)), random_z, _ent.rotationYaw,
						_ent.rotationPitch, Collections.emptySet());
			}
		}
	}
}
