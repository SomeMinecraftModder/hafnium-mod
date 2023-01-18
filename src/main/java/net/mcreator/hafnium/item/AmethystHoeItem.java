
package net.mcreator.hafnium.item;

import net.minecraft.entity.ai.attributes.Attributes;

@HafniumModElements.ModElement.Tag
public class AmethystHoeItem extends HafniumModElements.ModElement {

	@ObjectHolder("hafnium:amethyst_hoe")
	public static final Item block = null;

	public AmethystHoeItem(HafniumModElements instance) {
		super(instance, 248);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
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
		}, 0, -3f, new Item.Properties().group(ItemGroup.TOOLS)) {

		}.setRegistryName("amethyst_hoe"));
	}

}
