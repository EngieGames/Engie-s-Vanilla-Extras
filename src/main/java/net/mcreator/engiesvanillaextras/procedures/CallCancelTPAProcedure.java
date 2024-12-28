package net.mcreator.engiesvanillaextras.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.commands.CommandFunction;

import java.util.Optional;

public class CallCancelTPAProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			Entity _ent = entity;
			if (!_ent.level.isClientSide() && _ent.getServer() != null) {
				Optional<CommandFunction> _fopt = _ent.getServer().getFunctions().get(new ResourceLocation("engiesvanillaextras:cancel_tpa"));
				if (_fopt.isPresent())
					_ent.getServer().getFunctions().execute(_fopt.get(), _ent.createCommandSourceStack());
			}
		}
		{
			Entity _ent = entity;
			if (!_ent.level.isClientSide() && _ent.getServer() != null) {
				Optional<CommandFunction> _fopt = _ent.getServer().getFunctions()
						.get(new ResourceLocation("execute if entity @s[tag=tpa.cancelsender] run tellraw @s {\"text\":\"you have cancelled your previous teleport request.\",\"color\":\"red\"}"));
				if (_fopt.isPresent())
					_ent.getServer().getFunctions().execute(_fopt.get(), _ent.createCommandSourceStack());
			}
		}
		{
			Entity _ent = entity;
			if (!_ent.level.isClientSide() && _ent.getServer() != null) {
				Optional<CommandFunction> _fopt = _ent.getServer().getFunctions().get(new ResourceLocation("execute unless entity @s[tag=tpa.cancelsender] run tellraw @s {\"text\":\"you have cancelled your teleport request.\",\"color\":\"red\"}"));
				if (_fopt.isPresent())
					_ent.getServer().getFunctions().execute(_fopt.get(), _ent.createCommandSourceStack());
			}
		}
		{
			Entity _ent = entity;
			if (!_ent.level.isClientSide() && _ent.getServer() != null) {
				Optional<CommandFunction> _fopt = _ent.getServer().getFunctions().get(new ResourceLocation(
						"execute as @a if score @s tpa.pid = @a[tag=tpa.cancelsender,limit=1] tpa.target run tellraw @s [\"\",{\"selector\":\"@a[tag=tpa.cancelsender]\",\"color\":\"red\"},{\"text\":\" has cancelled their teleport request.\",\"color\":\"red\"}]"));
				if (_fopt.isPresent())
					_ent.getServer().getFunctions().execute(_fopt.get(), _ent.createCommandSourceStack());
			}
		}
	}
}
