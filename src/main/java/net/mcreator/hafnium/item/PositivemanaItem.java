
package net.mcreator.hafnium.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.block.BlockState;

import net.mcreator.hafnium.itemgroup.ManatabItemGroup;
import net.mcreator.hafnium.HafniumModElements;

@HafniumModElements.ModElement.Tag
public class PositivemanaItem extends HafniumModElements.ModElement {
	@ObjectHolder("hafnium:positivemana")
	public static final Item block = null;

	public PositivemanaItem(HafniumModElements instance) {
		super(instance, 137);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ManatabItemGroup.tab).maxStackSize(64).rarity(Rarity.UNCOMMON)
					.food((new Food.Builder()).hunger(4).saturation(0.3f)

							.build()));
			setRegistryName("positivemana");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}
	}
}
