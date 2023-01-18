
package net.mcreator.hafnium.item;

import net.minecraft.entity.ai.attributes.Attributes;

@HafniumModElements.ModElement.Tag
public class HolniumSwordItem extends HafniumModElements.ModElement {

	@ObjectHolder("hafnium:holnium_sword")
	public static final Item block = null;

	public HolniumSwordItem(HafniumModElements instance) {
		super(instance, 40);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 2380;
			}

			public float getEfficiency() {
				return 16f;
			}

			public float getAttackDamage() {
				return 28f;
			}

			public int getHarvestLevel() {
				return 10;
			}

			public int getEnchantability() {
				return 70;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(HolniumItem.block));
			}
		}, 3, 11f, new Item.Properties().group(ItemGroup.COMBAT)) {

			@Override
			@OnlyIn(Dist.CLIENT)
			public boolean hasEffect(ItemStack itemstack) {
				return true;
			}

		}.setRegistryName("holnium_sword"));
	}

}
