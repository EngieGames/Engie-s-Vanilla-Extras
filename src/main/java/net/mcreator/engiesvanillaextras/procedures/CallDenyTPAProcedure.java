package net.mcreator.engiesvanillaextras.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandFunction;

import java.util.Optional;

public class CallDenyTPAProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			Entity _ent = entity;
			if (!_ent.level.isClientSide() && _ent.getServer() != null) {
				Optional<CommandFunction> _fopt = _ent.getServer().getFunctions().get(new ResourceLocation("engiesvanillaextras:deny_tpa"));
				if (_fopt.isPresent())
					_ent.getServer().getFunctions().execute(_fopt.get(), _ent.createCommandSourceStack());
			}
		}
		{
			Entity _ent = entity;
			if (!_ent.level.isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(
						new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
								_ent.level.getServer(), _ent),
						"tellraw @a[tag=tpa.target] [\"\"{\"text\":\"You have denied \",\"color\":\"red\"},{\"selector\":\"@a[tag=tpa.sender]\",\"color\":\"yellow\"},{\"text\":\"'s teleport request.\",\"color\":\"red\"}]");
			}
		}
		{
			Entity _ent = entity;
			if (!_ent.level.isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands()
						.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(),
								_ent.getDisplayName(), _ent.level.getServer(), _ent),
								"tellraw @a[tag=tpa.sender] [\"\",{\"selector\":\"@a[tag=tpa.target,limit=1]\",\"color\":\"yellow\"},{\"text\":\" has denied your teleport request.\",\"color\":\"red\"}]");
			}
		}
	}
}
