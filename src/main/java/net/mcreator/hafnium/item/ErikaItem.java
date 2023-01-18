
package net.mcreator.hafnium.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;

import net.mcreator.hafnium.HafniumModElements;

@HafniumModElements.ModElement.Tag
public class ErikaItem extends HafniumModElements.ModElement {
	@ObjectHolder("hafnium:erika")
	public static final Item block = null;

	public ErikaItem(HafniumModElements instance) {
		super(instance, 259);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, HafniumModElements.sounds.get(new ResourceLocation("hafnium:erika")),
					new Item.Properties().group(ItemGroup.MISC).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("erika");
		}
	}
}
