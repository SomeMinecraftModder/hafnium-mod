
package net.mcreator.hafnium.enchantment;

@HafniumModElements.ModElement.Tag
public class AutosmeltEnchantment extends HafniumModElements.ModElement {

	@ObjectHolder("hafnium:autosmelt")
	public static final Enchantment enchantment = null;

	public AutosmeltEnchantment(HafniumModElements instance) {
		super(instance, 273);
	}

	@Override
	public void initElements() {
		elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("autosmelt"));
	}

	public static class CustomEnchantment extends Enchantment {

		public CustomEnchantment(EquipmentSlotType... slots) {
			super(Enchantment.Rarity.RARE, EnchantmentType.WEAPON, slots);
		}

		@Override
		public int getMinLevel() {
			return 30;
		}

		@Override
		public int getMaxLevel() {
			return 100;
		}

		@Override
		public int calcModifierDamage(int level, DamageSource source) {
			return level * 1;
		}

		@Override
		public boolean isTreasureEnchantment() {
			return false;
		}

		@Override
		public boolean isCurse() {
			return false;
		}

		@Override
		public boolean isAllowedOnBooks() {
			return true;
		}

		@Override
		public boolean canGenerateInLoot() {
			return true;
		}

		@Override
		public boolean canVillagerTrade() {
			return false;
		}

	}

}
