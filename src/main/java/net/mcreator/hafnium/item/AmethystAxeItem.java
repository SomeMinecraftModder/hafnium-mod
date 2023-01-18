
package net.mcreator.hafnium.item;

import net.minecraft.entity.ai.attributes.Attributes;

@HafniumModElements.ModElement.Tag
public class AmethystAxeItem extends HafniumModElements.ModElement {

	@ObjectHolder("hafnium:amethyst_axe")
	public static final Item block = null;

	public AmethystAxeItem(HafniumModElements instance) {
		super(instance, 245);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 250;
			}

			public float getEfficiency() {
				return 6f;
			}

			public float getAttackDamage() {
				return 0f;
			}

			public int getHarvestLevel() {
				return 2;
			}

			public int getEnchantability() {
				return 14;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(AmethystShardItem.block));
			}
		}, 1, -3f, new Item.Properties().group(ItemGroup.TOOLS)) {

		}.setRegistryName("amethyst_axe"));
	}

}
