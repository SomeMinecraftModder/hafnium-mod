package net.mcreator.hafnium.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.hafnium.block.AdvancedsmeltercontrolerBlock;
import net.mcreator.hafnium.block.AdvancedbrickBlock;
import net.mcreator.hafnium.block.AdvancedCasingBlock;
import net.mcreator.hafnium.HafniumMod;

import java.util.Map;

public class AdvancedSmelterCheckProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				HafniumMod.LOGGER.warn("Failed to load dependency world for procedure AdvancedSmelterCheck!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				HafniumMod.LOGGER.warn("Failed to load dependency x for procedure AdvancedSmelterCheck!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				HafniumMod.LOGGER.warn("Failed to load dependency y for procedure AdvancedSmelterCheck!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				HafniumMod.LOGGER.warn("Failed to load dependency z for procedure AdvancedSmelterCheck!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		BlockState middleLineBlock = Blocks.AIR.getDefaultState();
		BlockState interfaceBlock = Blocks.AIR.getDefaultState();
		BlockState crossBlockMiddleLayer = Blocks.AIR.getDefaultState();
		BlockState frame = Blocks.AIR.getDefaultState();
		frame = AdvancedCasingBlock.block.getDefaultState();
		interfaceBlock = AdvancedsmeltercontrolerBlock.block.getDefaultState();
		middleLineBlock = AdvancedbrickBlock.block.getDefaultState();
		crossBlockMiddleLayer = AdvancedbrickBlock.block.getDefaultState();
		if ((world.getBlockState(new BlockPos(x + 1, y + 1, z + 1))).getBlock() == (frame).getBlock()
				&& (world.getBlockState(new BlockPos(x - 1, y + 1, z - 1))).getBlock() == (frame).getBlock()
				&& (world.getBlockState(new BlockPos(x + 1, y + 1, z - 1))).getBlock() == (frame).getBlock()
				&& (world.getBlockState(new BlockPos(x - 1, y + 1, z + 1))).getBlock() == (frame).getBlock()
				&& (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == (frame).getBlock()
				&& (world.getBlockState(new BlockPos(x + 1, y + 1, z))).getBlock() == (middleLineBlock).getBlock()
				&& (world.getBlockState(new BlockPos(x - 1, y + 1, z))).getBlock() == (middleLineBlock).getBlock()
				&& (world.getBlockState(new BlockPos(x, y + 1, z + 1))).getBlock() == (middleLineBlock).getBlock()
				&& (world.getBlockState(new BlockPos(x, y + 1, z - 1))).getBlock() == (middleLineBlock).getBlock()
				&& (world.getBlockState(new BlockPos(x + 1, y - 1, z + 1))).getBlock() == (frame).getBlock()
				&& (world.getBlockState(new BlockPos(x - 1, y - 1, z - 1))).getBlock() == (frame).getBlock()
				&& (world.getBlockState(new BlockPos(x + 1, y - 1, z - 1))).getBlock() == (frame).getBlock()
				&& (world.getBlockState(new BlockPos(x - 1, y - 1, z + 1))).getBlock() == (frame).getBlock()
				&& (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == (frame).getBlock()
				&& (world.getBlockState(new BlockPos(x + 1, y - 1, z))).getBlock() == (middleLineBlock).getBlock()
				&& (world.getBlockState(new BlockPos(x - 1, y - 1, z))).getBlock() == (middleLineBlock).getBlock()
				&& (world.getBlockState(new BlockPos(x, y - 1, z + 1))).getBlock() == (middleLineBlock).getBlock()
				&& (world.getBlockState(new BlockPos(x, y - 1, z - 1))).getBlock() == (middleLineBlock).getBlock()
				&& (world.getBlockState(new BlockPos(x + 1, y, z + 1))).getBlock() == (frame).getBlock()
				&& (world.getBlockState(new BlockPos(x - 1, y, z - 1))).getBlock() == (frame).getBlock()
				&& (world.getBlockState(new BlockPos(x + 1, y, z - 1))).getBlock() == (frame).getBlock()
				&& (world.getBlockState(new BlockPos(x - 1, y, z + 1))).getBlock() == (frame).getBlock()) {
			if ((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == (interfaceBlock).getBlock()
					&& (world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == (crossBlockMiddleLayer).getBlock()
					&& (world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == (crossBlockMiddleLayer).getBlock()
					&& (world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == (crossBlockMiddleLayer).getBlock()) {
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos(x + 1, y, z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putBoolean("canOpenInventory", (true));
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			} else if ((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == (crossBlockMiddleLayer).getBlock()
					&& (world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == (interfaceBlock).getBlock()
					&& (world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == (crossBlockMiddleLayer).getBlock()
					&& (world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == (crossBlockMiddleLayer).getBlock()) {
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos(x - 1, y, z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putBoolean("canOpenInventory", (true));
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			} else if ((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == (crossBlockMiddleLayer).getBlock()
					&& (world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == (crossBlockMiddleLayer).getBlock()
					&& (world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == (interfaceBlock).getBlock()
					&& (world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == (crossBlockMiddleLayer).getBlock()) {
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos(x, y, z + 1);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putBoolean("canOpenInventory", (true));
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			} else if ((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == (crossBlockMiddleLayer).getBlock()
					&& (world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == (crossBlockMiddleLayer).getBlock()
					&& (world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == (crossBlockMiddleLayer).getBlock()
					&& (world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == (interfaceBlock).getBlock()) {
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos(x, y, z - 1);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putBoolean("canOpenInventory", (true));
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			} else {
				if ((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == (interfaceBlock).getBlock()) {
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos(x + 1, y, z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putBoolean("canOpenInventory", (false));
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
				} else if ((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == (interfaceBlock).getBlock()) {
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos(x - 1, y, z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putBoolean("canOpenInventory", (false));
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
				} else if ((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == (interfaceBlock).getBlock()) {
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos(x, y, z + 1);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putBoolean("canOpenInventory", (false));
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
				} else if ((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == (interfaceBlock).getBlock()) {
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos(x, y, z - 1);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putBoolean("canOpenInventory", (false));
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
				}
			}
		} else {
			if ((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == (interfaceBlock).getBlock()) {
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos(x + 1, y, z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putBoolean("canOpenInventory", (false));
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			} else if ((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == (interfaceBlock).getBlock()) {
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos(x - 1, y, z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putBoolean("canOpenInventory", (false));
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			} else if ((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == (interfaceBlock).getBlock()) {
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos(x, y, z + 1);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putBoolean("canOpenInventory", (false));
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			} else if ((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == (interfaceBlock).getBlock()) {
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos(x, y, z - 1);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putBoolean("canOpenInventory", (false));
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			}
		}
	}
}
