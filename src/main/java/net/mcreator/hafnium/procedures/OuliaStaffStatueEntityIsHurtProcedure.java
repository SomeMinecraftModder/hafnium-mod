package net.mcreator.hafnium.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.hafnium.HafniumMod;

import java.util.Map;

public class OuliaStaffStatueEntityIsHurtProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				HafniumMod.LOGGER.warn("Failed to load dependency entity for procedure OuliaStaffStatueEntityIsHurt!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.setMotion(0, 0, 0);
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.INSTANT_HEALTH, (int) 60, (int) 10, (false), (false)));
	}
}
