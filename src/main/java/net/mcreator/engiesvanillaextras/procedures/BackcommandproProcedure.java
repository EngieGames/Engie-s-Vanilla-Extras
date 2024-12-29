package net.mcreator.engiesvanillaextras.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.CommandEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.engiesvanillaextras.network.EngiesvanillaextrasModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BackcommandproProcedure {
	@SubscribeEvent
	public static void onCommand(CommandEvent event) {
		Entity entity = event.getParseResults().getContext().getSource().getEntity();
		if (entity != null) {
			execute(event, entity);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		{
			Entity _ent = entity;
			_ent.teleportTo(((entity.getCapability(EngiesvanillaextrasModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EngiesvanillaextrasModVariables.PlayerVariables())).xcooard),
					((entity.getCapability(EngiesvanillaextrasModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EngiesvanillaextrasModVariables.PlayerVariables())).ycooard),
					((entity.getCapability(EngiesvanillaextrasModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EngiesvanillaextrasModVariables.PlayerVariables())).zcooard));
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport(((entity.getCapability(EngiesvanillaextrasModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EngiesvanillaextrasModVariables.PlayerVariables())).xcooard),
						((entity.getCapability(EngiesvanillaextrasModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EngiesvanillaextrasModVariables.PlayerVariables())).ycooard),
						((entity.getCapability(EngiesvanillaextrasModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EngiesvanillaextrasModVariables.PlayerVariables())).zcooard), _ent.getYRot(), _ent.getXRot());
		}
	}
}
