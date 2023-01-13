package net.mcreator.hafnium.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.GameType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.block.Block;

import net.mcreator.hafnium.HafniumMod;

import java.util.Map;

public class HolniumPickaxeBlockDestroyedWithToolProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				HafniumMod.LOGGER.warn("Failed to load dependency world for procedure HolniumPickaxeBlockDestroyedWithTool!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				HafniumMod.LOGGER.warn("Failed to load dependency x for procedure HolniumPickaxeBlockDestroyedWithTool!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				HafniumMod.LOGGER.warn("Failed to load dependency y for procedure HolniumPickaxeBlockDestroyedWithTool!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				HafniumMod.LOGGER.warn("Failed to load dependency z for procedure HolniumPickaxeBlockDestroyedWithTool!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				HafniumMod.LOGGER.warn("Failed to load dependency entity for procedure HolniumPickaxeBlockDestroyedWithTool!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack pickaxe = ItemStack.EMPTY;
		double baseRate = 0;
		double rateWithAmplifier = 0;
		double EnchtSize = 0;
		double i = 0;
		double j = 0;
		double k = 0;
		if (!entity.isSneaking()) {
			pickaxe = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
			EnchtSize = (EnchantmentHelper.getEnchantmentLevel(Enchantments.EFFICIENCY, (pickaxe)) + 1);
			i = (x - EnchtSize);
			for (int index0 = 0; index0 < (int) (EnchtSize * 2 + 1); index0++) {
				j = (y - EnchtSize);
				for (int index1 = 0; index1 < (int) (EnchtSize * 2 + 1); index1++) {
					k = (z - EnchtSize);
					for (int index2 = 0; index2 < (int) (EnchtSize * 2 + 1); index2++) {
						if (world.getBlockState(new BlockPos(i, j, k)).isSolid()
								&& (pickaxe).getItem().canHarvestBlock((world.getBlockState(new BlockPos(i, j, k))))
								&& world.getBlockState(new BlockPos(i, j, k)).getBlockHardness(world, new BlockPos(i, j, k)) >= 0) {
							if (new Object() {
								public boolean checkGamemode(Entity _ent) {
									if (_ent instanceof ServerPlayerEntity) {
										return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
									} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
										NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
												.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
										return _npi != null && _npi.getGameType() == GameType.CREATIVE;
									}
									return false;
								}
							}.checkGamemode(entity)) {
								world.destroyBlock(new BlockPos(i, j, k), false);
							} else {
								if (world instanceof World) {
									Block.spawnDrops(world.getBlockState(new BlockPos(i, j, k)), (World) world, new BlockPos(i, j, k));
									world.destroyBlock(new BlockPos(i, j, k), false);
								}
							}
						}
						k = (k + 1);
					}
					j = (j + 1);
				}
				i = (i + 1);
			}
		}
	}
}
