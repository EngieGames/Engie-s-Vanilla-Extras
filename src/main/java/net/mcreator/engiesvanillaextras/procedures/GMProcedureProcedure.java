package net.mcreator.engiesvanillaextras.procedures;

import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class GMProcedureProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		if (DoubleArgumentType.getDouble(arguments, "mode") == 0) {
			if (entity instanceof ServerPlayer _player)
				_player.setGameMode(GameType.SURVIVAL);
		} else if (DoubleArgumentType.getDouble(arguments, "mode") == 1) {
			if (entity instanceof ServerPlayer _player)
				_player.setGameMode(GameType.CREATIVE);
		} else if (DoubleArgumentType.getDouble(arguments, "mode") == 2) {
			if (entity instanceof ServerPlayer _player)
				_player.setGameMode(GameType.ADVENTURE);
		} else if (DoubleArgumentType.getDouble(arguments, "mode") == 3) {
			if (entity instanceof ServerPlayer _player)
				_player.setGameMode(GameType.SPECTATOR);
		}
	}
}
