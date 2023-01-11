package net.mcreator.hafnium.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Util;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.hafnium.block.AdvancedbrickBlock;
import net.mcreator.hafnium.HafniumMod;

import java.util.Map;

public class AdvancedsmeltercontrolerOnBlockRightClickedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				HafniumMod.LOGGER.warn("Failed to load dependency world for procedure AdvancedsmeltercontrolerOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				HafniumMod.LOGGER.warn("Failed to load dependency x for procedure AdvancedsmeltercontrolerOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				HafniumMod.LOGGER.warn("Failed to load dependency y for procedure AdvancedsmeltercontrolerOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				HafniumMod.LOGGER.warn("Failed to load dependency z for procedure AdvancedsmeltercontrolerOnBlockRightClicked!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		boolean sucess = false;
		world.setBlockState(new BlockPos(x, y + 2, z), (world.getBlockState(new BlockPos(z + 1, y - 1, z + 1))), 3);
		sucess = (true);
		if (!((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == AdvancedbrickBlock.block)) {
			if (!world.isRemote()) {
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().func_232641_a_(new StringTextComponent("1"), ChatType.SYSTEM, Util.DUMMY_UUID);
			}
			sucess = (false);
		}
		if (!((world.getBlockState(new BlockPos(x, y - 2, z))).getBlock() == Blocks.LAVA)) {
			if (!world.isRemote()) {
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().func_232641_a_(new StringTextComponent("2"), ChatType.SYSTEM, Util.DUMMY_UUID);
			}
			sucess = (false);
		}
		if (!((world.getBlockState(new BlockPos(x, y - 3, z))).getBlock() == AdvancedbrickBlock.block)) {
			if (!world.isRemote()) {
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().func_232641_a_(new StringTextComponent("3"), ChatType.SYSTEM, Util.DUMMY_UUID);
			}
			sucess = (false);
		}
		if (!((world.getBlockState(new BlockPos(x + 1, y - 1, z))).getBlock() == AdvancedbrickBlock.block)) {
			if (!world.isRemote()) {
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().func_232641_a_(new StringTextComponent("4"), ChatType.SYSTEM, Util.DUMMY_UUID);
			}
			sucess = (false);
		}
		if (!((world.getBlockState(new BlockPos(x + 1, y - 2, z))).getBlock() == AdvancedbrickBlock.block)) {
			if (!world.isRemote()) {
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().func_232641_a_(new StringTextComponent("5"), ChatType.SYSTEM, Util.DUMMY_UUID);
			}
			sucess = (false);
		}
		if (!((world.getBlockState(new BlockPos(x + 1, y - 3, z))).getBlock() == AdvancedbrickBlock.block)) {
			if (!world.isRemote()) {
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().func_232641_a_(new StringTextComponent("6"), ChatType.SYSTEM, Util.DUMMY_UUID);
			}
			sucess = (false);
		}
		if (!((world.getBlockState(new BlockPos(x - 1, y - 1, z))).getBlock() == AdvancedbrickBlock.block)) {
			sucess = (false);
		}
		if (!((world.getBlockState(new BlockPos(x - 1, y - 2, z))).getBlock() == AdvancedbrickBlock.block)) {
			sucess = (false);
		}
		if (!((world.getBlockState(new BlockPos(x - 1, y - 3, z))).getBlock() == AdvancedbrickBlock.block)) {
			sucess = (false);
		}
		if (!((world.getBlockState(new BlockPos(x, y - 1, z + 1))).getBlock() == AdvancedbrickBlock.block)) {
			sucess = (false);
		}
		if (!((world.getBlockState(new BlockPos(x, y - 2, z + 1))).getBlock() == AdvancedbrickBlock.block)) {
			sucess = (false);
		}
		if (!((world.getBlockState(new BlockPos(x, y - 3, z + 1))).getBlock() == AdvancedbrickBlock.block)) {
			sucess = (false);
		}
		if (!((world.getBlockState(new BlockPos(x, y - 1, z - 1))).getBlock() == AdvancedbrickBlock.block)) {
			sucess = (false);
		}
		if (!((world.getBlockState(new BlockPos(x, y - 2, z - 1))).getBlock() == AdvancedbrickBlock.block)) {
			sucess = (false);
		}
		if (!((world.getBlockState(new BlockPos(x, y - 3, z - 1))).getBlock() == AdvancedbrickBlock.block)) {
			sucess = (false);
		}
		if (!((world.getBlockState(new BlockPos(z + 1, y - 1, z + 1))).getBlock() == AdvancedbrickBlock.block)) {
			if (!world.isRemote()) {
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().func_232641_a_(new StringTextComponent("7"), ChatType.SYSTEM, Util.DUMMY_UUID);
			}
			sucess = (false);
		}
		if (!((world.getBlockState(new BlockPos(z + 1, y - 2, z + 1))).getBlock() == AdvancedbrickBlock.block)) {
			if (!world.isRemote()) {
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().func_232641_a_(new StringTextComponent("8"), ChatType.SYSTEM, Util.DUMMY_UUID);
			}
			sucess = (false);
		}
		if (!((world.getBlockState(new BlockPos(z + 1, y - 3, z + 1))).getBlock() == AdvancedbrickBlock.block)) {
			sucess = (false);
		}
		if (!((world.getBlockState(new BlockPos(z - 1, y - 1, z + 1))).getBlock() == AdvancedbrickBlock.block)) {
			sucess = (false);
		}
		if (!((world.getBlockState(new BlockPos(z - 1, y - 2, z + 1))).getBlock() == AdvancedbrickBlock.block)) {
			sucess = (false);
		}
		if (!((world.getBlockState(new BlockPos(z - 1, y - 3, z + 1))).getBlock() == AdvancedbrickBlock.block)) {
			sucess = (false);
		}
		if (!((world.getBlockState(new BlockPos(z + 1, y - 1, z - 1))).getBlock() == AdvancedbrickBlock.block)) {
			sucess = (false);
		}
		if (!((world.getBlockState(new BlockPos(z + 1, y - 2, z - 1))).getBlock() == AdvancedbrickBlock.block)) {
			sucess = (false);
		}
		if (!((world.getBlockState(new BlockPos(z + 1, y - 3, z - 1))).getBlock() == AdvancedbrickBlock.block)) {
			sucess = (false);
		}
		if (!((world.getBlockState(new BlockPos(z - 1, y - 1, z - 1))).getBlock() == AdvancedbrickBlock.block)) {
			sucess = (false);
		}
		if (!((world.getBlockState(new BlockPos(z - 1, y - 2, z - 1))).getBlock() == AdvancedbrickBlock.block)) {
			sucess = (false);
		}
		if (!((world.getBlockState(new BlockPos(z - 1, y - 3, z - 1))).getBlock() == AdvancedbrickBlock.block)) {
			sucess = (false);
		}
		if (sucess) {
			if (!world.isRemote()) {
				BlockPos _bp = new BlockPos(x, y, z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putBoolean("work", (true));
				if (world instanceof World)
					((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			if (!world.isRemote()) {
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().func_232641_a_(new StringTextComponent("Message"), ChatType.SYSTEM, Util.DUMMY_UUID);
			}
		} else {
			if (!world.isRemote()) {
				BlockPos _bp = new BlockPos(x, y, z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putBoolean("work", (false));
				if (world instanceof World)
					((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			if (!world.isRemote()) {
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().func_232641_a_(new StringTextComponent("tkt"), ChatType.SYSTEM, Util.DUMMY_UUID);
			}
		}
	}
}
