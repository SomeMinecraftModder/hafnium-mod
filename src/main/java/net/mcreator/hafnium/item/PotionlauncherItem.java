
package net.mcreator.hafnium.item;

import net.minecraft.entity.ai.attributes.Attributes;

@HafniumModElements.ModElement.Tag
public class PotionlauncherItem extends HafniumModElements.ModElement {

	@ObjectHolder("hafnium:potionlauncher")
	public static final Item block = null;

	public PotionlauncherItem(HafniumModElements instance) {
		super(instance, 268);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("potionlauncher");
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
