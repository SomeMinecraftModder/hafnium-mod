package net.mcreator.hafnium.procedures;

import net.minecraftforge.eventbus.api.Event;

public class LobbyProcedureProcedure {

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("entity") == null) {
				if(!dependencies.containsKey("entity"))
					HafniumMod.LOGGER.warn("Failed to load dependency entity for procedure LobbyProcedure!");
				return;
			}

				Entity entity = (Entity) dependencies.get("entity");


		{
	Entity _ent = entity;
    _ent.setPositionAndUpdate(,,);
    if (_ent instanceof ServerPlayerEntity) {
    	((ServerPlayerEntity) _ent).connection.setPlayerLocation(, , , _ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
    }
}
	}

}
