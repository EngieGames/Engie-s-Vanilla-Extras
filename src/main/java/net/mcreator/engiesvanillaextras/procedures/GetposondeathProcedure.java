package net.mcreator.engiesvanillaextras.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.engiesvanillaextras.network.EngiesvanillaextrasModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class GetposondeathProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity());
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = (entity instanceof ServerPlayer _player && !_player.level.isClientSide())
					? ((_player.getRespawnDimension().equals(_player.level.dimension()) && _player.getRespawnPosition() != null) ? _player.getRespawnPosition().getX() : _player.level.getLevelData().getXSpawn())
					: 0;
			entity.getCapability(EngiesvanillaextrasModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.xcooard = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = (entity instanceof ServerPlayer _player && !_player.level.isClientSide())
					? ((_player.getRespawnDimension().equals(_player.level.dimension()) && _player.getRespawnPosition() != null) ? _player.getRespawnPosition().getY() : _player.level.getLevelData().getYSpawn())
					: 0;
			entity.getCapability(EngiesvanillaextrasModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.ycooard = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = (entity instanceof ServerPlayer _player && !_player.level.isClientSide())
					? ((_player.getRespawnDimension().equals(_player.level.dimension()) && _player.getRespawnPosition() != null) ? _player.getRespawnPosition().getZ() : _player.level.getLevelData().getZSpawn())
					: 0;
			entity.getCapability(EngiesvanillaextrasModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.zcooard = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
