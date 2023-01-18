
package net.mcreator.hafnium.item;

@HafniumModElements.ModElement.Tag
public class MarseillaiseItem extends HafniumModElements.ModElement {

	@ObjectHolder("hafnium:marseillaise")
	public static final Item block = null;

	public MarseillaiseItem(HafniumModElements instance) {
		super(instance, 260);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	public static class MusicDiscItemCustom extends MusicDiscItem {

		public MusicDiscItemCustom() {
			super(0, HafniumModElements.sounds.get(new ResourceLocation("hafnium:marseillaise")),
					new Item.Properties().group(ItemGroup.MISC).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("marseillaise");
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}

	}

}
