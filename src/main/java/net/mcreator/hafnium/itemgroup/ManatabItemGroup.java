
package net.mcreator.hafnium.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.hafnium.item.StabilizedManaItem;
import net.mcreator.hafnium.HafniumModElements;

@HafniumModElements.ModElement.Tag
public class ManatabItemGroup extends HafniumModElements.ModElement {
	public ManatabItemGroup(HafniumModElements instance) {
		super(instance, 137);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabmanatab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(StabilizedManaItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
