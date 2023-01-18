
package net.mcreator.hafnium.item;

import net.minecraft.entity.ai.attributes.Attributes;

@HafniumModElements.ModElement.Tag
public class Cristalized_EmeraldPickaxeItem extends HafniumModElements.ModElement {

	@ObjectHolder("hafnium:cristalized_emerald_pickaxe")
	public static final Item block = null;

	public Cristalized_EmeraldPickaxeItem(HafniumModElements instance) {
		super(instance, 34);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 750;
			}

			public float getEfficiency() {
				return 12f;
			}

			public float getAttackDamage() {
				return 0f;
			}

			public int getHarvestLevel() {
				return 6;
			}

			public int getEnchantability() {
				return 14;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Cristalized_EmeraldItem.block));
			}
		}, 1, -3f, new Item.Properties().group(ItemGroup.TOOLS)) {

		}.setRegistryName("cristalized_emerald_pickaxe"));
	}

}
